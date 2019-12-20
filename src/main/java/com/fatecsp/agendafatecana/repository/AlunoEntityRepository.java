package com.fatecsp.agendafatecana.repository;

import com.fatecsp.agendafatecana.usuario.aluno.domain.AlunoEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * AlunoEntityRepository
 */
@Repository
public interface AlunoEntityRepository extends MongoRepository<AlunoEntity, String>, QuerydslPredicateExecutor<AlunoEntity> {

    
}