package com.projeto.service;

import java.util.List;

import com.projeto.model.Funcionario;

public interface FuncionarioService {
    
    void salvar(Funcionario funcionario);
    
    void editar(Funcionario funcionario);
    
    void delete(Long id);
    
    Funcionario buscarPorId(Long id);
    
    List<Funcionario> buscarTodos();
    
   // boolean funcionarioTemCargo(Long id);
}
