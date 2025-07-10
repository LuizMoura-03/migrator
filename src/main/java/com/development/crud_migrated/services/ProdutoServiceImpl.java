package com.development.crud_migrated.services;

import com.development.crud_migrated.models.Produto;
import com.development.crud_migrated.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService{


    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

}
