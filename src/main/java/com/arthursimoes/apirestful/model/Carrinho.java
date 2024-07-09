// src/main/java/com/arthursimoes/apirestful/model/Carrinho.java
package com.arthursimoes.apirestful.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private Map<Produto, Integer> produtos = new HashMap<>();

    public BigDecimal calcularTotal() {
        return produtos.entrySet().stream()
                .map(entry -> entry.getKey().getPreco().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
