package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criando cinema e adicionando filmes
        Cinema cinema = new Cinema("CineCenter");
        cinema.adicionarFilme(new Filme("Homem Aranha", 25.0, 12));
        cinema.adicionarFilme(new Filme("Batman", 30.0, 14));
        cinema.adicionarFilme(new Filme("Frozen 2", 20.0, 0));
        cinema.adicionarFilme(new Filme("Deadpool", 35.0, 18));
        cinema.adicionarFilme(new Filme("Vingadores", 40.0, 12));

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Filmes disponíveis ---");
            for (Filme f : cinema.getFilmesDisponiveis()) {
                System.out.println(" - " + f);
            }

            System.out.print("\nQual filme você deseja assistir? ");
            String nomeFilme = sc.nextLine();
            Filme escolhido = cinema.buscarFilme(nomeFilme);

            if (escolhido == null) {
                System.out.println("Filme não encontrado!");
                continue;
            }

            System.out.print("Qual assento você deseja (ex: A1, B3, F5)? ");
            String assento = sc.nextLine();

            System.out.print("Qual o seu nome? ");
            String nomeCliente = sc.nextLine();

            System.out.print("Qual a sua idade? ");
            int idade = sc.nextInt();
            sc.nextLine(); // limpar buffer

            Cliente cliente = new Cliente(nomeCliente, idade);

            try {
                cinema.venderIngresso(cliente, escolhido, assento);
            } catch (IdadeInvalida | AssentoIndisponivel e) {
                System.out.println(e.getMessage());
            }

            System.out.print("\nDeseja comprar outro ingresso? (s/n) ");
            String resposta = sc.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        sc.close();
    }
}
