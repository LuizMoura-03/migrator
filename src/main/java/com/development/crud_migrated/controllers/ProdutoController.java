package com.development.crud_migrated.controllers;

import com.development.crud_migrated.models.Produto;
import com.development.crud_migrated.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    /**
     * Endpoint para cadastrar um novo produto.
     *
     * Esta implementação é baseada na migração de uma classe Node.js para Java.
     * No Node.js, o método createProduto recebia o request e response e utilizava um array para simular a base de dados.
     * Em Java, estamos utilizando o Spring Boot e o Spring Data JPA para persistência.
     *
     * @param produto objeto enviado na requisição, contendo os dados do produto
     * @return ResponseEntity com o produto salvo (status 201) ou mensagem de erro (status 400)
     */

    @PostMapping
    public ResponseEntity<Produto> createProduto(@Valid @RequestBody Produto produto) {
        Produto savedProduto = produtoService.createProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduto);
    }


    /**
     * Endpoint para buscar um produto por ID.
     *
     * Este método corresponde ao método getProduto na implementação Node.js original.
     *
     * @param id identificador único do produto (gerado automaticamente no cadastro)
     * @return ResponseEntity com o produto encontrado (status 200) ou mensagem de erro (status 404)
     */

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduto(@PathVariable Long id) {
        return produtoService.getProdutoById(id)
                .map(produto -> ResponseEntity.ok((Object) produto))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body((Object) Map.of("message", "Produto não encontrado")));
    }


    @GetMapping
    public ResponseEntity<Object> getAllProdutos() {
        return ResponseEntity.ok((Object) produtoService.getAllProdutos());
    }

}
