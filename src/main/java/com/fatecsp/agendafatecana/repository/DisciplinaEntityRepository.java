package com.fatecsp.agendafatecana.repository;

import com.fatecsp.agendafatecana.disciplina.domain.DisciplinaEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * DisciplinaEntityRepository
 */
@Repository
public interface DisciplinaEntityRepository extends MongoRepository<DisciplinaEntity, String>, QuerydslPredicateExecutor<DisciplinaEntity> {

    
}