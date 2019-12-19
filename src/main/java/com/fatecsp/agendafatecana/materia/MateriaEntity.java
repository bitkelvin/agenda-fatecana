package com.fatecsp.agendafatecana.materia;

import java.util.List;

import com.fatecsp.agendafatecana.aula.Aula;
import com.fatecsp.agendafatecana.enumerated.PeriodoAulaEnum;
import com.fatecsp.agendafatecana.evento.Evento;

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
public class MateriaEntity {

    private String id;
    private String codigo;
    private Integer ano;
    private Integer semestre;
    private PeriodoAulaEnum periodo;
    private List<Aula> aulas;
    private List<Evento> eventos;
    private HorarioMateria horario;

    //id da disciplina
    private String disciplina;
}