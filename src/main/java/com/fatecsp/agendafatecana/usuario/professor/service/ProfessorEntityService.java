package com.fatecsp.agendafatecana.usuario.professor.service;


import com.fatecsp.agendafatecana.usuario.professor.domain.ProfessorEntity;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProfessorEntityService
 */
@Service
public class ProfessorEntityService {

    @Autowired
    ProfessorEntityQueryService professorQueryService;

    @Transactional
    public ProfessorEntity salvarProfessor(ProfessorEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode conter um ID");
        e.setId(ObjectId.get().toString());
        return professorQueryService.salvarProfessor(e);
    }

    @Transactional
    public ProfessorEntity atualizarProfessor(ProfessorEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode ter id nulo");
        return professorQueryService.salvarProfessor(e);
    }

    @Transactional
    public ProfessorEntity deletarProfessor(ProfessorEntity e) {
        professorQueryService.deletarProfessor(e);
        return e;
    }

    @Transactional
    public void deletarProfessorPorId(String id) {
        professorQueryService.deletarProfessorPorId(id);
    }
}