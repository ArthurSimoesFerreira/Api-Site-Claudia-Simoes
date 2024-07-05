package com.arthursimoes.apirestful.service;

import com.arthursimoes.apirestful.model.Categoria;
import com.arthursimoes.apirestful.repository.ProdutoRepository;
import com.arthursimoes.apirestful.exception.EntidadeNaoEncontradaException;
import com.arthursimoes.apirestful.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Optional<Categoria> recuperarCategoria(Long idCategoria) {
        return categoriaRepository.findById(idCategoria);
    }

    public Categoria recuperarCategoriaComProdutos(Long idCategoria) {
        return categoriaRepository.recuperarCategoriaComProdutosPorIdDaCategoria(idCategoria)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Categoria número " + idCategoria + " não encontrada"));
    }
}
