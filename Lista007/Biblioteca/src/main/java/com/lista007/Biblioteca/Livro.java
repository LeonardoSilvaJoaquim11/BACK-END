package com.lista007.Biblioteca;

import java.util.UUID;

public class Livro {
    protected UUID id;
    private String titulo;
    private String autor;

    public Livro(String titulo, String autor) {
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.autor = autor;
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}
