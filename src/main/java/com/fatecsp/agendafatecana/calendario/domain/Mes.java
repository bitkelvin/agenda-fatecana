package com.fatecsp.agendafatecana.calendario.domain;


import java.util.List;

import com.fatecsp.agendafatecana.enumerated.MesEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mes
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mes {

    private MesEnum mes;
    private List<Dia> dias;
}