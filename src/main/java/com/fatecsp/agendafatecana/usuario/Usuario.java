package com.fatecsp.agendafatecana.usuario;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Usuario
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuario_entity")
public class Usuario {

    private String id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNasc;
    private String telefone;
    
}