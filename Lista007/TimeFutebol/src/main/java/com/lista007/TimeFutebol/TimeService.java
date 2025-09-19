package com.lista007.TimeFutebol;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeService {
    private List<Jogador> jogadores = new ArrayList<>();

    public TimeService() {
        for (int i = 0; i < 11; i++) {
            jogadores.add(new Jogador("Titular " + i, "Posição " + i, 20 + i));
        }
        for (int i = 11; i < 16; i++) {
            jogadores.add(new Jogador("Reserva " + i, "Posição " + i, 20 + i));
        }
    }

    public List<Jogador> getTitulares() {
        return jogadores.subList(0, 11);
    }

    public List<Jogador> getReservas() {
        return jogadores.subList(11, 16);
    }

    public void substituirJogador(int posicaoTitular, int posicaoReserva) {
        Jogador titular = jogadores.get(posicaoTitular);
        Jogador reserva = jogadores.get(posicaoReserva);
        jogadores.set(posicaoTitular, reserva);
        jogadores.set(posicaoReserva, titular);
    }
}
