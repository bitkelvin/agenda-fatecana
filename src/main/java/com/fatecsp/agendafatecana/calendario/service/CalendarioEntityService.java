package com.fatecsp.agendafatecana.calendario.service;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatecsp.agendafatecana.calendario.domain.CalendarioEntity;
import com.fatecsp.agendafatecana.calendario.domain.Dia;
import com.fatecsp.agendafatecana.calendario.domain.Mes;
import com.fatecsp.agendafatecana.enumerated.DiaSemanaEnum;
import com.fatecsp.agendafatecana.enumerated.MesEnum;

/**
 * CalendarioEntityService
 */
@Service
public class CalendarioEntityService {

    @Autowired
    CalendarioEntityQueryService calendarioQueryService;

    @Transactional
    public CalendarioEntity salvarCalendario(CalendarioEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode conter um ID");
        e.setId(ObjectId.get().toString());
        return calendarioQueryService.salvarCalendario(e);
    }

    @Transactional
    public CalendarioEntity atualizarCalendario(CalendarioEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode ter id nulo");
        return calendarioQueryService.salvarCalendario(e);
    }

    @Transactional
    public CalendarioEntity deletarCalendario(CalendarioEntity e) {
        calendarioQueryService.deletarCalendario(e);
        return e;
    }

    @Transactional
    public void deletarCalendarioPorId(String id) {
        calendarioQueryService.deletarCalendarioPorId(id);
    }
    
    @Transactional
    public CalendarioEntity recuperarPorAnoESemetrste(Integer ano, Integer semestre) {
    	Map<String, Object> propriedades = new HashMap<>();
    	propriedades.put("ano", ano);
    	propriedades.put("semestre", semestre);
    	return calendarioQueryService.recuperarPorMapaDePropriedades(propriedades, CalendarioEntity.class);
    }
    
    @Transactional
    public CalendarioEntity gerarCalendario(Integer ano, Integer semestre) {
    	
    	Objects.requireNonNull(ano, "O ano não pode ser nulo.");
    	Objects.requireNonNull(semestre, "O semestre não pode ser nulo.");
    	
    	Map<String, Object> propriedades = new HashMap<>();
    	propriedades.put("ano", ano);
    	propriedades.put("semestre", semestre);
    	if (calendarioQueryService.recuperarPorMapaDePropriedades(propriedades, CalendarioEntity.class) != null) {
    		throw new RuntimeException("Já foi gerado o calendario para o ano " + ano + " e semestre " + semestre + ".");
    	} else if (semestre < 1 || semestre > 2) {
    		throw new RuntimeException("O semestre deve ser 1 ou 2.");
    	} else {
    		CalendarioEntity calendario = new CalendarioEntity();
    		
    		List<Mes> meses = new ArrayList<>();
    		for (int i = (semestre == 1 ? 1 : 7); i <= (6*semestre); i++) {
    			
    			Mes mesEntity = new Mes();
    			
    			mesEntity.setMes(MesEnum.values()[i-1]);
    			
    			YearMonth ym = YearMonth.of(ano, i);
    			
    			Calendar cal = Calendar.getInstance();
    			
    			List<Dia> dias = new ArrayList<>();
    			for (int y = 1; y <= ym.lengthOfMonth(); y++) {
    				Dia dia = new Dia();
    				dia.setDia(y);
    				cal.set(ano, i-1, y);
    				dia.setDiaDaSemana(DiaSemanaEnum.values()[cal.get(Calendar.DAY_OF_WEEK) -1]);
    				dia.setLetivo(!dia.getDiaDaSemana().equals(DiaSemanaEnum.DOMINGO));
    				dia.setEventos(new ArrayList<>());
    				dia.setAulas(new ArrayList<>());
    				dias.add(dia);
    			}

    			mesEntity.setDias(dias);			
    			meses.add(mesEntity);			
    		}
    		
    		calendario.setMeses(meses);
    		calendario.setAno(ano);
    		calendario.setSemestre(semestre); 
    		
    		return salvarCalendario(calendario);
    	}
    }
    
}