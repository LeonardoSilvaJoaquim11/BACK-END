package org.example;

public class AnyTube implements PlataformaSocial {

    @Override
    public void compartilhar(Postagem postagem) throws Exception {
        if (postagem.getTipo() != TipoPostagem.VIDEO) {
            throw new Exception("Erro: O AnyTube só aceita postagens de VÍDEO.");
        }
        System.out.println("Você compartilhou " + postagem.getTipo() + " no AnyTube.");
    }
}
