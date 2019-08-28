package br.com.fiap.springdata02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "form";
    }

    @GetMapping("/buscar")
    public String buscar() {
        return "busca";
    }

    @PostMapping("/cadastrar")
    public String processarForm(Produto produto) {
        repository.save(produto);
        return "sucesso";
    }

    @PostMapping("/buscar")
    public String processarBusca(int codigo, Model model) {
        Optional<Produto> produto = repository.findById(codigo);
        model.addAttribute("prod", produto);
        return "resultadoBusca";
    }
}
