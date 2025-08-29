package org.example;

public class Personagem {
    // Atributos
    private String nome;
    private int vida;
    private int ataque;

    // Construtor
    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    // Método
    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida <= 0) {
            this.vida = 0; // evita valor negativo
            System.out.println(nome + " recebeu " + dano + " de dano e foi derrotado!");
        } else {
            System.out.println(nome + " recebeu " + dano + " de dano. Vida restante: " + vida);
        }
    }

    // Método
    public void atacar(Personagem alvo) {
        if (alvo.getVida() == 0) {
            System.out.println("O ataque de " + nome + " falhou! " + alvo.getNome() + " já está derrotado.");
        } else {
            System.out.println(nome + " atacou " + alvo.getNome() + " causando " + ataque + " de dano!");
            alvo.receberDano(ataque);
        }
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }
}

