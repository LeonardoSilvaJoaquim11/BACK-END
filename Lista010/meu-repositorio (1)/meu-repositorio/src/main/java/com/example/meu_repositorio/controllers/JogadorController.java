package com.example.meu_repositorio.controllers;

import com.example.meu_repositorio.models.Jogador;
import com.example.meu_repositorio.services.JogadorService;
import jakarta.persistence.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService){
        this.jogadorService = jogadorService;
    }

    @PostMapping
    public Jogador saveJogador(@RequestBody Jogador jogador){
        return jogadorService.saveJogador(jogador.getNome(), jogador.getSobrenome());
    }

    @GetMapping
    public List<Jogador> getALLJogadores(){
        return jogadorService.getALLJogadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> getJogadorById(@PathVariable UUID id){
        Jogador jogador = jogadorService.getJogadorById(id);
        return ResponseEntity.ok(jogador);
    }

}
