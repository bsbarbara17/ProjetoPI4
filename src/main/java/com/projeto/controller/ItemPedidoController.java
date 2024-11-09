package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.model.ItemPedido;
import com.projeto.model.Comanda;
import com.projeto.service.ItemPedidoService;
import com.projeto.service.ComandaService;

@Controller
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @Autowired
    private ComandaService comandaService;

    // Tela de cadastro de ItemPedido
    @GetMapping("/cadastrar")
    public String exibirCadastro(ItemPedido itemPedido) {
        return "/itempedido/cadastro";
    }

    // Lista todos os itens de pedidos cadastrados
    @GetMapping("/listar")
    public String listarItens(ModelMap model) {
        model.addAttribute("itensPedido", itemPedidoService.buscarTodos());
        return "/itempedido/lista";
    }

    // Salva o ItemPedido
    @PostMapping("/salvar")
    public String salvarItemPedido(ItemPedido itemPedido, RedirectAttributes attr) {
        itemPedidoService.salvar(itemPedido);
        attr.addFlashAttribute("success", "Item de pedido inserido com sucesso!");
        return "redirect:/itens-pedido/cadastrar";
    }

    // Tela de edição de ItemPedido
    @GetMapping("/editar/{id}")
    public String exibirEdicao(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("itemPedido", itemPedidoService.buscarPorId(id));
        return "/itempedido/cadastro";
    }

    // Atualiza o ItemPedido
    @PostMapping("/editar")
    public String editarItemPedido(ItemPedido itemPedido, RedirectAttributes attr) {
        itemPedidoService.editar(itemPedido);
        attr.addFlashAttribute("success", "Item de pedido atualizado com sucesso!");
        return "redirect:/itens-pedido/cadastrar";
    }

    // Exclui o ItemPedido
    @GetMapping("/excluir/{id}")
    public String excluirItemPedido(@PathVariable("id") Long id, RedirectAttributes attr) {
      
            itemPedidoService.deletar(id);
            attr.addFlashAttribute("success", "Item de pedido excluído com sucesso.");
  
        return "redirect:/itens-pedido/listar";
    }

    // Carrega a lista de carrinhos para o formulário
    @ModelAttribute("comanda")
    public List<Comanda> carregarCarrinhos() {
        return comandaService.buscarTodos();
    }
}
