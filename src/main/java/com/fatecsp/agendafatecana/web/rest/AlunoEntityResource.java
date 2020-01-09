package com.fatecsp.agendafatecana.web.rest;

import java.util.List;

import com.fatecsp.agendafatecana.usuario.aluno.Falta;
import com.fatecsp.agendafatecana.usuario.aluno.domain.AlunoEntity;
import com.fatecsp.agendafatecana.usuario.aluno.service.AlunoEntityService;

import io.swagger.v3.oas.annotations.Operation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @DeleteMapping("/aluno_id")
    public void deletarAlunoPorId(@RequestBody String id) {        
        log.info("chamada ao metodo deletarAlunoPorId - ID : ()", id);
        alunoService.deletarAlunoPorId(id);
    }
    
    @PutMapping("/aluno/faltas")
    //TODO: colocar @ApiOperation aqui em todos os endpoint após adicionar o swagger como dependencia
    @Operation(method = "PUT", description = "Atualiza a lista de faltas de um aluno")
    public AlunoEntity atualizarFaltas(@RequestBody List<Falta> faltas, @RequestParam String matricula) {        
        log.info("chamada ao metodo atualizarFaltas - matricula : {}, faltas : {}", matricula, faltas);
        return alunoService.atualizarFaltas(matricula, faltas);
    }
    
}