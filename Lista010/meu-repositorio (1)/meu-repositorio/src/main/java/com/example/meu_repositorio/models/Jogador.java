package com.example.meu_repositorio.models;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String nome;
    String sobrenome;
    String clube;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }
}
