package br.com.fiap.pesquisas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/produto/pesquisar")
    public String abrirPesquisa(){
        return "pesquisa";
    }

    @PostMapping("/produto/pesquisar")
    public String processarForm(String nome, double preco, Model model){
        List<Produto> produtos = repository.findByNomeAndPreco(nome, preco);
        model.addAttribute("produtos", produtos);
        return "sucesso";
    }

    @GetMapping("/produto/pesquisar2")
    public String abrirPesquisa2(){
        return "pesquisa2";
    }

    @PostMapping("/produto/pesquisar2")
    public String processarForm(double preco, Model model){
        List<Produto> produtos = repository.findByPrecoGreaterThan(preco);
        model.addAttribute("produtos", produtos);
        return "sucesso";
    }

    @GetMapping("/produto/pesquisar3")
    public String abrirPesquisa3(){
        return "pesquisa3";
    }

    @PostMapping("/produto/pesquisar3")
    public String processarForm3(double preco, Model model){
        List<Produto> produtos = repository.findByPrecoOrderByNomeDesc(preco);
        model.addAttribute("produtos", produtos);
        return "sucesso";
    }

    @GetMapping("/produto/pesquisar4")
    public String abrirPesquisa4(){
        return "pesquisa4";
    }

    @PostMapping("/produto/pesquisar4")
    public String processarForm4(String nome, Model model){
        List<Produto> produtos = repository.findByNomeIgnoreCaseOrderByPrecoAsc(nome);
        model.addAttribute("produtos", produtos);
        return "sucesso";
    }

    @GetMapping("/produto/cadastrar")
    public String abrirFormulario(){
        return "cadastro";
    }

    @PostMapping("/produto/cadastrar")
    public String processarForm(Produto produto, Model model){
        repository.save(produto);
        model.addAttribute("prod", produto);
        return "sucesso";
    }

    @GetMapping("/home")
    public String abrirHome(){
        return "home";
    }
}
