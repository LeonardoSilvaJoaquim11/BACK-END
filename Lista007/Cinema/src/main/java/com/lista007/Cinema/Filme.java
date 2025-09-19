package com.lista007.Cinema;

import java.util.*;

public class Filme {
    private UUID id;
    private String titulo;
    private String genero;
    private int capacidade;
    private int assentosOcupados;
    private List<Ingresso> ingressos;

    public Filme(String titulo, String genero, int capacidade) {
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.genero = genero;
        this.capacidade = capacidade;
        this.assentosOcupados = 0;
        this.ingressos = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getAssentosOcupados() {
        return assentosOcupados;
    }

    public void ocuparAssento() {
        this.assentosOcupados++;
    }

    public void liberarAssento() {
        this.assentosOcupados--;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void addIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
        ocuparAssento();
    }

    public void removeIngresso(UUID ingressoId) {
        ingressos.removeIf(i -> i.getIngressoId().equals(ingressoId));
        liberarAssento();
    }
}
