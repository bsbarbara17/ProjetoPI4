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

import com.projeto.model.Produto;
import com.projeto.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    

    // Tela de cadastro de produto
    @GetMapping("/cadastrar")
    public String exibirCadastro(Produto produto) {
        return "/produto/cadastro";
    }
    
    // Lista todos os produtos cadastrados
    @GetMapping("/listar")
    public String listarProdutos(ModelMap model) {
        model.addAttribute("produtos", produtoService.buscarTodos());
        return "/produto/lista";
    }
    
    // Salva o produto
    @PostMapping("/salvar")
    public String salvarProduto(Produto produto, RedirectAttributes attr) {
        produtoService.salvar(produto);
        attr.addFlashAttribute("success", "Produto inserido com sucesso!");
        return "redirect:/produtos/cadastrar";
    }
    
    // Tela de edição de produto
    @GetMapping("/editar/{id}")
    public String exibirEdicao(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("produto", produtoService.buscarPorId(id));
        return "/produto/cadastro";
    }
    
    // Atualiza o produto
    @PostMapping("/editar")
    public String editarProduto(Produto produto, RedirectAttributes attr) {
        produtoService.editar(produto);
        attr.addFlashAttribute("success", "Produto atualizado com sucesso!");
        return "redirect:/produtos/cadastrar";
    }
    
    // Exclui o produto
    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable("id") Long id, RedirectAttributes attr) {
        
            produtoService.deletar(id);
            attr.addFlashAttribute("success", "Produto excluído com sucesso.");
   
        return "redirect:/produtos/listar";
    }
}
