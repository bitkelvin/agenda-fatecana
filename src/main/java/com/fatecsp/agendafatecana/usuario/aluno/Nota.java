package com.fatecsp.agendafatecana.usuario.aluno;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fatecsp.agendafatecana.enumerated.TipoNotaEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Nota
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Nota {

   private TipoNotaEnum tipo;
   private BigDecimal valor;
   private LocalDate data;
   private String codigoMateria;
   
}