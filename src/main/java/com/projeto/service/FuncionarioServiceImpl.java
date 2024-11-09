package com.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.DAO.FuncionarioDAO;
import com.projeto.model.Comanda;
import com.projeto.model.Funcionario;
import com.projeto.exception.NotFoundException;

@Service 
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {
    
    @Autowired
    private FuncionarioDAO dao;

    @Override
    public void salvar(Funcionario funcionario) {
        dao.save(funcionario);
    }

    @Override
    public void editar(Funcionario funcionario) {
        dao.update(funcionario);
    }
    
    @Override
    public void delete(Long id) {
    	Funcionario funcionario = dao.findById(id);
        
        if (funcionario == null) {
            throw new NotFoundException("Funcionario com ID " + id + " não encontrado.");
        }

        dao.delete(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public Funcionario buscarPorId(Long id) {
        Funcionario funcionario = dao.findById(id);
        if (funcionario == null) {
            throw new NotFoundException("Funcionário com ID " + id + " não encontrado.");
        }
        return funcionario;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcionario> buscarTodos() {
        return dao.findAll();
    }
}
