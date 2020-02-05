package com.fatecsp.agendafatecana.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * QueryUtils
 */
public class QueryUtils {

    public static Query criarCriteria(Map<String, Object> mapaPropriedades) {

        Objects.requireNonNull(mapaPropriedades, "O mapeio de propriedades não pode ser nulo.");

        Query query = new Query();
        query.fields();
        
        List<Criteria> criteriaList = new ArrayList<>();

        mapaPropriedades.entrySet().stream().forEach(e -> {            
            criteriaList.add(Criteria.where(e.getKey()).is(e.getValue()));
        });
        
        query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        
        return query;

    }
    
    public static Query criarCriteriaFiltro(Map<String, List<Object>> mapaPropriedades) {

        Objects.requireNonNull(mapaPropriedades, "O mapeio de propriedades não pode ser nulo.");

        Query query = new Query();
        query.fields();
        
        List<Criteria> criteriaList = new ArrayList<>();

        mapaPropriedades.entrySet().stream().forEach(e -> {            
            criteriaList.add(Criteria.where(e.getKey()).in(e.getValue()));
        });
        
        query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        
        return query;

    }
}