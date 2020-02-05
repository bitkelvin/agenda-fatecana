package com.fatecsp.agendafatecana.curso.service;

import com.fatecsp.agendafatecana.AgendaFatecanaQueryService;
import com.fatecsp.agendafatecana.curso.domain.CursoEntity;
import com.fatecsp.agendafatecana.repository.CursoEntityRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * CursoEntityQueryService
 */
@Service
public class CursoEntityQueryService extends AgendaFatecanaQueryService {
    private final Logger log = LoggerFactory.getLogger(CursoEntityQueryService.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    CursoEntityRepository cursoRepository;

    public CursoEntity salvarCurso(CursoEntity e) {        
        log.debug("chamada ao queryService salvarCurso id: {}", e.getId());
        return cursoRepository.save(e);
    }

    public void deletarCurso(CursoEntity e) {
        log.debug("chamada ao queryService deletarCurso id: {}", e.getId());
        cursoRepository.delete(e);
    }
    
    public void deletarCursoPorId(String id) {
        log.debug("chamada ao queryService deletarCursoPorId id: {}", id);
        cursoRepository.deleteById(id);
    }

    /**
     * Procura uma Curso por ID
     * @param id
     * @return a CursoEntity (RETORNA NULO SE NÃO ENCONTRAR)
     */
    public CursoEntity recuperarPorId(String id) {        
        log.debug("chamada ao queryService recuperarPorId id: {}", id);
        return cursoRepository.findById(id).orElse(null);
    }

}