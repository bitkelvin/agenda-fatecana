package com.fatecsp.agendafatecana.calendario;

import java.util.List;

import com.fatecsp.agendafatecana.enumerated.DiaSemanaEnum;
import com.fatecsp.agendafatecana.evento.Evento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dia
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dia {

    public Integer dia;
    public DiaSemanaEnum diaDaSemana;
    public boolean isUtil;
    public List<Evento> eventos;

}