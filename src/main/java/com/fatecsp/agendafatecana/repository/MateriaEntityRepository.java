package com.fatecsp.agendafatecana.repository;

import com.fatecsp.agendafatecana.materia.domain.MateriaEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * MateriaEntityRepository
 */
@Repository
public interface MateriaEntityRepository extends MongoRepository<MateriaEntity, String>, QuerydslPredicateExecutor<MateriaEntity> {

    
}