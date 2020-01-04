package com.fatecsp.agendafatecana.materia.service;

import com.fatecsp.agendafatecana.materia.domain.MateriaEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * MateriaEntityService
 */
@Service
public class MateriaEntityService {

    @Autowired
    MateriaEntityQueryService materiaQueryService;

    @Transactional
    public MateriaEntity salvarMateria(MateriaEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode conter um ID");
        return materiaQueryService.salvarMateria(e);
    }

    @Transactional
    public MateriaEntity atualizarMateria(MateriaEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode ter id nulo");
        return materiaQueryService.salvarMateria(e);
    }

    @Transactional
    public MateriaEntity deletarMateria(MateriaEntity e) {
        materiaQueryService.deletarMateria(e);
        return e;
    }

    @Transactional
    public void deletarMateriaPorId(String id) {
        materiaQueryService.deletarMateriaPorId(id);
    }
}