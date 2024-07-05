package com.arthursimoes.apirestful.service;

import com.arthursimoes.apirestful.exception.EntidadeDestacadaException;
import com.arthursimoes.apirestful.exception.EntidadeTransienteException;
import com.arthursimoes.apirestful.repository.ProdutoRepository;
import com.arthursimoes.apirestful.exception.EntidadeNaoEncontradaException;
import com.arthursimoes.apirestful.model.Produto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> recuperarProdutos() {
        return produtoRepository.recuperarProdutosComCategoria();
    }

    public Produto cadastrarProduto(Produto produto) {
        if (produto.getId() == null) {
            return produtoRepository.save(produto);
        }
        else {
            throw new EntidadeDestacadaException(
                "Tentando cadastrar um objeto destacado.");
        }
    }

//    public Produto alterarProduto(Produto produto) {
//        if (produto.getId() == null) {
//            throw new EntidadeTransienteException("Tentando alterar um objeto transiente.");
//        }
//        else {
//            if (produtoRepository.findById(produto.getId()).isPresent()) {
//                return produtoRepository.save(produto);
//            }
//            else {
//                throw new EntidadeNaoEncontradaException(
//                        "Produto número " + produto.getId() + " não encontrado.");
//            }
//        }
//    }

    @Transactional
    public Produto alterarProduto(Produto produto) {
        if (produto.getId() == null) {
            throw new EntidadeTransienteException("Tentando alterar um objeto transiente.");
        }
        else {
            produtoRepository.recuperarPorIdComLock(produto.getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                      "Produto número " + produto.getId() + " não encontrado."));
            return produtoRepository.save(produto);
        }
    }

    public Produto removerProduto(Long id) {
        Produto p = produtoRepository.recuperarProdutoPorId(id)
            .orElseThrow(() -> new EntidadeNaoEncontradaException(
                "Produto número " + id + " não encontrado."));
        produtoRepository.delete(p);
        return p;
    }

    public List<Produto> recuperarProdutosPorIdDaCategoria(Long idCategoria) {
        return produtoRepository.findByCategoriaId(idCategoria);
    }

    public List<Produto> recuperarProdutosComCategoria() {
        // return produtoRepository.findAll();
        return produtoRepository.recuperarProdutosComCategoria();
    }

    public Page<Produto> recuperarProdutosComPaginacao(String nome, Pageable pageable) {
        return produtoRepository.recuperarProdutosComPaginacao(nome, pageable);
    }
}
