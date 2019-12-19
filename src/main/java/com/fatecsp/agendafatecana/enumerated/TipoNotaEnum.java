package com.fatecsp.agendafatecana.enumerated;

public enum TipoNotaEnum {
    PROVA("Prova"),
    TRABALHO("Trabalho");
        
    TipoNotaEnum(String nome) {
        this.nome = nome;
    }

    private String nome;

    public String getNome() {
        return nome;
    }
}