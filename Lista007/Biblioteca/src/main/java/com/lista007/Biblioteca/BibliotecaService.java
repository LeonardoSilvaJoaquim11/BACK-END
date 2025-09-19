package com.lista007.Biblioteca;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BibliotecaService {
    private List<Livro> livrosDisponiveis = new ArrayList<>();
    private List<Emprestimo> emprestimosAtivos = new ArrayList<>();

    public BibliotecaService() {
        livrosDisponiveis.add(new Livro("Dom Casmurro", "Machado de Assis"));
        livrosDisponiveis.add(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis"));
        livrosDisponiveis.add(new Livro("O Cortiço", "Aluísio Azevedo"));
        livrosDisponiveis.add(new Livro("Vidas Secas", "Graciliano Ramos"));
    }

    public List<Livro> getLivros() {
        return livrosDisponiveis;
    }

    public List<Emprestimo> getEmprestados() {
        return emprestimosAtivos;
    }

    public Emprestimo emprestarLivro(UUID livroId, String usuarioId) {
        Optional<Livro> livroOpt = livrosDisponiveis.stream().filter(l -> l.getId().equals(livroId)).findFirst();
        if (livroOpt.isPresent()) {
            Livro livro = livroOpt.get();
            livrosDisponiveis.remove(livro);
            Emprestimo e = new Emprestimo(livro.getId(), usuarioId);
            emprestimosAtivos.add(e);
            return e;
        }
        return null;
    }

    public boolean devolverLivro(UUID emprestimoId) {
        Optional<Emprestimo> emprestimoOpt = emprestimosAtivos.stream().filter(e -> e.getEmprestimoId().equals(emprestimoId)).findFirst();
        if (emprestimoOpt.isPresent()) {
            Emprestimo emprestimo = emprestimoOpt.get();
            emprestimosAtivos.remove(emprestimo);
            livrosDisponiveis.add(new Livro("Livro Devolvido", "Autor Desconhecido") {
                { id = emprestimo.getLivroId(); }
            });
            return true;
        }
        return false;
    }
}
