package com.example.fipe.dto;

public class FipeResponse {
    private Double valor;
    private String mes;

    public FipeResponse(Double valor, String mes) {
        this.valor = valor;
        this.mes = mes;
    }

    public Double getValor() { return valor; }
    public String getMes() { return mes; }
}
