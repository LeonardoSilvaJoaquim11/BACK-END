package com.lista007.UsuariosTweets;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioService() {
        // Inicializa alguns usuários
        usuarios.add(new Usuario("Alice", "alice@email.com"));
        usuarios.add(new Usuario("Bob", "bob@email.com"));
        usuarios.add(new Usuario("Carlos", "carlos@email.com"));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuarioById(UUID id) {
        return usuarios.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Tweet> getTweetsByUsuario(UUID usuarioId) {
        Usuario usuario = getUsuarioById(usuarioId);
        return usuario != null ? usuario.getTweets() : null;
    }

    public Tweet criarTweet(UUID usuarioId, String mensagem) {
        Usuario usuario = getUsuarioById(usuarioId);
        if (usuario != null) {
            Tweet tweet = new Tweet(mensagem);
            usuario.addTweet(tweet);
            return tweet;
        }
        return null;
    }

    public Tweet atualizarTweet(UUID usuarioId, UUID tweetId, String novaMensagem) {
        Usuario usuario = getUsuarioById(usuarioId);
        if (usuario != null) {
            for (Tweet tweet : usuario.getTweets()) {
                if (tweet.getTweetId().equals(tweetId)) {
                    tweet.atualizarMensagem(novaMensagem);
                    return tweet;
                }
            }
        }
        return null;
    }

    public boolean deletarTweet(UUID usuarioId, UUID tweetId) {
        Usuario usuario = getUsuarioById(usuarioId);
        if (usuario != null) {
            return usuario.getTweets().removeIf(t -> t.getTweetId().equals(tweetId));
        }
        return false;
    }
}
