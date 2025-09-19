package com.lista007.UsuariosTweets;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Usuario {
    private UUID id;
    private String nome;
    private String email;
    private List<Tweet> tweets;

    public Usuario(String nome, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.tweets = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void addTweet(Tweet tweet) {
        this.tweets.add(tweet);
    }

    public void removeTweet(UUID tweetId) {
        this.tweets.removeIf(t -> t.getTweetId().equals(tweetId));
    }
}
