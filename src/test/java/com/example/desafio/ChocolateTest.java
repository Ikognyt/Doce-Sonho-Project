package com.example.desafio;

import com.example.desafio.produto.chocolate.Chocolate;
import com.example.desafio.produto.chocolate.ChocolateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ChocolateTest {

	@Autowired
	private ChocolateService chocolateService;

	/*
	 * Estes testes unitários irão falhar com as alterações do Desafio 2!
	 */

	@Test
	void criacaoChocolate() {
		var chocolate = new Chocolate();

		System.out.println("--Teste Criacao Chocolate--");

		chocolate.setNome("Bombom ao Leite");
		chocolate.setPrecoPorQuilograma(2.99);
		chocolate.setPeso(0.05);

		chocolateService.save(chocolate);

		System.out.println(chocolate.toString());

		assertNotNull(chocolate.getId());
	}

	@Test
	void alteracaoChocolate() {
		var chocolate = new Chocolate();

		System.out.println("--Teste altera��o de Chocolate--");
		chocolate.setNome("Bombom Meio Amargo");
		// chocolate.setPreco(3.49);
		chocolate.setPrecoPorQuilograma(3.49);
		chocolate.setPeso(5.00);

		System.out.println("--Chocolate Antes--");
		System.out.println(chocolate.toString());

		chocolateService.save(chocolate);
		var idOriginal = chocolate.getId();

		// chocolate.setPreco(3.99);
		chocolate.setPrecoPorQuilograma(3.99);
		chocolate.setPeso(3.50);

		System.out.println("--Chocolate Depois--");
		System.out.println(chocolate.toString());

		chocolateService.save(chocolate);

		assertEquals(idOriginal, chocolate.getId());
		// assertEquals(3.99, chocolate.getPreco());
		assertEquals(3.99, chocolate.getPrecoPorQuilograma());

		var list = chocolateService.getAll();

	}

	@Test
	void notasChocolate() {
		System.out.println("--Teste notas Chocolate--");
		// Gera uma lista contendo 20 chocolates
		var chocolates = IntStream.range(0, 20).mapToObj(i -> {
			var chocolate = new Chocolate();
			chocolate.setNome("Chocolate " + i);
			// chocolate.setPreco((i + 1) / 10D);
			chocolate.setPrecoPorQuilograma((i + 1) / 10D);
			chocolate.setPeso((i + 0.01) / 2D);

			// Os últimos chocolates da lista terão as notas mais altas
			
			chocolate.getNota().add((i + 1) / 20D * 10);

			return chocolate;
		}).collect(Collectors.toList());
		
		chocolateService.saveAll(chocolates);

		/*
		 * Este teste unitário pode ser útil para ajudar a resolver o Desafio
		 * 3...
		 */
	}
}
