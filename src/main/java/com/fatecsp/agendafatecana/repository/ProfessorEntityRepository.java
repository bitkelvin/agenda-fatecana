package com.fatecsp.agendafatecana.repository;

import com.fatecsp.agendafatecana.usuario.professor.domain.ProfessorEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * ProfessorEntityRepository
 */
@Repository
public interface ProfessorEntityRepository extends MongoRepository<ProfessorEntity, String>, QuerydslPredicateExecutor<ProfessorEntity> {

    
}