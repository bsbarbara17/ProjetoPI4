package com.projeto.controller;

import org.springframework.web.bind.annotation.*;

import com.projeto.model.Comanda;
import com.projeto.service.ComandaService;

import java.util.List;

@RestController
@RequestMapping("/comandas")
public class ComandaController {

    private final ComandaService comandaService;

    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @GetMapping
    public List<Comanda> listarComandas() {
        return comandaService.listarComandas();
    }

    @PostMapping
    public Comanda salvarComanda(@RequestBody Comanda comanda) {
        return comandaService.salvarComanda(comanda);
    }

    @GetMapping("/{idCarrinho}")
    public Comanda obterComanda(@PathVariable Long idCarrinho) {
        return comandaService.obterComandaPorId(idCarrinho);
    }

    @DeleteMapping("/{idCarrinho}")
    public void excluirComanda(@PathVariable Long idCarrinho) {
        comandaService.excluirComanda(idCarrinho);
    }
}
