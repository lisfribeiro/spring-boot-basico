package io.github.lisfribeiro.exerciciossb.controllers;

import io.github.lisfribeiro.exerciciossb.model.entities.Produto;
import io.github.lisfribeiro.exerciciossb.model.entities.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

   @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto novoProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public Iterable<Produto> obterProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/parte/{nome}")
    public Iterable<Produto> obterprodutosPorNome(@PathVariable String nome) {
       return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/pagina/{numeroPagina}")
    public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina, int qtdePagina) {
        if (qtdePagina >= 5) qtdePagina = 5;
            Pageable page = PageRequest.of(numeroPagina, qtdePagina);
        return produtoRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterProdutos(@PathVariable Integer id) {
        return produtoRepository.findById(id);
    }

//    @PutMapping
//    public Produto alterarProduto(@Valid Produto produto) {
//        produtoRepository.save(produto);
//        return produto;
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
       produtoRepository.deleteById(id);
    }
}