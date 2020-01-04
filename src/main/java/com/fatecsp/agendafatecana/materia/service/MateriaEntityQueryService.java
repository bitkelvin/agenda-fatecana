package com.fatecsp.agendafatecana.materia.service;

import com.fatecsp.agendafatecana.materia.domain.MateriaEntity;
import com.fatecsp.agendafatecana.repository.MateriaEntityRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * MateriaEntityQueryService
 */
@Service
public class MateriaEntityQueryService {
    private final Logger log = LoggerFactory.getLogger(MateriaEntityQueryService.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MateriaEntityRepository materiaRepository;

    public MateriaEntity salvarMateria(MateriaEntity e) {        
        log.debug("chamada ao queryService salvarMateria id: {}", e.getId());
        return materiaRepository.save(e);
    }

    public void deletarMateria(MateriaEntity e) {
        log.debug("chamada ao queryService deletarMateria id: {}", e.getId());
        materiaRepository.delete(e);
    }
    
    public void deletarMateriaPorId(String id) {
        log.debug("chamada ao queryService deletarMateriaPorId id: {}", id);
        materiaRepository.deleteById(id);
    }

    /**
     * Procura uma Materia por ID
     * @param id
     * @return a MateriaEntity (RETORNA NULO SE NÃO ENCONTRAR)
     */
    public MateriaEntity recuperarPorId(String id) {        
        log.debug("chamada ao queryService recuperarPorId id: {}", id);
        return materiaRepository.findById(id).orElse(null);
    }

}