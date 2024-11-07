package com.projeto.controller;

import org.springframework.web.bind.annotation.*;

import com.projeto.model.ItemPedido;
import com.projeto.service.ItemPedidoService;

import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

    @GetMapping
    public List<ItemPedido> listarItensPedido() {
        return itemPedidoService.listarItensPedido();
    }

    @PostMapping
    public ItemPedido salvarItemPedido(@RequestBody ItemPedido itemPedido) {
        return itemPedidoService.salvarItemPedido(itemPedido);
    }

    @GetMapping("/{id}")
    public ItemPedido obterItemPedido(@PathVariable Long id) {
        return itemPedidoService.obterItemPedidoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluirItemPedido(@PathVariable Long id) {
        itemPedidoService.excluirItemPedido(id);
    }
}
