package com.projeto.service;

import java.util.List;

import com.projeto.model.Pedido;

public interface PedidoService {

    void salvar(Pedido pedido);
    
    void editar(Pedido pedido);
    
    void deletar(Long id);
    
    Pedido buscarPorId(Long id);
    
    List<Pedido> buscarTodos();
    
   // boolean pedidoTemItens(Long id);
}
