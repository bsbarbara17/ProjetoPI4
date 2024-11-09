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

import com.projeto.model.Comanda;
import com.projeto.model.Cliente;
import com.projeto.service.ComandaService;
import com.projeto.service.ClienteService;

@Controller
@RequestMapping("/comandas")
public class ComandaController {

    @Autowired
    private ComandaService comandaService;

    @Autowired
    private ClienteService clienteService;

    // Exibe o formulário de cadastro de comanda
    @GetMapping("/cadastrar")
    public String exibirCadastro(Comanda comanda) {
        return "/comanda/cadastro";
    }

    // Lista todas as comandas
    @GetMapping("/listar")
    public String listarComandas(ModelMap model) {
        model.addAttribute("comandas", comandaService.buscarTodos());
        return "/comanda/lista";
    }

    // Salva uma nova comanda
    @PostMapping("/salvar")
    public String salvarComanda(Comanda comanda, RedirectAttributes attr) {
        comandaService.salvar(comanda);
        attr.addFlashAttribute("success", "Comanda inserida com sucesso!");
        return "redirect:/comandas/cadastrar";
    }

    // Exibe o formulário para editar a comanda existente
    @GetMapping("/editar/{id}")
    public String exibirEdicao(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("comanda", comandaService.buscarPorId(id));
        return "/comanda/cadastro";
    }

    // Edita uma comanda existente
    @PostMapping("/editar")
    public String editarComanda(Comanda comanda, RedirectAttributes attr) {
        comandaService.editar(comanda);
        attr.addFlashAttribute("success", "Comanda atualizada com sucesso!");
        return "redirect:/comandas/cadastrar";
    }

    // Exclui a comanda
    @GetMapping("/excluir/{id}")
    public String excluirComanda(@PathVariable("id") Long id, RedirectAttributes attr) {
  
            comandaService.delete(id);
            attr.addFlashAttribute("success", "Comanda excluída com sucesso.");
      
        return "redirect:/comandas/listar";
    }

    // Carrega todos os clientes para o formulário de cadastro e edição de comandas
    @ModelAttribute("clientes")
    public List<Cliente> carregarClientes() {
        return clienteService.buscarTodos();
    }
}
