package io.github.lisfribeiro.exerciciossb.model.entities.repositories;

import io.github.lisfribeiro.exerciciossb.model.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository
        extends JpaRepository<Produto, Integer> {

    public Iterable<Produto> findByNomeContainingIgnoreCase(String nome);
}