// src/main/java/com/arthursimoes/apirestful/repository/CarrinhoRepository.java
package com.arthursimoes.apirestful.repository;

import com.arthursimoes.apirestful.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
