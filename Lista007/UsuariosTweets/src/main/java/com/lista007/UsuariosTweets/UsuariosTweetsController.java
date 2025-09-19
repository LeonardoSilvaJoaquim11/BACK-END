package com.lista007.UsuariosTweets;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuariosTweetsController {
    private final UsuarioService service;

    public UsuariosTweetsController(UsuarioService service) {
        this.service = service;
    }

    // GET /usuarios → lista todos os usuários
    @GetMapping
    public List<Usuario> getUsuarios() {
        return service.getUsuarios();
    }

    // GET /usuarios/{id}/tweets → lista tweets de um usuário
    @GetMapping("/{id}/tweets")
    public List<Tweet> getTweets(@PathVariable UUID id) {
        return service.getTweetsByUsuario(id);
    }

    // POST /usuarios/{id}/tweets → cria um novo tweet
    @PostMapping("/{id}/tweets")
    public Tweet criarTweet(@PathVariable UUID id, @RequestParam String mensagem) {
        return service.criarTweet(id, mensagem);
    }

    // PATCH /usuarios/{id}/tweets/{tweetId} → atualiza a mensagem
    @PatchMapping("/{id}/tweets/{tweetId}")
    public Tweet atualizarTweet(@PathVariable UUID id, @PathVariable UUID tweetId, @RequestParam String novaMensagem) {
        return service.atualizarTweet(id, tweetId, novaMensagem);
    }

    // DELETE /usuarios/{id}/tweets/{tweetId} → remove um tweet
    @DeleteMapping("/{id}/tweets/{tweetId}")
    public boolean deletarTweet(@PathVariable UUID id, @PathVariable UUID tweetId) {
        return service.deletarTweet(id, tweetId);
    }
}
