package com.fatecsp.agendafatecana.agenda;

import java.util.List;

import com.fatecsp.agendafatecana.calendario.domain.Mes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * AgendaDTO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AgendaDTO{

    private Integer ano;
    private Integer semestre;
    private List<Mes> meses;

}