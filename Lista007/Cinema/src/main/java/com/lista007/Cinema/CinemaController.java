package com.lista007.Cinema;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/filmes")
public class CinemaController {
    private final FilmeService service;

    public CinemaController(FilmeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Filme> listarFilmes() {
        return service.listarFilmes();
    }

    @PostMapping
    public Filme criarFilme(@RequestParam String titulo, @RequestParam String genero, @RequestParam int capacidade) {
        return service.criarFilme(titulo, genero, capacidade);
    }

    @PatchMapping("/{id}")
    public Filme atualizarFilme(@PathVariable UUID id,
                                @RequestParam(required = false) String titulo,
                                @RequestParam(required = false) String genero,
                                @RequestParam(required = false) Integer capacidade) {
        return service.atualizarFilme(id, titulo, genero, capacidade);
    }

    @DeleteMapping("/{id}")
    public boolean deletarFilme(@PathVariable UUID id) {
        return service.deletarFilme(id);
    }

    @PostMapping("/{id}/ingressos")
    public Ingresso comprarIngresso(@PathVariable UUID id) {
        return service.comprarIngresso(id);
    }

    @DeleteMapping("/{id}/ingressos/{ingressoId}")
    public boolean devolverIngresso(@PathVariable UUID id, @PathVariable UUID ingressoId) {
        return service.devolverIngresso(id, ingressoId);
    }
}
