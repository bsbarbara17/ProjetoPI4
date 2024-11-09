package com.projeto.service;

import java.util.List;

import com.projeto.model.Comanda;

public interface ComandaService {
    
    void salvar(Comanda comanda);
    
    void editar(Comanda comanda);
    
    abstract void delete(Long id);
    
    Comanda buscarPorId(Long id);
    
    List<Comanda> buscarTodos();
    
  //  boolean comandaTemItens(Long id); // Supondo que uma comanda possa ter itens associados
}
