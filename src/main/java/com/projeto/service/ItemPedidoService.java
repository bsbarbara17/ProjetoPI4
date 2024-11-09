package com.projeto.service;

import java.util.List;

import com.projeto.model.ItemPedido;

public interface ItemPedidoService {
    
    void salvar(ItemPedido itemPedido);
    
    void editar(ItemPedido itemPedido);
    
    void deletar(Long id);
    
    ItemPedido buscarPorId(Long id);
    
    List<ItemPedido> buscarTodos();
    
}
