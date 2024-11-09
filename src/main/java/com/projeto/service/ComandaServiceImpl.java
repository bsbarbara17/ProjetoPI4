package com.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.DAO.ComandaDAO;
import com.projeto.model.Cliente;
import com.projeto.model.Comanda;
import com.projeto.exception.NotFoundException; // Exceção personalizada, caso necessário

@Service 
@Transactional(readOnly = false)
public class ComandaServiceImpl implements ComandaService {
    
    @Autowired
    private ComandaDAO dao;

    @Override
    public void salvar(Comanda comanda) {
        dao.save(comanda);
    }

    @Override
    public void editar(Comanda comanda) {
        dao.update(comanda);
    }
    
    
    @Override
    public void delete(Long id) {
    	Comanda comanda = dao.findById(id);
        
        if (comanda == null) {
            throw new NotFoundException("Comanda com ID " + id + " não encontrado.");
        }

        dao.delete(id); 
    }




    @Override
    @Transactional(readOnly = true)
    public Comanda buscarPorId(Long id) {
        Comanda comanda = dao.findById(id);
        if (comanda == null) {
            throw new NotFoundException("Comanda com ID " + id + " não encontrada.");
        }
        return comanda;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comanda> buscarTodos() {
        return dao.findAll();
    }

   
}
