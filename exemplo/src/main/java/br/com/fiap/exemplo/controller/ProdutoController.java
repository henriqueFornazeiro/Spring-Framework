package br.com.fiap.exemplo.controller;

import br.com.fiap.exemplo.bean.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @GetMapping("cadastrar")
    public String abrirFormulario() {
        return "/produto/form";
    }

    @PostMapping("cadastrar")
    public String processarForm(Produto produto, Model model) {
        model.addAttribute("prod", produto);
        //System.out.print(produto.getNome() + " " + produto.getPreco());
        return "produto/sucesso";
    }

}
