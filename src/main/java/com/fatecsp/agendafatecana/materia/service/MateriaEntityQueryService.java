package com.fatecsp.agendafatecana.materia.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.fatecsp.agendafatecana.AgendaFatecanaQueryService;
import com.fatecsp.agendafatecana.materia.domain.MateriaEntity;
import com.fatecsp.agendafatecana.repository.MateriaEntityRepository;

/**
 * MateriaEntityQueryService
 */
@Service
public class MateriaEntityQueryService extends AgendaFatecanaQueryService {
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
	
	public List<MateriaEntity> recuperarPorIds(List<String> ids) {
        log.debug("chamada ao queryService recuperarPorIds - ids: {}", ids);
        
        Query query = new Query();
        query.fields();
        
        List<Criteria> criteriaList = new ArrayList<>();
       
        criteriaList.add(Criteria.where("id").in(ids));
        
        query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        
        return mongoTemplate.find(query, MateriaEntity.class);
	
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

	public List<MateriaEntity> findAll() {
		return materiaRepository.findAll();
	}

}