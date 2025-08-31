package org.example;

public class MyBook implements PlataformaSocial {

    @Override
    public void compartilhar(Postagem postagem) {
        System.out.println("Você compartilhou " + postagem.getTipo() + " no MyBook.");
    }
}
