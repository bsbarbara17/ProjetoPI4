package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    // Métodos personalizados, se necessário
}
