package com.fatecsp.agendafatecana.enumerated;

/**
 * MesEnum
 */
public enum MesEnum {

    JANEIRO("Janeiro"),
    FEVEREIRO("Fevereiro"),
    MARCO("Março"),
    ABRIL("Abril"),
    MAIO("Maio"),
    JUNHO("Junho"),
    JULHO("Julho"),
    AGOSTO("Agosto"),
    SETEMBRO("Setembro"),
    OUTUBRO("Outubro"),
    NOVEMBRO("Novembro"),
    DEZEMBRO("Dezembro");

    MesEnum(String nome) {
        this.nome = nome;
    }

    private String nome;


    public String getNome() {
        return nome;
    }

}