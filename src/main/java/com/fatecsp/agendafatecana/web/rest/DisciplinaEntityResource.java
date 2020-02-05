package com.fatecsp.agendafatecana.web.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatecsp.agendafatecana.disciplina.domain.DisciplinaEntity;
import com.fatecsp.agendafatecana.disciplina.service.DisciplinaEntityService;


/**
 * DisciplinaEntityService
 */
@RestController
@RequestMapping("/api")
public class DisciplinaEntityResource {
	private final Logger log = LoggerFactory.getLogger(DisciplinaEntityResource.class);

    @Autowired
    DisciplinaEntityService disciplinaService;

    @PostMapping("/disciplina")
    public DisciplinaEntity salvarDisciplina(@RequestBody DisciplinaEntity e) {        
        log.info("chamada ao metodo salvarDisciplina - DisciplinaEntity : ()", e);
        return disciplinaService.salvarDisciplina(e);
    }

    @PutMapping("/disciplina")
    public DisciplinaEntity atualizarDisciplina(@RequestBody DisciplinaEntity e) {        
        log.info("chamada ao metodo alterarDisciplina - DisciplinaEntity : ()", e);
        return disciplinaService.atualizarDisciplina(e);
    }

    @DeleteMapping("/disciplina")
    public DisciplinaEntity deletarDisciplina(@RequestBody DisciplinaEntity e) {        
        log.info("chamada ao metodo deletarDisciplina - DisciplinaEntity : ()", e);
        return disciplinaService.deletarDisciplina(e);
    }

    @DeleteMapping("/disciplina_id")
    public void deletarDisciplinaPorId(@RequestBody String id) {        
        log.info("chamada ao metodo deletarDisciplinaPorId - ID : ()", id);
        disciplinaService.deletarDisciplinaPorId(id);
    }
    
    @GetMapping("/disciplina/filtro")
    public List<DisciplinaEntity> recuperarPorMapaDePropredades(@RequestBody Map<String, List<Object>> mapaDePropriedades){
    	log.info("chamada ao metodo recuperarPorMapaDePropredades - mapaDePropriedades : {}", mapaDePropriedades);
    	return disciplinaService.recuperarPorMapaDePropredades(mapaDePropriedades);
    }
    
    
}