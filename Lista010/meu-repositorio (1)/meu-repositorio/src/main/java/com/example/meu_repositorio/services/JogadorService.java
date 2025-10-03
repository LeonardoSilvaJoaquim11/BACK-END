package com.example.meu_repositorio.services;
import com.example.meu_repositorio.models.Jogador;
import com.example.meu_repositorio.repositories.JogadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service
public class JogadorService {
    //declara repositorio
    private JogadorRepository jogadorRepository;

    //inicia repositorio
    public JogadorService(JogadorRepository jogadorRepository){
        this.jogadorRepository = jogadorRepository;
    }

    //insere novo jogador
    public Jogador saveJogador(String nome, String sobrenome){
        Jogador novoJogador = new Jogador();
        novoJogador.setNome(nome);
        novoJogador.setSobrenome(sobrenome);
        novoJogador.setClube("Criciúma");
        jogadorRepository.save(novoJogador);
        return novoJogador;
    }

    //retorna todos os jogadores
    public List<Jogador> getALLJogadores(){
        return jogadorRepository.findAll();
    }

    public Jogador getJogadorById(UUID id) {
        return jogadorRepository.getReferenceById(id);
    }
}
