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

import com.projeto.model.Cliente;
import com.projeto.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Tela de cadastro de cliente
    @GetMapping("/cadastrar")
    public String exibirCadastro(Cliente cliente) {
        return "/cliente/cadastro";
    }

    // Lista todos os clientes cadastrados
    @GetMapping("/listar")
    public String listarClientes(ModelMap model) {
        model.addAttribute("clientes", clienteService.buscarTodos());
        return "/cliente/lista";
    }

    // Salva o cliente
    @PostMapping("/salvar")
    public String salvarCliente(Cliente cliente, RedirectAttributes attr) {
        clienteService.salvar(cliente);
        attr.addFlashAttribute("success", "Cliente inserido com sucesso!");
        return "redirect:/clientes/cadastrar";
    }

    // Tela de edição de cliente
    @GetMapping("/editar/{id}")
    public String exibirEdicao(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cliente", clienteService.buscarPorId(id));
        return "/cliente/cadastro";
    }

    // Atualiza o cliente
    @PostMapping("/editar")
    public String editarCliente(Cliente cliente, RedirectAttributes attr) {
        clienteService.editar(cliente);
        attr.addFlashAttribute("success", "Cliente atualizado com sucesso!");
        return "redirect:/clientes/cadastrar";
    }

    // Exclui o cliente
    @GetMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable("id") Long id, RedirectAttributes attr) {
        clienteService.excluir(id);
        attr.addFlashAttribute("success", "Cliente excluído com sucesso.");
        return "redirect:/clientes/listar";
    }

    // Carrega outros atributos necessários para o formulário, se houver
    @ModelAttribute("clientes")
    public List<Cliente> carregarClientes() {
        return clienteService.buscarTodos();
    }
}
