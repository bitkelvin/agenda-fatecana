package com.fatecsp.agendafatecana.materia.domain;

import java.util.List;

import com.fatecsp.agendafatecana.aula.Aula;
import com.fatecsp.agendafatecana.enumerated.PeriodoAulaEnum;
import com.fatecsp.agendafatecana.evento.Evento;
import com.fatecsp.agendafatecana.materia.HorarioMateria;
import com.querydsl.core.annotations.QueryEntity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MateriaEntity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "materia_entity")
@QueryEntity
public class MateriaEntity {

    private String id;
    private String codigo;
    private Integer ano;
    private Integer semestre;
    private PeriodoAulaEnum periodo;
    private List<Aula> aulas;
    private List<Evento> eventos;
    private List<HorarioMateria> horario;

    //id da disciplina
    private String disciplina;
}