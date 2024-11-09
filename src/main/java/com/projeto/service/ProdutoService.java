package com.projeto.service;

import java.util.List;

import com.projeto.model.Produto;

public interface ProdutoService {

    void salvar(Produto produto);
    
    void editar(Produto produto);
    
    void deletar(Long id);
    
    Produto buscarPorId(Long id);
    
    List<Produto> buscarTodos();
    
   //  boolean produtoTemEstoque(Long id);
}
