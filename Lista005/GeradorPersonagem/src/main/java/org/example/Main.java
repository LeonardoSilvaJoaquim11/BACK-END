package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando lista de inimigos
        List<Personagem> inimigos = new ArrayList<>();
        Personagem orc = new Personagem("Orc", 100, 10);
        Personagem goblin = new Personagem("Goblin", 50, 5);
        Personagem lobo = new Personagem("Lobo", 75, 15);
        Personagem cavaleiro = new Personagem("Cavaleiro", 200, 20);
        Personagem dragao = new Personagem("Dragão", 500, 50);

        inimigos.add(orc);
        inimigos.add(goblin);
        inimigos.add(lobo);
        inimigos.add(cavaleiro);
        inimigos.add(dragao);

        // Criando o jogador
        Personagem steve = new Personagem("Steve", 100, 20);

        steve.atacar(orc);
        steve.atacar(goblin);

        for (Personagem inimigo : inimigos) {
            if (inimigo.getVida() > 0) {
                inimigo.atacar(steve);
            }
        }
        System.out.println();
    }
}
