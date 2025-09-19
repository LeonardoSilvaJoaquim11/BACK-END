package com.lista007.UsuariosTweets;


import java.time.LocalDateTime;
import java.util.UUID;

public class Tweet {
    private UUID tweetId;
    private String mensagem;
    private boolean editado;
    private LocalDateTime dataCriacao;

    public Tweet(String mensagem) {
        this.tweetId = UUID.randomUUID();
        this.mensagem = mensagem;
        this.editado = false;
        this.dataCriacao = LocalDateTime.now();
    }

    public UUID getTweetId() {
        return tweetId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public boolean isEditado() {
        return editado;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void atualizarMensagem(String novaMensagem) {
        this.mensagem = novaMensagem;
        this.editado = true;
    }
}
