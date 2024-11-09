package com.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.DAO.ItemPedidoDAO;
import com.projeto.model.ItemPedido;
import com.projeto.exception.NotFoundException; // Exceção personalizada (caso necessário)

@Service 
@Transactional(readOnly = false)
public class ItemPedidoServiceImpl implements ItemPedidoService {

    @Autowired
    private ItemPedidoDAO dao;

    @Override
    public void salvar(ItemPedido itemPedido) {
        dao.save(itemPedido);
    }

    @Override
    public void editar(ItemPedido itemPedido) {
        dao.update(itemPedido);
    }

    @Override
    public void deletar(Long id) {
    	ItemPedido itemPedido = dao.findById(id);
        
        if (itemPedido == null) {
            throw new NotFoundException("Item do pedido com ID  " + id + " não encontrado.");
        }

        dao.delete(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public ItemPedido buscarPorId(Long id) {
        ItemPedido itemPedido = dao.findById(id);
        if (itemPedido == null) {
            throw new NotFoundException("Item de pedido com ID " + id + " não encontrado.");
        }
        return itemPedido;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemPedido> buscarTodos() {
        return dao.findAll();
    }

    
}
