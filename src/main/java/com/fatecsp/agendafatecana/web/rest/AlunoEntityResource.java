package com.fatecsp.agendafatecana.web.rest;

import java.util.List;
import java.util.Map;

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

import com.fatecsp.agendafatecana.evento.Evento;
import com.fatecsp.agendafatecana.usuario.aluno.Falta;
import com.fatecsp.agendafatecana.usuario.aluno.Nota;
import com.fatecsp.agendafatecana.usuario.aluno.domain.AlunoEntity;
import com.fatecsp.agendafatecana.usuario.aluno.service.AlunoEntityService;

import io.swagger.v3.oas.annotations.Operation;


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
    @Operation(method = "PUT", description = "Atualiza a lista de faltas de um aluno")
    public AlunoEntity atualizarFaltas(@RequestBody List<Falta> faltas, @RequestParam String matricula) {        
        log.info("chamada ao metodo atualizarFaltas - matricula : {}, faltas : {}", matricula, faltas);
        return alunoService.atualizarFaltas(matricula, faltas);
    }
    
    @PutMapping("/aluno/notas")
    @Operation(method = "PUT", description = "Atualiza a lista de notas de um aluno")
    public AlunoEntity atualizarNotas(@RequestBody List<Nota> notas, @RequestParam String matricula) {        
        log.info("chamada ao metodo atualizarNotas - matricula : {}, faltas : {}", matricula, notas);
        return alunoService.atualizarNotas(matricula, notas);
    }
    
    @PostMapping("/aluno/evento")
    @Operation(method = "POST", description = "Adiciona um evento a um aluno")
    public AlunoEntity salvarEvento(@RequestBody Evento evento, @RequestParam String matricula) {        
        log.info("chamada ao metodo salvarEvento - matricula : {}, evento : {}", matricula, evento);
        return alunoService.salvarEvento(matricula, evento);
    }
    
    @PutMapping("/aluno/evento")
    @Operation(method = "PUT", description = "Atualiza um evento de um aluno")
    public AlunoEntity atualizarEvento(@RequestBody Evento evento, @RequestParam String matricula) {        
        log.info("chamada ao metodo atualizarEvento - matricula : {}, evento : {}", matricula, evento);
        return alunoService.atualizarEvento(matricula, evento);
    }
    
    @DeleteMapping("/aluno/evento")
    @Operation(method = "DELETE", description = "Deleta um evento de um aluno")
    public AlunoEntity deletarEvento(@RequestBody String idEvento, @RequestParam String matricula) {        
        log.info("chamada ao metodo deletarEvento - matricula : {}, idEvento : {}", matricula, idEvento);
        return alunoService.deletarEvento(matricula, idEvento);
    }
    
    @PostMapping("/aluno/filtro")
    public List<AlunoEntity> recuperarPorMapaDePropredades(@RequestBody Map<String, List<Object>> mapaDePropriedades){
    	log.info("chamada ao metodo recuperarPorMapaDePropredades - mapaDePropriedades : {}", mapaDePropriedades);
    	return alunoService.recuperarPorMapaDePropredades(mapaDePropriedades);
    }
    
}