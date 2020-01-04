package com.fatecsp.agendafatecana.curso.service;

import com.fatecsp.agendafatecana.curso.domain.CursoEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CursoEntityService
 */
@Service
public class CursoEntityService {

    @Autowired
    CursoEntityQueryService cursoQueryService;

    @Transactional
    public CursoEntity salvarCurso(CursoEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode conter um ID");
        return cursoQueryService.salvarCurso(e);
    }

    @Transactional
    public CursoEntity atualizarCurso(CursoEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode ter id nulo");
        return cursoQueryService.salvarCurso(e);
    }

    @Transactional
    public CursoEntity deletarCurso(CursoEntity e) {
        cursoQueryService.deletarCurso(e);
        return e;
    }

    @Transactional
    public void deletarCursoPorId(String id) {
        cursoQueryService.deletarCursoPorId(id);
    }
}