package com.lista007.Cinema;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FilmeService {
    private List<Filme> filmes = new ArrayList<>();

    public FilmeService() {
        filmes.add(new Filme("Matrix", "Ficção", 3));
        filmes.add(new Filme("Titanic", "Romance", 2));
    }

    public List<Filme> listarFilmes() {
        return filmes;
    }

    public Filme criarFilme(String titulo, String genero, int capacidade) {
        Filme filme = new Filme(titulo, genero, capacidade);
        filmes.add(filme);
        return filme;
    }

    public Filme atualizarFilme(UUID id, String titulo, String genero, Integer capacidade) {
        for (Filme filme : filmes) {
            if (filme.getId().equals(id)) {
                if (titulo != null) filme.setTitulo(titulo);
                if (genero != null) filme.setGenero(genero);
                if (capacidade != null) filme.setCapacidade(capacidade);
                return filme;
            }
        }
        return null;
    }

    public boolean deletarFilme(UUID id) {
        return filmes.removeIf(f -> f.getId().equals(id));
    }

    public Ingresso comprarIngresso(UUID filmeId) {
        for (Filme filme : filmes) {
            if (filme.getId().equals(filmeId)) {
                if (filme.getAssentosOcupados() < filme.getCapacidade()) {
                    int assentoNumero = filme.getAssentosOcupados() + 1;
                    Ingresso ingresso = new Ingresso(filmeId, assentoNumero);
                    filme.addIngresso(ingresso);
                    return ingresso;
                }
            }
        }
        return null;
    }

    public boolean devolverIngresso(UUID filmeId, UUID ingressoId) {
        for (Filme filme : filmes) {
            if (filme.getId().equals(filmeId)) {
                Optional<Ingresso> ingressoOpt = filme.getIngressos().stream()
                        .filter(i -> i.getIngressoId().equals(ingressoId)).findFirst();
                if (ingressoOpt.isPresent()) {
                    filme.removeIngresso(ingressoId);
                    return true;
                }
            }
        }
        return false;
    }
}
