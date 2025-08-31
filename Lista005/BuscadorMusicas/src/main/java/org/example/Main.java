package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MusicCloud cloud = new MusicCloud();

        System.out.print("Digite o nome da sua playlist: ");
        String nomePlaylist = sc.nextLine();
        Playlist playlist = new Playlist(nomePlaylist);

        String resposta;
        do {
            System.out.print("\nDigite o nome da música: ");
            String nomeMusica = sc.nextLine();

            try {
                Musica musica = cloud.buscarMusica(nomeMusica);
                playlist.adicionarMusica(musica);
                System.out.println("Você adicionou a música " + musica.getTitulo() + " na playlist.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.print("\nDeseja adicionar outra música? (s/n): ");
            resposta = sc.nextLine();

        } while (resposta.equalsIgnoreCase("s"));

        playlist.mostrarPlaylist();
        sc.close();
    }
}
