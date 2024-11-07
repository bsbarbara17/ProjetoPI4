package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Métodos personalizados, se necessário
}
