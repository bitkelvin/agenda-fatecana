package com.fatecsp.agendafatecana.usuario.professor.service;

import com.fatecsp.agendafatecana.repository.ProfessorEntityRepository;
import com.fatecsp.agendafatecana.usuario.professor.domain.ProfessorEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * ProfessorEntityQueryService
 */
@Service
public class ProfessorEntityQueryService {
    private final Logger log = LoggerFactory.getLogger(ProfessorEntityQueryService.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ProfessorEntityRepository professorRepository;

    public ProfessorEntity salvarProfessor(ProfessorEntity e) {        
        log.debug("chamada ao queryService salvarProfessor id: {}", e.getId());
        return professorRepository.save(e);
    }

    public void deletarProfessor(ProfessorEntity e) {
        log.debug("chamada ao queryService deletarProfessor id: {}", e.getId());
        professorRepository.delete(e);
    }
    
    public void deletarProfessorPorId(String id) {
        log.debug("chamada ao queryService deletarProfessorPorId id: {}", id);
        professorRepository.deleteById(id);
    }

    /**
     * Procura uma Professor por ID
     * @param id
     * @return a ProfessorEntity (RETORNA NULO SE NÃO ENCONTRAR)
     */
    public ProfessorEntity recuperarPorId(String id) {        
        log.debug("chamada ao queryService recuperarPorId id: {}", id);
        return professorRepository.findById(id).orElse(null);
    }

}