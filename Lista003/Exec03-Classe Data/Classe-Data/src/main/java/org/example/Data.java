package org.example;

import java.time.Year;

public class Data {
    //Atributos
    private Integer mes;
    private Integer dia;
    private Integer ano;


    //construtor
     Data(Integer dia, Integer mes, Integer ano) {
        if (mes < 1 || mes > 12) throw new IllegalArgumentException("Mês inválido: " + mes);
        if (ano <= 0) throw new IllegalArgumentException("Ano inválido: " + ano);

        int maxDias;
        switch (mes) {
            case 2:
                maxDias = Year.isLeap(ano) ? 29 : 28;
                break;
            case 4: case 6: case 9: case 11:
                maxDias = 30;
                break;
            default:
                maxDias = 31;
        }
        if (dia < 1 || dia > maxDias) throw new IllegalArgumentException("Dia inválido: " + dia + "/" + mes + "/" + ano);

        this.mes = mes;
        this.dia = dia;
        this.ano = ano;
    }


    public Integer getMes() {

        return mes;
    }

    public Integer getDia() {
        return dia;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getAno() {
        return ano;
    }

    //Método
    void displayData(){
        System.out.println( dia +
                "/" + mes +
                "/" + ano
        );
    }
}