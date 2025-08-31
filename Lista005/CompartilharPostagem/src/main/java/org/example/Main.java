package org.example;

public class Main {
    public static void main(String[] args) {
        // Criando postagens de todos os tipos
        Postagem p1 = new Postagem("Post 1", "Texto sobre Java", TipoPostagem.TEXTO);
        Postagem p2 = new Postagem("Post 2", "Foto bonita", TipoPostagem.IMAGEM);
        Postagem p3 = new Postagem("Post 3", "Vídeo aula", TipoPostagem.VIDEO);

        PlataformaSocial myBook = new MyBook();
        PlataformaSocial fotogram = new Fotogram();
        PlataformaSocial anyTube = new AnyTube();

        System.out.println("=== Testando MyBook ===");
        try { myBook.compartilhar(p1); } catch (Exception e) { System.out.println(e.getMessage()); }
        try { myBook.compartilhar(p2); } catch (Exception e) { System.out.println(e.getMessage()); }
        try { myBook.compartilhar(p3); } catch (Exception e) { System.out.println(e.getMessage()); }

        System.out.println("\n=== Testando Fotogram ===");
        try { fotogram.compartilhar(p1); } catch (Exception e) { System.out.println(e.getMessage()); }
        try { fotogram.compartilhar(p2); } catch (Exception e) { System.out.println(e.getMessage()); }
        try { fotogram.compartilhar(p3); } catch (Exception e) { System.out.println(e.getMessage()); }

        System.out.println("\n=== Testando AnyTube ===");
        try { anyTube.compartilhar(p1); } catch (Exception e) { System.out.println(e.getMessage()); }
        try { anyTube.compartilhar(p2); } catch (Exception e) { System.out.println(e.getMessage()); }
        try { anyTube.compartilhar(p3); } catch (Exception e) { System.out.println(e.getMessage()); }
    }
}
