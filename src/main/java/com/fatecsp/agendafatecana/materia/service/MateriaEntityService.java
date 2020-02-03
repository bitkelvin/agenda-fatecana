package com.fatecsp.agendafatecana.materia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.fatecsp.agendafatecana.aula.Aula;
import com.fatecsp.agendafatecana.calendario.domain.CalendarioEntity;
import com.fatecsp.agendafatecana.calendario.domain.Dia;
import com.fatecsp.agendafatecana.calendario.domain.Mes;
import com.fatecsp.agendafatecana.calendario.service.CalendarioEntityService;
import com.fatecsp.agendafatecana.comparator.MesComparator;
import com.fatecsp.agendafatecana.disciplina.domain.DisciplinaEntity;
import com.fatecsp.agendafatecana.disciplina.service.DisciplinaEntityService;
import com.fatecsp.agendafatecana.enumerated.DiaSemanaEnum;
import com.fatecsp.agendafatecana.enumerated.PeriodoAulaEnum;
import com.fatecsp.agendafatecana.materia.HorarioMateria;
import com.fatecsp.agendafatecana.materia.domain.MateriaEntity;

/**
 * MateriaEntityService
 */
@Service
public class MateriaEntityService {

    @Autowired
    MateriaEntityQueryService materiaQueryService;
    
    @Autowired
    DisciplinaEntityService disciplinaService;
    
    @Autowired
    CalendarioEntityService calendarioService;

    @Transactional
    public MateriaEntity salvarMateria(MateriaEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode conter um ID");
        e.setId(ObjectId.get().toString());
        return materiaQueryService.salvarMateria(e);
    }

    @Transactional
    public MateriaEntity atualizarMateria(MateriaEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode ter id nulo");
        return materiaQueryService.salvarMateria(e);
    }

    @Transactional
    public MateriaEntity deletarMateria(MateriaEntity e) {
        materiaQueryService.deletarMateria(e);
        return e;
    }

    @Transactional
    public void deletarMateriaPorId(String id) {
        materiaQueryService.deletarMateriaPorId(id);
    }
    
    @Transactional
    public MateriaEntity criarMateria(String codigo, Integer ano, Integer semestre, PeriodoAulaEnum periodo, String disciplina, List<HorarioMateria> horarios) {
    	DisciplinaEntity disciplinaEntity = disciplinaService.recuperarPorID(disciplina);
    	Objects.requireNonNull(disciplinaEntity, "Não foi encontrada disciplina com o id.");
    	if (CollectionUtils.isEmpty(horarios)) throw new RuntimeException("O horario não pode ser vazio ou nulo.");
    	
    	BigDecimal minutosTotais = BigDecimal.valueOf(disciplinaEntity.getCargaHoraria()).multiply(new BigDecimal("60"));
    	BigDecimal qtdPeriodos = minutosTotais.divide(new BigDecimal("55"), 5, BigDecimal.ROUND_UP);
    	
    	CalendarioEntity calendario = calendarioService.recuperarPorAnoESemetrste(ano, semestre);
    	if (calendario == null) throw new RuntimeException("Não foi encontrado o cadastro do calendario do ano " + ano + " e semestre " + semestre);
    	
    	List<Aula> aulas = new ArrayList<>();
    	
    	List<DiaSemanaEnum> diasDaSemanaDeAula = horarios.stream().map(h -> h.getDia()).distinct().collect(Collectors.toList());

    	for (Mes mes : calendario.getMeses().stream().sorted(new MesComparator()).collect(Collectors.toList())) {
    		
			if (qtdPeriodos.compareTo(BigDecimal.ZERO) <= 0) break;
			
    		List<Dia> dias = mes.getDias().stream()
    				.filter(d -> diasDaSemanaDeAula.contains(d.getDiaDaSemana()) && d.isLetivo())
    				.sorted(Comparator.comparing(Dia::getDia).reversed())
    				.collect(Collectors.toList());
    		
    		for (Dia d : dias) {    			
    			List<HorarioMateria> horariosNesteDia = horarios.stream().filter(h -> h.getDia().equals(d.getDiaDaSemana())).collect(Collectors.toList());
    			for (HorarioMateria h : horariosNesteDia) {    				
    				if (qtdPeriodos.compareTo(BigDecimal.ZERO) <= 0) break;
    				
    				LocalDateTime horaInicio = LocalDateTime.of(ano, mes.getMes().ordinal()+1, d.getDia(), h.getHoraInicio().getHour(), h.getHoraInicio().getMinute());
    				LocalDateTime horaFim = LocalDateTime.of(ano, mes.getMes().ordinal()+1, d.getDia(), h.getHoraFim().getHour(), h.getHoraFim().getMinute());
    				
    				Aula aula = new Aula();
    				aula.setInicio(horaInicio);
    				aula.setFim(horaFim);
    				aula.setPresencial(true);
    				
    				qtdPeriodos.subtract(BigDecimal.valueOf(h.getPeriodos()));
    				
    				aulas.add(aula);
    			}
    		}
    	}
    	
    	MateriaEntity materia = MateriaEntity.builder()
    								.ano(ano)
    								.aulas(aulas)
    								.codigo(codigo)
    								.disciplina(disciplina)
    								.horario(horarios)
    								.periodo(periodo)
    								.semestre(semestre)
    								.build();
    	
    	return salvarMateria(materia);
    }

	public List<MateriaEntity> recuperarPorId(List<String> ids) {
		if (CollectionUtils.isEmpty(ids)) return new ArrayList<>();
		return materiaQueryService.recuperarPorIds(ids);
	}

	public List<MateriaEntity> findAll() {
		return materiaQueryService.findAll();
	}
}