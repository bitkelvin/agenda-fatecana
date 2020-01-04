package com.fatecsp.agendafatecana.calendario.service;

import com.fatecsp.agendafatecana.calendario.domain.CalendarioEntity;
import com.fatecsp.agendafatecana.repository.CalendarioEntityRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * CalendarioEntityQueryService
 */
@Service
public class CalendarioEntityQueryService {
    private final Logger log = LoggerFactory.getLogger(CalendarioEntityQueryService.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    CalendarioEntityRepository calendarioRepository;

    public CalendarioEntity salvarCalendario(CalendarioEntity e) {        
        log.debug("chamada ao queryService salvarCalendario id: {}", e.getId());
        return calendarioRepository.save(e);
    }

    public void deletarCalendario(CalendarioEntity e) {
        log.debug("chamada ao queryService deletarCalendario id: {}", e.getId());
        calendarioRepository.delete(e);
    }
    
    public void deletarCalendarioPorId(String id) {
        log.debug("chamada ao queryService deletarCalendarioPorId id: {}", id);
        calendarioRepository.deleteById(id);
    }

    /**
     * Procura uma Calendario por ID
     * @param id
     * @return a CalendarioEntity (RETORNA NULO SE NÃO ENCONTRAR)
     */
    public CalendarioEntity recuperarPorId(String id) {        
        log.debug("chamada ao queryService recuperarPorId id: {}", id);
        return calendarioRepository.findById(id).orElse(null);
    }

}