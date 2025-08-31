package org.example;

public class Fotogram implements PlataformaSocial {

    @Override
    public void compartilhar(Postagem postagem) throws Exception {
        if (postagem.getTipo() != TipoPostagem.IMAGEM) {
            throw new Exception("Erro: O Fotogram só aceita postagens de IMAGEM.");
        }
        System.out.println("Você compartilhou " + postagem.getTipo() + " no Fotogram.");
    }
}
