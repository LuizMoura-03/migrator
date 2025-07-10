package com.development.crud_migrated.models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProdutoTest {

    private final Validator validator;

    public ProdutoTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    @DisplayName("Deve acusar erro quando campos obrigatórios estão nulos ou em branco")
    void deveValidarCamposObrigatorios() {
        Produto produto = new Produto();
        produto.setNome("");
        produto.setDataCriacao(null);
        produto.setQuantidadeDisponivel(null);

        Set<ConstraintViolation<Produto>> violations = validator.validate(produto);
        assertEquals(3, violations.size());
    }

    @Test
    @DisplayName("Não deve acusar erro quanto todos os campos obrigatórios estão preenchidos")
    void naoDeveAcusarErroQuandoCamposValidos() {
        Produto produto = new Produto();
        produto.setNome("Produto Teste");
        produto.setDataCriacao(java.time.LocalDate.now());
        produto.setQuantidadeDisponivel(10);

        Set<ConstraintViolation<Produto>> violations = validator.validate(produto);
        assertTrue(violations.isEmpty());
    }

    @Test
    @DisplayName("Deve criar Produto corretamente com construtor completo e acessar getters/setters")
    void testProdutoConstructorAndGettersSetters() {
        LocalDate data = LocalDate.of(2025, 7, 8);
        Produto produto = new Produto(1L, "Produto Teste", data, 10);

        assertEquals(1L, produto.getId());
        assertEquals("Produto Teste", produto.getNome());
        assertEquals(data, produto.getDataCriacao());
        assertEquals(10, produto.getQuantidadeDisponivel());

        produto.setId(2L);
        produto.setNome("Outro Produto");
        produto.setDataCriacao(LocalDate.of(2025, 7, 8));
        produto.setQuantidadeDisponivel(20);

        assertEquals(2L, produto.getId());
        assertEquals("Outro Produto", produto.getNome());
        assertEquals(LocalDate.of(2025, 7, 8), produto.getDataCriacao());
        assertEquals(20, produto.getQuantidadeDisponivel());
    }

}
