// src/main/java/com/arthursimoes/apirestful/service/CarrinhoService.java
package com.arthursimoes.apirestful.service;

import com.arthursimoes.apirestful.model.Carrinho;
import com.arthursimoes.apirestful.model.Produto;
import com.arthursimoes.apirestful.repository.CarrinhoRepository;
import com.arthursimoes.apirestful.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Carrinho adicionarProduto(Long carrinhoId, Long produtoId, int quantidade) {
        Optional<Carrinho> carrinhoOpt = carrinhoRepository.findById(carrinhoId);
        Optional<Produto> produtoOpt = produtoRepository.findById(produtoId);

        if (carrinhoOpt.isPresent() && produtoOpt.isPresent()) {
            Carrinho carrinho = carrinhoOpt.get();
            Produto produto = produtoOpt.get();
            carrinho.getProdutos().put(produto, carrinho.getProdutos().getOrDefault(produto, 0) + quantidade);
            return carrinhoRepository.save(carrinho);
        } else {
            throw new RuntimeException("Carrinho ou Produto não encontrado");
        }
    }

    public Carrinho removerProduto(Long carrinhoId, Long produtoId) {
        Optional<Carrinho> carrinhoOpt = carrinhoRepository.findById(carrinhoId);
        Optional<Produto> produtoOpt = produtoRepository.findById(produtoId);

        if (carrinhoOpt.isPresent() && produtoOpt.isPresent()) {
            Carrinho carrinho = carrinhoOpt.get();
            Produto produto = produtoOpt.get();
            carrinho.getProdutos().remove(produto);
            return carrinhoRepository.save(carrinho);
        } else {
            throw new RuntimeException("Carrinho ou Produto não encontrado");
        }
    }

    public Carrinho obterCarrinho(Long carrinhoId) {
        return carrinhoRepository.findById(carrinhoId).orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
    }

    public void finalizarCompra(Long carrinhoId) {
        carrinhoRepository.deleteById(carrinhoId);
    }
}
