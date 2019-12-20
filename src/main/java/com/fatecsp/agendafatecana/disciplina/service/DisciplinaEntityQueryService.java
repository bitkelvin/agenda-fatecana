package com.fatecsp.agendafatecana.disciplina.service;

import com.fatecsp.agendafatecana.disciplina.domain.DisciplinaEntity;
import com.fatecsp.agendafatecana.repository.DisciplinaEntityRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * DisciplinaEntityQueryService
 */
@Service
public class DisciplinaEntityQueryService {
    private final Logger log = LoggerFactory.getLogger(DisciplinaEntityQueryService.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    DisciplinaEntityRepository disciplinaRepository;

    public DisciplinaEntity salvarDisciplina(DisciplinaEntity e) {        
        log.debug("chamada ao queryService salvarDisciplina id: {}", e.getId());
        return disciplinaRepository.save(e);
    }

    public void deletarDisciplina(DisciplinaEntity e) {
        log.debug("chamada ao queryService deletarDisciplina id: {}", e.getId());
        disciplinaRepository.delete(e);
    }
    
    public void deletarDisciplinaPorId(String id) {
        log.debug("chamada ao queryService deletarDisciplinaPorId id: {}", id);
        disciplinaRepository.deleteById(id);
    }

    /**
     * Procura uma disciplina por ID
     * @param id
     * @return a DisciplinaEntity (RETORNA NULO SE NÃO ENCONTRAR)
     */
    public DisciplinaEntity recuperarPorId(String id) {        
        log.debug("chamada ao queryService recuperarPorId id: {}", id);
        return disciplinaRepository.findById(id).orElse(null);
    }

}