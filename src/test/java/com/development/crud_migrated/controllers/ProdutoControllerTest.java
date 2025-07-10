package com.development.crud_migrated.controllers;

import com.development.crud_migrated.models.Produto;
import com.development.crud_migrated.services.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ProdutoControllerTest {

    private ProdutoService produtoService;
    private ProdutoController produtoController;

    @BeforeEach
    void setUp() {
        produtoService = Mockito.mock(ProdutoService.class);
        produtoController = new ProdutoController();
        produtoController.setProdutoService(produtoService);
    }

    @Test
    @DisplayName("Deve criar um produto e retornar status 201")
    void testCreateProduto() {
        Produto produto = new Produto(1L, "Produto Teste", LocalDate.now(), 10);
        when(produtoService.createProduto(any(Produto.class))).thenReturn(produto);

        ResponseEntity<Produto> response = produtoController.createProduto(produto);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(produto, response.getBody());
    }

    @Test
    @DisplayName("Deve retornar produto existente por ID com status 200")
    void testGetProdutoFound() {
        Produto produto = new Produto(1L, "Produto Teste", LocalDate.now(), 10);
        when(produtoService.getProdutoById(1L)).thenReturn(Optional.of(produto));

        ResponseEntity<Object> response = produtoController.getProduto(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(produto, response.getBody());
    }

    @Test
    @DisplayName("Deve retornar status 404 ao buscar produto inexistente")
    void testGetProdutoNotFound() {
        when(produtoService.getProdutoById(2L)).thenReturn(Optional.empty());

        ResponseEntity<Object> response = produtoController.getProduto(2L);

        assertEquals(404, response.getStatusCodeValue());
        assertEquals(Map.of("message", "Produto não encontrado"), response.getBody());
    }

    @Test
    @DisplayName("Deve listar todos os produtos com status 200")
    void testGetAllProdutos() {
        Produto produto = new Produto(1L, "Produto Teste", LocalDate.now(), 10);
        when(produtoService.getAllProdutos()).thenReturn(List.of(produto));

        ResponseEntity<Object> response = produtoController.getAllProdutos();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(List.of(produto), response.getBody());
    }

}
