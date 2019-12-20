package com.fatecsp.agendafatecana.repository;

import com.fatecsp.agendafatecana.calendario.CalendarioEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * CalendarioEntityRepository
 */
@Repository
public interface CalendarioEntityRepository extends MongoRepository<CalendarioEntity, String>, QuerydslPredicateExecutor<CalendarioEntity> {

    
}