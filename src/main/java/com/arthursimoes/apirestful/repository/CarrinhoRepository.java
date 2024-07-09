package com.arthursimoes.apirestful.repository;

import com.arthursimoes.apirestful.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    List<Carrinho> findByProdutoId(Long produtoId);
}
