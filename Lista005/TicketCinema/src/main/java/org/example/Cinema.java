package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String nome;
    private List<Filme> filmesDisponiveis;
    private List<Ingresso> ingressosVendidos;

    public Cinema(String nome) {
        this.nome = nome;
        this.filmesDisponiveis = new ArrayList<>();
        this.ingressosVendidos = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public Filme buscarFilme(String nome) {
        for (Filme f : filmesDisponiveis) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                return f;
            }
        }
        return null;
    }

    public void venderIngresso(Cliente cliente, Filme filme, String assento)
            throws AssentoIndisponivel, IdadeInvalida {

        // Verifica idade
        if (cliente.getIdade() < filme.getIdadeMinima()) {
            throw new IdadeInvalida("O ingresso não pode ser vendido pois sua idade não permite!");
        }

        // Verifica assento
        for (Ingresso i : ingressosVendidos) {
            if (i.getAssento().equalsIgnoreCase(assento) && i.getFilme().equals(filme)) {
                throw new AssentoIndisponivel("O ingresso não pode ser vendido pois seu assento não está mais disponível!");
            }
        }

        // Se passou nas verificações, vende ingresso
        Ingresso novo = new Ingresso(cliente, filme, assento);
        ingressosVendidos.add(novo);
        System.out.println(novo);
    }

    public List<Filme> getFilmesDisponiveis() {
        return filmesDisponiveis;
    }
}
