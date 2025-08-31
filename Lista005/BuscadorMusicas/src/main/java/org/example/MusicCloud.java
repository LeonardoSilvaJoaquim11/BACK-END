package org.example;

import java.util.ArrayList;
import java.util.List;

public class MusicCloud {
    private List<Musica> musicasDisponiveis;

    public MusicCloud() {
        musicasDisponiveis = new ArrayList<>();
        carregarMusicas();
    }

    private void carregarMusicas() {
        musicasDisponiveis.add(new Musica("Hino do Real Paulista", "Banda Local"));
        musicasDisponiveis.add(new Musica("Macarena", "Los Del Rio"));
        musicasDisponiveis.add(new Musica("Evidências", "Chitãozinho & Xororó"));
        musicasDisponiveis.add(new Musica("Thriller", "Michael Jackson"));
        musicasDisponiveis.add(new Musica("Bohemian Rhapsody", "Queen"));
    }

    public Musica buscarMusica(String titulo) throws Exception {
        for (Musica m : musicasDisponiveis) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                return m;
            }
        }
        throw new Exception("A música " + titulo + " não foi encontrada no sistema.");
    }
}
