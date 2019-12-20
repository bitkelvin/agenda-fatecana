package com.fatecsp.agendafatecana.repository;

import com.fatecsp.agendafatecana.curso.domain.CursoEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * CursoEntityRepository
 */
@Repository
public interface CursoEntityRepository extends MongoRepository<CursoEntity, String>, QuerydslPredicateExecutor<String>{

    
}