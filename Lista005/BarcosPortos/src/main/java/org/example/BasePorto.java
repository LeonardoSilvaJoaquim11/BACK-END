package org.example;

import java.util.ArrayList;
import java.util.List;

public class BasePorto {
    protected String nome;
    protected List<Barco> barcosAtracados;

    public BasePorto(String nome) {
        this.nome = nome;
        this.barcosAtracados = new ArrayList<>();
    }

    public void atracarBarco(Barco barco) {
        barcosAtracados.add(barco);
        System.out.println(barco.getNome() + " atracado no porto " + nome);
    }

    public List<Barco> getBarcosAtracados() {
        return barcosAtracados;
    }
}
