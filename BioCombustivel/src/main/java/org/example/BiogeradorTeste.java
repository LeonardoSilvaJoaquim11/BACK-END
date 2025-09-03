package org.example;

import java.util.ArrayList;

public class BiogeradorTeste {
    public static void main(String[] args) {
        ArrayList<Biocombustivel> combustiveis = new ArrayList<>();
        combustiveis.add(new CanaAcucar(2000));
        combustiveis.add(new Beterraba(3000));
        combustiveis.add(new Milho(1500));
        combustiveis.add(new Beterraba(3500));
        combustiveis.add(new Beterraba(2000));

        Biogerador biogerador = new Biogerador();

        for (Biocombustivel b : combustiveis) {
            try {
                biogerador.carregar(b);
            } catch (GeradorCheioException e) {
                System.out.println("Exceção: " + e.getMessage());
                break;
            }
        }

        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.printf("Potência gerada no gerador 01: %.2f%n", biogerador.getPotenciaAtual());
        System.out.println("Carga atual do gerador 01: " + biogerador.getCargaAtual());

        biogerador.esvaziar();

        System.out.println("\n=== APÓS ESVAZIAR ===");
        System.out.printf("Potência gerada no gerador 01: %.2f%n", biogerador.getPotenciaAtual());
        System.out.println("Carga atual do gerador 01: " + biogerador.getCargaAtual());
    }
}
