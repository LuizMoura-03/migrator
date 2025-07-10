package com.development.crud_migrated.services;

import com.development.crud_migrated.models.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Produto createProduto(Produto produto);

    Optional<Produto> getProdutoById(Long id);

    List<Produto> getAllProdutos();

}
