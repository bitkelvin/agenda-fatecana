package com.fatecsp.agendafatecana.enumerated;

/**
 * PeriodoAulaEnum
 */
public enum PeriodoAulaEnum {

    MANHA("Matutino"),
    TARDE("Vespertino"),
    NOITE("Noturno");

    
    PeriodoAulaEnum(String nome) {
        this.nome = nome;
    }

    private String nome;


    public String getNome() {
        return nome;
    }

}