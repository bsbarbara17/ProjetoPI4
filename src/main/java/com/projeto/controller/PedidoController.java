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

import com.projeto.model.Pedido;
import com.projeto.model.Cliente;
import com.projeto.service.PedidoService;
import com.projeto.service.ClienteService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
    private ClienteService clienteService;

    // Exibe o formulário de cadastro de pedido
    @GetMapping("/cadastrar")
    public String exibirCadastro(Pedido pedido) {
        return "/pedido/cadastro";
    }

    // Lista todos os pedidos cadastrados
    @GetMapping("/listar")
    public String listarPedidos(ModelMap model) {
        model.addAttribute("pedidos", pedidoService.buscarTodos());
        return "/pedido/lista";
    }

    // Salva o pedido
    @PostMapping("/salvar")
    public String salvarPedido(Pedido pedido, RedirectAttributes attr) {
        pedidoService.salvar(pedido);
        attr.addFlashAttribute("success", "Pedido inserido com sucesso!");
        return "redirect:/pedidos/cadastrar";
    }

    // Exibe o formulário para editar um pedido existente
    @GetMapping("/editar/{id}")
    public String exibirEdicao(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pedido", pedidoService.buscarPorId(id));
        return "/pedido/cadastro";
    }

    // Atualiza o pedido
    @PostMapping("/editar")
    public String editarPedido(Pedido pedido, RedirectAttributes attr) {
        pedidoService.editar(pedido);
        attr.addFlashAttribute("success", "Pedido atualizado com sucesso!");
        return "redirect:/pedidos/cadastrar";
    }

    // Exclui um pedido
    @GetMapping("/excluir/{id}")
    public String excluirPedido(@PathVariable("id") Long id, RedirectAttributes attr) {
        pedidoService.deletar(id);
        attr.addFlashAttribute("success", "Pedido excluído com sucesso.");
        return "redirect:/pedidos/listar";
    }

    // Carrega a lista de clientes para o formulário
    @ModelAttribute("clientes")
    public List<Cliente> carregarClientes() {
        return clienteService.buscarTodos();
    }
}
