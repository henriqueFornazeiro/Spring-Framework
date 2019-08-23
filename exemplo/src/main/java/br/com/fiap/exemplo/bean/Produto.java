package br.com.fiap.exemplo.bean;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private String quantidade;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @PostMapping("/produto/cadastrar")
    public String processarForm(Produto produto, Model model) {
        model.addAttribute("prod", produto);
        //System.out.print(produto.getNome() + " " + produto.getPreco());
        return "produto/sucesso";
    }


}
