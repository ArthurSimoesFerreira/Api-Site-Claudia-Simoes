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


	public static void main(String[] args) {
		SpringApplication.run(ApiResTfulV1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario usuario = new Usuario("admin", "12345");
		usuarioRepository.save(usuario);

		Categoria camisa = new Categoria("Camisa", "camisa");
		categoriaRepository.save(camisa);

		Categoria legging = new Categoria("Legging", "legging");
		categoriaRepository.save(legging);

		Categoria top = new Categoria("Top", "top");
		categoriaRepository.save(top);

		Produto produto = new Produto(
				"camisa_azul.png",
				"Camisa Azul",
				"Camisa Dry Fit Azul com tecido respirável",
				true,
				10,
				BigDecimal.valueOf(129.99),
				LocalDate.of(2023, 4, 26),
				camisa);
		produtoRepository.save(produto);

		produto = new Produto(
				"legging_branca.png",
				"Legging Branca",
				"Legging branca com tecido respirável e alongável para a prática de exercícios físicos",
				true,
				8,
				BigDecimal.valueOf(139.99),
				LocalDate.of(2023, 5, 22),
				legging);
		produtoRepository.save(produto);

		produto = new Produto(
				"top_preto.png",
				"Top Preto",
				"Top de ginástica preto para academia",
				true,
				5,
				BigDecimal.valueOf(139.99),
				LocalDate.of(2023, 3, 24),
				top);
		produtoRepository.save(produto);

		produto = new Produto(
				"top_rosa.png",
				"Top Rosa",
				"Top de ginástica rosa super confortável e com tecido respirável",
				true,
				6,
				BigDecimal.valueOf(139.99),
				LocalDate.of(2023, 3, 12),
				top);
		produtoRepository.save(produto);

		produto = new Produto(
				"legging_azul.png",
				"Legging Azul",
				"Legging de ginástica azul com detalhes desenhados extremamente confortável",
				true,
				3,
				BigDecimal.valueOf(199.99),
				LocalDate.of(2023, 5, 17),
				legging);
		produtoRepository.save(produto);

		produto = new Produto(
				"camisa_branca.png",
				"Camisa Branca",
				"Camisa de ginástica branca com mangas curtas e com tecido que não amarrota",
				true,
				12,
				BigDecimal.valueOf(189.99),
				LocalDate.of(2023, 5, 14),
				camisa);
		produtoRepository.save(produto);

		produto = new Produto(
				"legging_roxa.png",
				"Legging roxa",
				"Legging de ginástica roxa com tecido alongável feita para esportes como corrida e academia",
				true,
				4,
				BigDecimal.valueOf(139.99),
				LocalDate.of(2023, 2, 22),
				legging);
		produtoRepository.save(produto);

		produto = new Produto(
				"top_verde.png",
				"Top Verde",
				"Top de academia verde atravessado na frente e super confortável e preso",
				true,
				8,
				BigDecimal.valueOf(119.99),
				LocalDate.of(2023, 2, 23),
				top);
		produtoRepository.save(produto);

		produto = new Produto(
				"top_onca.png",
				"Top Onça",
				"Top onça edição exclusiva, confortável, alongável, e super respirável. Além de bem ajustado e seguro.",
				true,
				10,
				BigDecimal.valueOf(259.99),
				LocalDate.of(2023, 3, 28),
				top);
		produtoRepository.save(produto);

		produto = new Produto(
				"camisa_verde.png",
				"Camisa Verde",
				"Camisa Verde para ginástica intensa",
				true,
				11,
				BigDecimal.valueOf(159.99),
				LocalDate.of(2023, 3, 28),
				camisa);
		produtoRepository.save(produto);

		produto = new Produto(
				"legging_rosa.png",
				"Legging Rosa",
				"Legging para ginástica rosa estilosa e confortável",
				true,
				6,
				BigDecimal.valueOf(179.99),
				LocalDate.of(2023, 3, 28),
				legging);
		produtoRepository.save(produto);

		produto = new Produto(
				"camisa_preta.png",
				"Camisa Preta",
				"Camisa Preta para ginástica variada, confortável e respirável",
				true,
				15,
				BigDecimal.valueOf(109.99),
				LocalDate.of(2023, 3, 28),
				camisa);
		produtoRepository.save(produto);

		produto = new Produto(
				"top_azul.png",
				"Top Azul",
				"Top Azul especial para corrida, bem ajustado, respirável e com suporte para garrafinha.",
				true,
				5,
				BigDecimal.valueOf(249.99),
				LocalDate.of(2023, 3, 28),
				top);
		produtoRepository.save(produto);

		produto = new Produto(
				"legging_cinza.png",
				"Legging Cinza",
				"Legging Cinza para ginástica, especialmente academia e crossfit.",
				true,
				16,
				BigDecimal.valueOf(189.99),
				LocalDate.of(2024, 3, 21),
				legging);
		produtoRepository.save(produto);

		produto = new Produto(
				"camisa_marrom.png",
				"Camisa Marrom",
				"Camisa Marrom para ginástica variada, com tecido leve e confortável",
				true,
				13,
				BigDecimal.valueOf(119.99),
				LocalDate.of(2023, 6, 21),
				camisa);
		produtoRepository.save(produto);

		produto = new Produto(
				"top_verde_claro.png",
				"Top Verde Claro",
				"Top Verde Claro com suporte para celular nas costas",
				true,
				3,
				BigDecimal.valueOf(119.99),
				LocalDate.of(2024, 2, 11),
				top);
		produtoRepository.save(produto);

		produto = new Produto(
				"camisa_rosa.png",
				"Camisa Rosa",
				"Camisa Rosa de ginástica super confortável e com tecido leve",
				true,
				6,
				BigDecimal.valueOf(109.99),
				LocalDate.of(2023, 1, 11),
				camisa);
		produtoRepository.save(produto);

		produto = new Produto(
				"camisa_roxa.png",
				"Camisa Roxa",
				"Camisa Rosa de ginástica leve com tecido com proteção UV",
				true,
				9,
				BigDecimal.valueOf(179.99),
				LocalDate.of(2023, 1, 16),
				camisa);
		produtoRepository.save(produto);

		produto = new Produto(
				"legging_preta.png",
				"Legging Preta",
				"Legging Preta de ginástica com tecido alongável e bolsos laterais",
				true,
				9,
				BigDecimal.valueOf(139.99),
				LocalDate.of(2024, 9, 9),
				legging);
		produtoRepository.save(produto);

		produto = new Produto(
				"top_branco.png",
				"Top Branco",
				"Top Branco bem ajustado, super confortável, e feito para ginástica",
				true,
				12,
				BigDecimal.valueOf(129.99),
				LocalDate.of(2024, 9, 14),
				top);
		produtoRepository.save(produto);
	}
}
