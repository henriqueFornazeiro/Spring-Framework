package br.com.fiap.exemplo.controller;

import org.springframework.web.bind.annotation.PostMapping;

public class Produto {
    private String nome;
    private double preco;

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
    public String processarForm(Produto produto){
        System.out.print(produto.getNome() + " " + produto.getPreco());
        return "produto/sucesso";
    }


}
