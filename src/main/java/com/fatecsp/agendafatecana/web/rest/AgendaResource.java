package com.fatecsp.agendafatecana.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fatecsp.agendafatecana.agenda.dto.AgendaDTO;
import com.fatecsp.agendafatecana.agenda.service.AgendaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
public class AgendaResource {
	private final Logger log = LoggerFactory.getLogger(AgendaResource.class);
	
	@Autowired
	AgendaService agendaService;
	
	@GetMapping("/agenda/aluno")
    @Operation(method = "GET", description = "Recupera a agenda de um aluno")
    public AgendaDTO gerarAgendaAluno(@RequestParam String matricula, @RequestParam Integer ano, @RequestParam Integer semestre) {        
        log.info("chamada ao metodo gerarAgendaAluno - matricula : {}, ano : {}, semestre : {}", matricula, ano, semestre);
        return agendaService.gerarAgendaAluno(matricula, ano, semestre);
    }

}
