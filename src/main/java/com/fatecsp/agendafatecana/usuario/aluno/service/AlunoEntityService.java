package com.fatecsp.agendafatecana.usuario.aluno.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.fatecsp.agendafatecana.evento.Evento;
import com.fatecsp.agendafatecana.usuario.aluno.Falta;
import com.fatecsp.agendafatecana.usuario.aluno.Nota;
import com.fatecsp.agendafatecana.usuario.aluno.domain.AlunoEntity;

/**
 * AlunoEntityService
 */
@Service
public class AlunoEntityService {

    @Autowired
    AlunoEntityQueryService alunoQueryService;

    @Transactional
    public AlunoEntity salvarAluno(AlunoEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode conter um ID");
        e.setId(ObjectId.get().toString());
        return alunoQueryService.salvarAluno(e);
    }

    @Transactional
    public AlunoEntity atualizarAluno(AlunoEntity e) {
        if (e.getId() == null) throw new RuntimeException("A entidade não pode ter id nulo");
        return alunoQueryService.salvarAluno(e);
    }

    @Transactional
    public AlunoEntity deletarAluno(AlunoEntity e) {
        alunoQueryService.deletarAluno(e);
        return e;
    }

    @Transactional
    public void deletarAlunoPorId(String id) {
        alunoQueryService.deletarAlunoPorId(id);
    }

	public AlunoEntity atualizarFaltas(String matricula, List<Falta> faltas) {
        AlunoEntity aluno = recuperarPorMatricula(matricula);
        if (Objects.nonNull(aluno)) aluno.setFaltas(faltas);
        return atualizarAluno(aluno);
	}

    public AlunoEntity recuperarPorMatricula(String matricula) {
        Objects.requireNonNull(matricula, "A matrícula não pode ser nula");
        Map<String, Object> propriedades = new HashMap<>();
        propriedades.put("matricula", matricula);
        return alunoQueryService.recuperarPorMapaDePropriedades(propriedades, AlunoEntity.class);
    }

	public AlunoEntity atualizarNotas(String matricula, List<Nota> notas) {
        AlunoEntity aluno = recuperarPorMatricula(matricula);
        if (Objects.nonNull(aluno)) aluno.setNotas(notas);
        return aluno;
	}

	public AlunoEntity salvarEvento(String matricula, Evento evento) {
        Objects.requireNonNull(matricula, "A matrícula não pode ser nula");
        Objects.requireNonNull(evento, "O evento não pode ser nulo");
        evento.setId(ObjectId.get().toString());
        AlunoEntity aluno = recuperarPorMatricula(matricula);
        if (aluno == null) throw new RuntimeException("Não foi encontrado registro de aluno com a matrícula " + matricula);
        if (CollectionUtils.isEmpty(aluno.getEventos())) aluno.setEventos(new ArrayList<>());
        evento.setEditavel(true);
        aluno.getEventos().add(evento);
        return atualizarAluno(aluno);
	}
	
	public AlunoEntity deletarEvento(String matricula, String idEvento) {
		Objects.requireNonNull(matricula, "A matricula não pode ser nula.");
		Objects.requireNonNull(idEvento, "o id do evento não pode ser nulo.");
		AlunoEntity aluno = recuperarPorMatricula(matricula);
        if (aluno == null) throw new RuntimeException("Não foi encontrado registro de aluno com a matrícula " + matricula);
        if (!CollectionUtils.isEmpty(aluno.getEventos())) {
        	if (aluno.getEventos().removeIf(e -> e.getId().equals(idEvento))) return aluno;        	
        }
        throw new RuntimeException("Não foi encontrado um evento com o id " + idEvento);
	}
	
	public AlunoEntity atualizarEvento(String matricula, Evento evento) {
		Objects.requireNonNull(matricula, "A matricula não pode ser nula.");
		Objects.requireNonNull(evento, "o evento não pode ser nulo.");
		Objects.requireNonNull(evento.getId(), "o id do evento não pode ser nulo.");
		AlunoEntity aluno = recuperarPorMatricula(matricula);
        if (aluno == null) throw new RuntimeException("Não foi encontrado registro de aluno com a matrícula " + matricula);
        if (!CollectionUtils.isEmpty(aluno.getEventos())) {
        	if (aluno.getEventos().removeIf(e -> e.getId().equals(evento.getId()))) {
        		aluno.getEventos().add(evento);
        		return aluno;
        	}
        }
        throw new RuntimeException("Não foi encontrado um evento com o id " + evento.getId());
	}
}