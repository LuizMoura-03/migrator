package com.development.crud_migrated.services;

import com.development.crud_migrated.models.Produto;
import com.development.crud_migrated.repositories.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProdutoServiceImplTest {

    private ProdutoRepository produtoRepository;
    private ProdutoServiceImpl produtoService;

    @BeforeEach
    void setUp() {
        produtoRepository = Mockito.mock(ProdutoRepository.class);
        produtoService = new ProdutoServiceImpl(produtoRepository);
    }

    @Test
    @DisplayName("Deve salvar e retornar o produto criado")
    void testCreateProduto() {
        Produto produto = new Produto(1L, "Produto Teste", LocalDate.now(), 10);
        when(produtoRepository.save(any(Produto.class))).thenReturn(produto);

        Produto result = produtoService.createProduto(produto);

        assertEquals(produto, result);
        verify(produtoRepository, times(1)).save(produto);
    }

    @Test
    @DisplayName("Deve retornar produto existente por ID")
    void testGetProdutoByIdFound() {
        Produto produto = new Produto(1L, "Produto Teste", LocalDate.now(), 10);
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        Optional<Produto> result = produtoService.getProdutoById(1L);

        assertTrue(result.isPresent());
        assertEquals(produto, result.get());
        verify(produtoRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve retornar Optional.empty() quando produto não existe")
    void testGetProdutoByIdNotFound() {
        when(produtoRepository.findById(2L)).thenReturn(Optional.empty());

        Optional<Produto> result = produtoService.getProdutoById(2L);

        assertTrue(result.isEmpty());
        verify(produtoRepository, times(1)).findById(2L);
    }

    @Test
    @DisplayName("Deve retornar lista de todos os produtos")
    void testGetAllProdutos() {
        Produto produto = new Produto(1L, "Produto Teste", LocalDate.now(), 10);
        when(produtoRepository.findAll()).thenReturn(List.of(produto));

        List<Produto> result = produtoService.getAllProdutos();

        assertEquals(1, result.size());
        assertEquals(produto, result.get(0));
        verify(produtoRepository, times(1)).findAll();
    }

}
