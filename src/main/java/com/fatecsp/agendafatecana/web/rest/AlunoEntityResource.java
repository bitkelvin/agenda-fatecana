package com.fatecsp.agendafatecana.web.rest;

import com.fatecsp.agendafatecana.usuario.aluno.domain.AlunoEntity;
import com.fatecsp.agendafatecana.usuario.aluno.service.AlunoEntityService;

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
 * AlunoEntityResource
 */
@RestController
@RequestMapping("/api")
public class AlunoEntityResource {
	private final Logger log = LoggerFactory.getLogger(AlunoEntityResource.class);

    @Autowired
    AlunoEntityService alunoService;

    @PostMapping("/aluno")
    public AlunoEntity salvarAluno(@RequestBody AlunoEntity e) {        
        log.info("chamada ao metodo salvarAluno - AlunoEntity : ()", e);
        return alunoService.salvarAluno(e);
    }

    @PutMapping("/aluno")
    public AlunoEntity atualizarAluno(@RequestBody AlunoEntity e) {        
        log.info("chamada ao metodo alterarAluno - AlunoEntity : ()", e);
        return alunoService.atualizarAluno(e);
    }

    @DeleteMapping("/aluno")
    public AlunoEntity deletarAluno(@RequestBody AlunoEntity e) {        
        log.info("chamada ao metodo deletarAluno - AlunoEntity : ()", e);
        return alunoService.deletarAluno(e);
    }

    @DeleteMapping("/aluno")
    public void deletarAlunoPorId(@RequestBody String id) {        
        log.info("chamada ao metodo deletarAlunoPorId - ID : ()", id);
        alunoService.deletarAlunoPorId(id);
    }
    
    
}