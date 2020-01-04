package com.fatecsp.agendafatecana.usuario.aluno.service;


import com.fatecsp.agendafatecana.usuario.aluno.domain.AlunoEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}