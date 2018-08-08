package com.teste.retrofit2apagar;

public class SituacaoVia {

    private String STV_Id;
    private String STV_NomeVia;

    public String getSTV_Id() {
        return STV_Id;
    }

    public void setSTV_Id(String STV_Id) {
        this.STV_Id = STV_Id;
    }

    public String getSTV_NomeVia() {
        return STV_NomeVia;
    }

    public void setSTV_NomeVia(String STV_NomeVia) {
        this.STV_NomeVia = STV_NomeVia;
    }

    @Override
    public String toString() {
        return "SituacaoVia{" +
                "STV_Id='" + STV_Id + '\'' +
                ", STV_NomeVia='" + STV_NomeVia + '\'' +
                '}';
    }
}