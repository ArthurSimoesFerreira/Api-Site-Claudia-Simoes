package com.arthursimoes.apirestful;

import com.arthursimoes.apirestful.model.Carrinho;
import com.arthursimoes.apirestful.model.Categoria;
import com.arthursimoes.apirestful.model.Usuario;
import com.arthursimoes.apirestful.repository.CarrinhoRepository;
import com.arthursimoes.apirestful.repository.ProdutoRepository;
import com.arthursimoes.apirestful.model.Produto;
import com.arthursimoes.apirestful.repository.CategoriaRepository;
import com.arthursimoes.apirestful.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class ApiResTfulV1Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CarrinhoRepository carrinhoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiResTfulV1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario usuario = new Usuario("admin", "12345");
		usuarioRepository.save(usuario);

		Categoria camisa = new Categoria("Camisa");
		categoriaRepository.save(camisa);

		Categoria legging = new Categoria("Legging");
		categoriaRepository.save(legging);

		Categoria top = new Categoria("Top");
		categoriaRepository.save(top);

		Produto produto = new Produto(
				"top_branco.png",
				"Top Branco",
				"Top de ginástica branco",
				true,
				100,
				BigDecimal.valueOf(129.99),
				LocalDate.of(2023, 4, 26),
				top);
		produtoRepository.save(produto);

		produto = new Produto(
				"top_cinza.png",
				"Top Cinza",
				"Top de ginástica cinza",
				true,
				500,
				BigDecimal.valueOf(139.99),
				LocalDate.of(2023, 5, 22),
				top);
		produtoRepository.save(produto);

		produto = new Produto(
				"top_preto.png",
				"Top Preto",
				"Top de ginástica preto",
				true,
				400,
				BigDecimal.valueOf(99.99),
				LocalDate.of(2023, 3, 24),
				top);
		produtoRepository.save(produto);

		produto = new Produto(
				"top_rosa.png",
				"Top Rosa",
				"Top de ginástica rosa",
				true,
				120,
				BigDecimal.valueOf(149.99),
				LocalDate.of(2023, 3, 12),
				top);
		produtoRepository.save(produto);

		produto = new Produto(
				"legging_azul.png",
				"Legging Azul",
				"Legging de ginástica azul",
				true,
				340,
				BigDecimal.valueOf(200.00),
				LocalDate.of(2023, 5, 17),
				legging);
		produtoRepository.save(produto);

		produto = new Produto(
				"legging_cinza.png",
				"Legging Cinza",
				"Legging de ginástica cinza",
				true,
				220,
				BigDecimal.valueOf(189.99),
				LocalDate.of(2023, 5, 14),
				legging);
		produtoRepository.save(produto);

		produto = new Produto(
				"legging_preta.png",
				"Legging Preta",
				"Legging de ginástica preta",
				true,
				350,
				BigDecimal.valueOf(139.99),
				LocalDate.of(2023, 2, 22),
				legging);
		produtoRepository.save(produto);

		produto = new Produto(
				"camisa_branca.png",
				"Camisa Branca",
				"Camisa de ginástica branca",
				true,
				720,
				BigDecimal.valueOf(69.90),
				LocalDate.of(2023, 2, 23),
				camisa);
		produtoRepository.save(produto);

		produto = new Produto(
				"camisa_manga.png",
				"Camisa com Manga Comprida",
				"Camisa de manga comprida com tecido respirável",
				true,
				600,
				BigDecimal.valueOf(59.99),
				LocalDate.of(2023, 3, 28),
				camisa);
		produtoRepository.save(produto);
	}
}
