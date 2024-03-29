package br.com.fiap.springrest03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> listar(){
        return repository.findAll();
    }

    @GetMapping("{codigo}")
    public Produto buscar(@PathVariable int codigo){
        return repository.findById(codigo).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
        return repository.save(produto);
    }

    @PutMapping("{id}")
    public Produto atualizar(@RequestBody Produto produto,
                             @PathVariable int id){
        produto.setCodigo(id);
        return repository.save(produto);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo){
        repository.deleteById(codigo);
    }

}

