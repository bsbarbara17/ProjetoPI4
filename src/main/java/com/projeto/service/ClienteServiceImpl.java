package com.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.DAO.ClienteDAO;
import com.projeto.model.Cliente;
import com.projeto.exception.NotFoundException;

@Service 
@Transactional(readOnly = false)
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDAO dao;

    @Override
    public void salvar(Cliente cliente) {
        dao.save(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        dao.update(cliente);
    }

    @Override
    public void excluir(Long id) {
        Cliente cliente = dao.findById(id);
        
        if (cliente == null) {
            throw new NotFoundException("Cliente com ID " + id + " não encontrado.");
        }

        dao.delete(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id) {
        Cliente cliente = dao.findById(id);
        if (cliente == null) {
            throw new NotFoundException("Cliente com ID " + id + " não encontrado.");
        }
        return cliente;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> buscarTodos() {
        return dao.findAll();
    }

    

}
