package com.fatecsp.agendafatecana.curso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.fatecsp.agendafatecana.curso.domain.CursoEntity;

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
        e.setId(ObjectId.get().toString());
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
    
	public List<CursoEntity> recuperarPorMapaDePropredades(Map<String, List<Object>> mapaDePropriedades) {
		if (CollectionUtils.isEmpty(mapaDePropriedades)) return new ArrayList<>();
		return cursoQueryService.recuperarTodosPorMapaDePropriedadesFiltro(mapaDePropriedades, CursoEntity.class);
	}
}