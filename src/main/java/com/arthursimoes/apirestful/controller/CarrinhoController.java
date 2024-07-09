package com.arthursimoes.apirestful.controller;

import com.arthursimoes.apirestful.model.Carrinho;
import com.arthursimoes.apirestful.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("/adicionar/{produtoId}")
    public Carrinho adicionarProduto(@PathVariable Long produtoId, @RequestParam int quantidade) {
        return carrinhoService.adicionarProduto(produtoId, quantidade);
    }

    @PutMapping("/diminuir/{produtoId}")
    public Carrinho diminuirQuantidadeProduto(@PathVariable Long produtoId) {
        return carrinhoService.diminuirQuantidadeProduto(produtoId);
    }

    @DeleteMapping("/remover/{produtoId}")
    public void removerProduto(@PathVariable Long produtoId) {
        carrinhoService.removerProduto(produtoId);
    }

    @GetMapping
    public List<Carrinho> obterCarrinho() {
        return carrinhoService.obterCarrinho();
    }

    @PostMapping("/finalizar")
    public void finalizarCompra() {
        carrinhoService.finalizarCompra();
    }
}
