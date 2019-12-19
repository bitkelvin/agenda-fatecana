package com.fatecsp.agendafatecana.usuario.aluno;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Falta
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Falta {

    private LocalDate data;
    private String codigoMateria;
    private String nomeMateria;
    private String comentario;
}

//TODO: não esquecer do serviço de recuperação de datas disponiveis para assinalar falta para cada materia.