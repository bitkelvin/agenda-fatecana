package com.fatecsp.agendafatecana.disciplina.service;

import com.fatecsp.agendafatecana.disciplina.domain.DisciplinaEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * DisciplinaEntityService
 */
@Service
public class DisciplinaEntityService {

    @Autowired
    DisciplinaEntityQueryService disciplinaQueryService;

    @Transactional
    public DisciplinaEntity salvarDisciplina(DisciplinaEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode conter um ID");
        return disciplinaQueryService.salvarDisciplina(e);
    }

    @Transactional
    public DisciplinaEntity atualizarDisciplina(DisciplinaEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode ter id nulo");
        return disciplinaQueryService.salvarDisciplina(e);
    }

    @Transactional
    public DisciplinaEntity deletarDisciplina(DisciplinaEntity e) {
        disciplinaQueryService.deletarDisciplina(e);
        return e;
    }

    @Transactional
    public void deletarDisciplinaPorId(String id) {
        disciplinaQueryService.deletarDisciplinaPorId(id);
    }
}