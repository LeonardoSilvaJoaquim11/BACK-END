package com.lista007.Biblioteca;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
public class BibliotecaController {
    private final BibliotecaService service;

    public BibliotecaController(BibliotecaService service) {
        this.service = service;
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return service.getLivros();
    }

    @GetMapping("/emprestados")
    public List<Emprestimo> getEmprestados() {
        return service.getEmprestados();
    }

    @PostMapping("/emprestados")
    public Emprestimo emprestar(@RequestParam UUID livroId, @RequestParam String usuarioId) {
        return service.emprestarLivro(livroId, usuarioId);
    }

    @DeleteMapping("/emprestados/{emprestimoId}")
    public boolean devolver(@PathVariable UUID emprestimoId) {
        return service.devolverLivro(emprestimoId);
    }
}
