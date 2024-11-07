package com.projeto.service;

import org.springframework.stereotype.Service;

import com.projeto.model.Comanda;
import com.projeto.repository.ComandaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComandaService {

    private final ComandaRepository comandaRepository;

    public ComandaService(ComandaRepository comandaRepository) {
        this.comandaRepository = comandaRepository;
    }

    // Método para listar todas as comandas
    public List<Comanda> listarComandas() {
        return comandaRepository.findAll();
    }

    // Método para salvar uma comanda
    public Comanda salvarComanda(Comanda comanda) {
        return comandaRepository.save(comanda);
    }

    // Método para obter uma comanda por ID
    public Comanda obterComandaPorId(Long idCarrinho) {
        Optional<Comanda> comandaOptional = comandaRepository.findById(idCarrinho);
        return comandaOptional.orElse(null); // Retorna null caso não encontre
    }

    // Método para excluir uma comanda por ID
    public void excluirComanda(Long idCarrinho) {
        comandaRepository.deleteById(idCarrinho);
    }
}

