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

import com.projeto.model.Funcionario;
import com.projeto.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Tela de cadastro de funcionário
    @GetMapping("/cadastrar")
    public String exibirCadastro(Funcionario funcionario) {
        return "/funcionario/cadastro";
    }

    // Lista todos os funcionários cadastrados
    @GetMapping("/listar")
    public String listarFuncionarios(ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.buscarTodos());
        return "/funcionario/lista";
    }

    // Salva o funcionário
    @PostMapping("/salvar")
    public String salvarFuncionario(Funcionario funcionario, RedirectAttributes attr) {
        funcionarioService.salvar(funcionario);
        attr.addFlashAttribute("success", "Funcionário inserido com sucesso!");
        return "redirect:/funcionarios/cadastrar";
    }

    // Tela de edição de funcionário
    @GetMapping("/editar/{id}")
    public String exibirEdicao(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        return "/funcionario/cadastro";
    }

    // Atualiza o funcionário
    @PostMapping("/editar")
    public String editarFuncionario(Funcionario funcionario, RedirectAttributes attr) {
        funcionarioService.editar(funcionario);
        attr.addFlashAttribute("success", "Funcionário atualizado com sucesso!");
        return "redirect:/funcionarios/cadastrar";
    }

    // Exclui o funcionário
    @GetMapping("/excluir/{id}")
    public String excluirFuncionario(@PathVariable("id") Long id, RedirectAttributes attr) {
        
            funcionarioService.delete(id);
            attr.addFlashAttribute("success", "Funcionário excluído com sucesso.");
   
        return "redirect:/funcionarios/listar";
    }

    // Carrega a lista de cargos para o formulário
    // @ModelAttribute("cargos")
    // public List<Cargo> carregarCargos() {
    //    return cargoService.buscarTodos();
    // }

    // Carrega a lista de departamentos para o formulário
    // @ModelAttribute("departamentos")
    // public List<Departamento> carregarDepartamentos() {
    //    return departamentoService.buscarTodos();
    // }
}
