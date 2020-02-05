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

import com.fatecsp.agendafatecana.curso.domain.CursoEntity;
import com.fatecsp.agendafatecana.curso.service.CursoEntityService;


/**
 * CursoEntityResource
 */
@RestController
@RequestMapping("/api")
public class CursoEntityResource {
	private final Logger log = LoggerFactory.getLogger(CursoEntityResource.class);

    @Autowired
    CursoEntityService cursoService;

    @PostMapping("/curso")
    public CursoEntity salvarCurso(@RequestBody CursoEntity e) {        
        log.info("chamada ao metodo salvarCurso - CursoEntity : ()", e);
        return cursoService.salvarCurso(e);
    }

    @PutMapping("/curso")
    public CursoEntity atualizarCurso(@RequestBody CursoEntity e) {        
        log.info("chamada ao metodo alterarCurso - CursoEntity : ()", e);
        return cursoService.atualizarCurso(e);
    }

    @DeleteMapping("/curso")
    public CursoEntity deletarCurso(@RequestBody CursoEntity e) {        
        log.info("chamada ao metodo deletarCurso - CursoEntity : ()", e);
        return cursoService.deletarCurso(e);
    }

    @DeleteMapping("/curso_id")
    public void deletarCursoPorId(@RequestBody String id) {        
        log.info("chamada ao metodo deletarCursoPorId - ID : ()", id);
        cursoService.deletarCursoPorId(id);
    }
    
    @GetMapping("/curso/filtro")
    public List<CursoEntity> recuperarPorMapaDePropredades(@RequestBody Map<String, List<Object>> mapaDePropriedades){
    	log.info("chamada ao metodo recuperarPorMapaDePropredades - mapaDePropriedades : {}", mapaDePropriedades);
    	return cursoService.recuperarPorMapaDePropredades(mapaDePropriedades);
    }
    
    
}