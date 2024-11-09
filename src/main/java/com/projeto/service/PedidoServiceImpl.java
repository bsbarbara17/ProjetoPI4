package com.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.DAO.PedidoDAO;
import com.projeto.model.Pedido;
import com.projeto.exception.NotFoundException;

@Service
@Transactional(readOnly = false)
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoDAO dao;

    @Override
    public void salvar(Pedido pedido) {
        dao.save(pedido);
    }

    @Override
    public void editar(Pedido pedido) {
        dao.update(pedido);
    }
    
    @Override
    public void deletar(Long id) {
    	Pedido pedido = dao.findById(id);
        
        if (pedido == null) {
            throw new NotFoundException("Pedido com ID " + id + " não encontrado.");
        }

        dao.delete(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public Pedido buscarPorId(Long id) {
        Pedido pedido = dao.findById(id);
        if (pedido == null) {
            throw new NotFoundException("Pedido com ID " + id + " não encontrado.");
        }
        return pedido;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> buscarTodos() {
        return dao.findAll();
    }

}
