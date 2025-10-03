package com.example.meu_repositorio.repositories;
import com.example.meu_repositorio.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;


public interface JogadorRepository extends JpaRepository<Jogador, UUID> {
}
