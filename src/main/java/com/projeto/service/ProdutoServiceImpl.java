package com.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.DAO.ProdutoDAO;
import com.projeto.model.Pedido;
import com.projeto.model.Produto;
import com.projeto.exception.NotFoundException; // Exceção personalizada

@Service
@Transactional(readOnly = false)
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoDAO dao;

    @Override
    public void salvar(Produto produto) {
        dao.save(produto);
    }

    @Override
    public void editar(Produto produto) {
        dao.update(produto);
    }
    
    @Override
    public void deletar(Long id) {
    	Produto produto = dao.findById(id);
        
        if (produto == null) {
            throw new NotFoundException("Produto com ID " + id + " não encontrado.");
        }

        dao.delete(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public Produto buscarPorId(Long id) {
        Produto produto = dao.findById(id);
        if (produto == null) {
            throw new NotFoundException("Produto com ID " + id + " não encontrado.");
        }
        return produto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Produto> buscarTodos() {
        return dao.findAll();
    }
}
