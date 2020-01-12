package com.fatecsp.agendafatecana.curso.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fatecsp.agendafatecana.enumerated.DepartamentoEnum;
import com.querydsl.core.annotations.QueryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Curso
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "curso_entity")
@QueryEntity
public class CursoEntity {

    private String id;
    private String nome;
    private DepartamentoEnum departamento; 

    
}