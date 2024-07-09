package com.arthursimoes.apirestful.service;

import com.arthursimoes.apirestful.model.Carrinho;
import com.arthursimoes.apirestful.model.Produto;
import com.arthursimoes.apirestful.repository.CarrinhoRepository;
import com.arthursimoes.apirestful.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Carrinho adicionarProduto(Long produtoId, int quantidade) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Carrinho carrinho = carrinhoRepository.findByProdutoId(produtoId).stream().findFirst()
                .orElse(new Carrinho());

        carrinho.setProduto(produto);
        carrinho.setQuantidade(carrinho.getQuantidade() + quantidade);

        return carrinhoRepository.save(carrinho);
    }

    public Carrinho diminuirQuantidadeProduto(Long produtoId) {
        Carrinho carrinho = carrinhoRepository.findByProdutoId(produtoId).stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Produto não encontrado no carrinho"));

        if (carrinho.getQuantidade() > 1) {
            carrinho.setQuantidade(carrinho.getQuantidade() - 1);
            return carrinhoRepository.save(carrinho);
        } else {
            carrinhoRepository.delete(carrinho);
            return null;
        }
    }

    public void removerProduto(Long produtoId) {
        Carrinho carrinho = carrinhoRepository.findByProdutoId(produtoId).stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Produto não encontrado no carrinho"));
        carrinhoRepository.delete(carrinho);
    }

    public List<Carrinho> obterCarrinho() {
        return carrinhoRepository.findAll();
    }

    public void finalizarCompra() {
        carrinhoRepository.deleteAll();
    }
}
