package com.fatecsp.agendafatecana.evento;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "evento_entity")
public class Evento {

    private String id;
    private String titulo;
    private String descricao;
    private String cor;
    private LocalDateTime inicio;
    private LocalDateTime fim;

}