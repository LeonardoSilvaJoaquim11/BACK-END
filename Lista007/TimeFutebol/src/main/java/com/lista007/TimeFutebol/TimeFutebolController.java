package com.lista007.TimeFutebol;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TimeFutebolController {
    private final TimeService timeService;

    public TimeFutebolController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/principal")
    public List<Jogador> getPrincipal() {
        return timeService.getTitulares();
    }

    @GetMapping("/reservas")
    public List<Jogador> getReservas() {
        return timeService.getReservas();
    }

    @PutMapping("/jogador/{posicaoTitular}/{posicaoReserva}")
    public void substituir(@PathVariable int posicaoTitular, @PathVariable int posicaoReserva) {
        timeService.substituirJogador(posicaoTitular, posicaoReserva);
    }
}
