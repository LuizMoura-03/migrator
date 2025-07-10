package com.development.crud_migrated.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo 'nome' é obrigatório.")
    private String nome;

    @NotNull(message = "O campo 'dataCriacao' é obrigatório.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao;

    @NotNull(message = "O campo 'quantidadeDisponivel' é obrigatório.")
    private Integer quantidadeDisponivel;

    public Produto() {}

    public Produto(Long id, String nome, LocalDate dataCriacao, Integer quantidadeDisponivel) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}

