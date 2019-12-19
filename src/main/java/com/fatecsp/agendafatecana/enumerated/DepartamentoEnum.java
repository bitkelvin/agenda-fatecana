package com.fatecsp.agendafatecana.enumerated;

public enum DepartamentoEnum {

    DAESTUR("Automação de Escritórios e Secretariado"),
    EDIFICIOS("Edifícios"),
    DEG("Ensino Geral"),
    HIDRAULICA("Hidráulica"),
    MECANICA("Mecânica"),
    MECPRE("Mecânica de Precisão"),
    DSE("Sistemas Eletrônicos"),
    SOLDAGEM("Soldagem"),
    DTI("Tecnologia da Informação"),
    TOT("Transportes e Obra de Terra");

    DepartamentoEnum(String nome) {
        this.nome = nome;
    }

    private String nome;


    public String getNome() {
        return nome;
    }

}