package com.fatecsp.agendafatecana.web.rest;

import com.fatecsp.agendafatecana.materia.domain.MateriaEntity;
import com.fatecsp.agendafatecana.materia.service.MateriaEntityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * MateriaEntityService
 */
@RestController
@RequestMapping("/api")
public class MateriaEntityResource {
	private final Logger log = LoggerFactory.getLogger(MateriaEntityResource.class);

    @Autowired
    MateriaEntityService materiaService;

    @PostMapping("/materia")
    public MateriaEntity salvarMateria(@RequestBody MateriaEntity e) {        
        log.info("chamada ao metodo salvarMateria - MateriaEntity : ()", e);
        return materiaService.salvarMateria(e);
    }

    @PutMapping("/materia")
    public MateriaEntity atualizarMateria(@RequestBody MateriaEntity e) {        
        log.info("chamada ao metodo alterarMateria - MateriaEntity : ()", e);
        return materiaService.atualizarMateria(e);
    }

    @DeleteMapping("/materia")
    public MateriaEntity deletarMateria(@RequestBody MateriaEntity e) {        
        log.info("chamada ao metodo deletarMateria - MateriaEntity : ()", e);
        return materiaService.deletarMateria(e);
    }

    @DeleteMapping("/materia_id")
    public void deletarMateriaPorId(@RequestBody String id) {        
        log.info("chamada ao metodo deletarMateriaPorId - ID : ()", id);
        materiaService.deletarMateriaPorId(id);
    }
    
    
}