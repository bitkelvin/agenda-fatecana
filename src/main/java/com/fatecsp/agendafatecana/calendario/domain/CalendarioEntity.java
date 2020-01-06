package com.fatecsp.agendafatecana.calendario.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CalendarioEntity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "calendario_entity")
@QueryEntity
public class CalendarioEntity {

    private String id;
    private Integer ano;
    private Integer semestre;
    private List<Mes> meses;
}