package com.fatecsp.agendafatecana.evento;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "evento_entity")
@QueryEntity
public class Evento {

    private String id;
    private String title;
    private String descricao;
    private String cor;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private boolean editavel;
    private boolean fatec;

}