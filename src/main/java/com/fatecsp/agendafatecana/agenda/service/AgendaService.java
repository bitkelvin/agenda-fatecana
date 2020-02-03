package com.fatecsp.agendafatecana.agenda.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatecsp.agendafatecana.adapter.AgendaDTOAdapter;
import com.fatecsp.agendafatecana.agenda.dto.AgendaDTO;
import com.fatecsp.agendafatecana.calendario.domain.CalendarioEntity;
import com.fatecsp.agendafatecana.calendario.service.CalendarioEntityService;
import com.fatecsp.agendafatecana.materia.domain.MateriaEntity;
import com.fatecsp.agendafatecana.materia.service.MateriaEntityService;
import com.fatecsp.agendafatecana.usuario.aluno.domain.AlunoEntity;
import com.fatecsp.agendafatecana.usuario.aluno.service.AlunoEntityService;
import com.fatecsp.agendafatecana.usuario.professor.service.ProfessorEntityService;

@Service
public class AgendaService {

	@Autowired
	AlunoEntityService alunoService;
	
	@Autowired
	ProfessorEntityService professorService;
	
	@Autowired
	CalendarioEntityService calendarioService;
	
	@Autowired
	MateriaEntityService materiaService;
	
	
	
	public AgendaService() {
		super();
	}



	public AgendaService(AlunoEntityService alunoService, ProfessorEntityService professorService,
			CalendarioEntityService calendarioService, MateriaEntityService materiaService) {
		super();
		this.alunoService = alunoService;
		this.professorService = professorService;
		this.calendarioService = calendarioService;
		this.materiaService = materiaService;
	}



	public AgendaDTO gerarAgendaAluno(String matricula, Integer ano, Integer semestre) {
		
		Objects.requireNonNull(matricula, "Matricula não pode ser nulo.");
		
		AlunoEntity aluno = alunoService.recuperarPorMatricula(matricula);
		if (!Objects.nonNull(aluno)) throw new RuntimeException("Ocorreu um problema ao recuperar o aluno com maricula" + matricula);
		
		List<MateriaEntity> materias = materiaService.recuperarPorId(aluno.getMaterias());
		
		CalendarioEntity calendario = calendarioService.recuperarPorAnoESemetrste(ano, semestre);
		if (!Objects.nonNull(calendario)) throw new RuntimeException("Não foi encontrado calendario cadastrado para o ano " + ano + " e semestre " + semestre);
		
		return AgendaDTOAdapter.toAgendaAluno(aluno, materias, calendario);
	}
	
}
