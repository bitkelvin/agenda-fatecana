package com.fatecsp.agendafatecana.web.rest;

import com.fatecsp.agendafatecana.usuario.professor.domain.ProfessorEntity;
import com.fatecsp.agendafatecana.usuario.professor.service.ProfessorEntityService;

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
 * ProfessorEntityResource
 */
@RestController
@RequestMapping("/api")
public class ProfessorEntityResource {
	private final Logger log = LoggerFactory.getLogger(ProfessorEntityResource.class);

    @Autowired
    ProfessorEntityService professorService;

    @PostMapping("/professor")
    public ProfessorEntity salvarProfessor(@RequestBody ProfessorEntity e) {        
        log.info("chamada ao metodo salvarProfessor - ProfessorEntity : ()", e);
        return professorService.salvarProfessor(e);
    }

    @PutMapping("/professor")
    public ProfessorEntity atualizarProfessor(@RequestBody ProfessorEntity e) {        
        log.info("chamada ao metodo alterarProfessor - ProfessorEntity : ()", e);
        return professorService.atualizarProfessor(e);
    }

    @DeleteMapping("/professor")
    public ProfessorEntity deletarProfessor(@RequestBody ProfessorEntity e) {        
        log.info("chamada ao metodo deletarProfessor - ProfessorEntity : ()", e);
        return professorService.deletarProfessor(e);
    }

    @DeleteMapping("/professor")
    public void deletarProfessorPorId(@RequestBody String id) {        
        log.info("chamada ao metodo deletarProfessorPorId - ID : ()", id);
        professorService.deletarProfessorPorId(id);
    }
    
    
}