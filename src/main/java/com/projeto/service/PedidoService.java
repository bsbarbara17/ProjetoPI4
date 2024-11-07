package com.projeto.service;

import org.springframework.stereotype.Service;

import com.projeto.model.Pedido;
import com.projeto.repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido salvarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido obterPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public void excluirPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
