package com.fatecsp.agendafatecana.curso;

import java.util.List;

import com.fatecsp.agendafatecana.enumerated.DepartamentoEnum;

import org.springframework.data.mongodb.core.mapping.Document;

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
public class CursoEntity {

    private String id;
    private String nome;
    private DepartamentoEnum departamento; 

    //ids dos cursos
    private List<String> cursos;
    
}