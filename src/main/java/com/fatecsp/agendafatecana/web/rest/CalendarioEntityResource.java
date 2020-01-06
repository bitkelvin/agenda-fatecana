package com.fatecsp.agendafatecana.web.rest;

import com.fatecsp.agendafatecana.calendario.domain.CalendarioEntity;
import com.fatecsp.agendafatecana.calendario.service.CalendarioEntityService;

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
 * CalendarioEntityResource
 */
@RestController
@RequestMapping("/api")
public class CalendarioEntityResource {
	private final Logger log = LoggerFactory.getLogger(CalendarioEntityResource.class);

    @Autowired
    CalendarioEntityService calendarioService;

    @PostMapping("/calendario")
    public CalendarioEntity salvarCalendario(@RequestBody CalendarioEntity e) {        
        log.info("chamada ao metodo salvarCalendario - CalendarioEntity : ()", e);
        return calendarioService.salvarCalendario(e);
    }

    @PutMapping("/calendario")
    public CalendarioEntity atualizarCalendario(@RequestBody CalendarioEntity e) {        
        log.info("chamada ao metodo alterarCalendario - CalendarioEntity : ()", e);
        return calendarioService.atualizarCalendario(e);
    }

    @DeleteMapping("/calendario")
    public CalendarioEntity deletarCalendario(@RequestBody CalendarioEntity e) {        
        log.info("chamada ao metodo deletarCalendario - CalendarioEntity : ()", e);
        return calendarioService.deletarCalendario(e);
    }

    @DeleteMapping("/calendario_id")
    public void deletarCalendarioPorId(@RequestBody String id) {        
        log.info("chamada ao metodo deletarCalendarioPorId - ID : ()", id);
        calendarioService.deletarCalendarioPorId(id);
    }
    
    
}