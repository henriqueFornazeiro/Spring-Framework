package br.com.fiap.springdata02;

import br.com.fiap.springdata02.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
