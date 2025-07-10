package com.development.crud_migrated.repositories;

import com.development.crud_migrated.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {

}
