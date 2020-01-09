package com.fatecsp.agendafatecana.usuario.aluno.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatecsp.agendafatecana.usuario.aluno.Falta;
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
        if (e.getId() != null) throw new RuntimeException("A entidade não pode ter id nulo");
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
        return aluno;
	}

    private AlunoEntity recuperarPorMatricula(String matricula) {
        Objects.requireNonNull(matricula, "A matrícula não pode ser nula");
        Map<String, Object> propriedades = new HashMap<>();
        propriedades.put("matricula", matricula);
        return alunoQueryService.recuperarPorMapaDePropriedades(propriedades);
    }
}