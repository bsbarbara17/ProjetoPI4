package com.projeto.service;

import org.springframework.stereotype.Service;

import com.projeto.model.ItemPedido;
import com.projeto.repository.ItemPedidoRepository;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public List<ItemPedido> listarItensPedido() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido salvarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public ItemPedido obterItemPedidoPorId(Long id) {
        return itemPedidoRepository.findById(id).orElse(null);
    }

    public void excluirItemPedido(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
