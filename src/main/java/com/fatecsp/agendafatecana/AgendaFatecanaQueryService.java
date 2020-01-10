package com.fatecsp.agendafatecana;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.fatecsp.agendafatecana.utils.QueryUtils;

public class AgendaFatecanaQueryService {
	Logger log = LoggerFactory.getLogger(AgendaFatecanaQueryService.class) ;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public <T> T recuperarPorMapaDePropriedades(Map<String, Object> propriedades, Class<T> clazz ) {
        log.debug("chamada ao queryService recuperarPorMapaDePropriedades - propriedades: {}, entidade: {}", propriedades, clazz.toString());
        
        Query query = QueryUtils.criarCriteria(propriedades);
        
        return mongoTemplate.findOne(query, clazz);
	
    }
	
	public <T> List<T> recuperarTodosPorMapaDePropriedades(Map<String, Object> propriedades, Class<T> clazz ) {
        log.debug("chamada ao queryService recuperarPorMapaDePropriedades - propriedades: {}, entidade: {}", propriedades, clazz.toString());
        
        Query query = QueryUtils.criarCriteria(propriedades);
        
        return mongoTemplate.find(query, clazz);
	
    }

}
