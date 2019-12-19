package com.fatecsp.agendafatecana.disciplina;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DisciplinaEntity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "disciplina_entity")
public class DisciplinaEntity {

    private String id;
    private String nome;
    private List<String> idCursos; 
}