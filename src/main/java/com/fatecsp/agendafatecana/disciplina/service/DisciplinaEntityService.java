package com.fatecsp.agendafatecana.disciplina.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.fatecsp.agendafatecana.disciplina.domain.DisciplinaEntity;

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
        e.setId(ObjectId.get().toString());
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
    
    @Transactional
    public DisciplinaEntity recuperarPorID(String id) {
        return disciplinaQueryService.recuperarPorId(id);
    }
    
	public List<DisciplinaEntity> recuperarPorMapaDePropredades(Map<String, List<Object>> mapaDePropriedades) {
		if (CollectionUtils.isEmpty(mapaDePropriedades)) return new ArrayList<>();
		return disciplinaQueryService.recuperarTodosPorMapaDePropriedadesFiltro(mapaDePropriedades, DisciplinaEntity.class);
	}
}