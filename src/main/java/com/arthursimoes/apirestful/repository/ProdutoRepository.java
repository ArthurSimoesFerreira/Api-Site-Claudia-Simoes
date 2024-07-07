package com.arthursimoes.apirestful.repository;

import com.arthursimoes.apirestful.model.Produto;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoriaId(Long idCategoria);

    Optional<Produto> findById(Long id);

    @Query("select p from Produto p " +
           "left outer join fetch p.categoria " +
           "order by p.id")
    List<Produto> recuperarProdutosComCategoria();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from Produto p where p.id = :id")
    Optional<Produto> recuperarPorIdComLock(Long id);

    @Query(
            value = "select p from Produto p " +
                    "left outer join fetch p.categoria " +
                    "where p.nome like %:nome%",
            countQuery = "select count(p) " +
                    "from Produto p " +
                    "where p.nome like %:nome% "
    )
    Page<Produto> recuperarProdutosComPaginacao(String nome, Pageable pageable);


    @Query("select p from Produto p " +
            "left outer join fetch p.categoria " +
            "where p.id = :id")
    Optional<Produto> recuperarProdutoPorId(Long id);

}
