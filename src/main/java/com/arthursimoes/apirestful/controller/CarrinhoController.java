// src/main/java/com/arthursimoes/apirestful/controller/CarrinhoController.java
package com.arthursimoes.apirestful.controller;

import com.arthursimoes.apirestful.model.Carrinho;
import com.arthursimoes.apirestful.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {
    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("/{carrinhoId}/adicionar/{produtoId}")
    public Carrinho adicionarProduto(@PathVariable Long carrinhoId, @PathVariable Long produtoId, @RequestParam int quantidade) {
        return carrinhoService.adicionarProduto(carrinhoId, produtoId, quantidade);
    }

    @PostMapping("/{carrinhoId}/remover/{produtoId}")
    public Carrinho removerProduto(@PathVariable Long carrinhoId, @PathVariable Long produtoId) {
        return carrinhoService.removerProduto(carrinhoId, produtoId);
    }

    @GetMapping("/{carrinhoId}")
    public Carrinho obterCarrinho(@PathVariable Long carrinhoId) {
        return carrinhoService.obterCarrinho(carrinhoId);
    }

    @PostMapping("/{carrinhoId}/finalizar")
    public void finalizarCompra(@PathVariable Long carrinhoId) {
        carrinhoService.finalizarCompra(carrinhoId);
    }
}
