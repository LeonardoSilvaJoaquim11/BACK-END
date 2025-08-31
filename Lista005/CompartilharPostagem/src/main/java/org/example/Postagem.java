package org.example;

public class Postagem {
    private String titulo;
    private String descricao;
    private TipoPostagem tipo;

    public Postagem(String titulo, String descricao, TipoPostagem tipo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoPostagem getTipo() {
        return tipo;
    }
}
