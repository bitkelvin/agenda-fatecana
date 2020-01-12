package com.fatecsp.agendafatecana.materia;

import java.time.LocalTime;

import com.fatecsp.agendafatecana.enumerated.DiaSemanaEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * HorarioMateria
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HorarioMateria {

    private DiaSemanaEnum dia;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private String local;
    private Integer periodos;

}