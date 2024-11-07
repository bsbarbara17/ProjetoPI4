package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Métodos personalizados, se necessário
}
