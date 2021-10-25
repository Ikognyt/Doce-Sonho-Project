package com.example.desafio.produto.presente;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PresenteServiceTest {

	@Autowired private PresenteService presenteService;
	
	@Test
	void createPresenteShouldBeNotNullTest() {
		
    	Presente presente = new Presente();
    	
    	presente.setNome("Balas pct 1 un 10g - Doce Sonho");
    	presente.setPreco(2.50);
		
		Presente novoPresente = presenteService.createPresente(null);
		
		System.out.println("Testando criação de presente");
		assertThat(novoPresente).isNotNull();
		
	}
	
	
	@Test
	void updatePresenteShouldNotContainsEmptyElements() {
		
    	Presente presente = new Presente();
    	
    	presente.setNome("Teste");
    	presente.setPreco(0.01);
		
    	Presente presenteOld = presenteService.updatePresente(presente, 2L);
    	
    	System.out.println("Testando nome de presente");
    	assertThat(presenteOld.getNome()).isNotEmpty();
    	assertThat(presenteOld.getNome()).isNotBlank();
    	assertThat(presenteOld.getNome()).hasSizeGreaterThan(3);
    	
    	System.out.println("Testando preço de presente");
    	assertThat(presenteOld.getPreco()).isGreaterThan(0.00);
    	assertThat(presenteOld.getPreco()).isNotZero();
    	assertThat(presenteOld.getPreco()).isNotNaN();
		
	}
	
	@Test
	void listaPresentesShouldNotReturnNullOrEmpty() {
		
		List<Presente> listaPresentes = presenteService.listaPresentes();
		
		System.out.println("Testando lista de Presentes");
		assertThat(listaPresentes).isNotNull();
		assertThat(listaPresentes).isNotEmpty();
		
	}
	
	
	@Test
	void getByIdShouldBeNullIfNotExist() {
		
		Presente presenteTest = presenteService.getById(5L);
		
		System.out.println("Testando busca de Presentes por ID");
		
		assertThat(presenteTest).isNull();
		
	}
	
	@Test
	void deleteByIdShouldDeleteElementPermanently() {
		System.out.println("Testando remoção de Presentes por ID");
		
		System.out.println("--Lista Presentes antes da remoção--");
		presenteService.listaPresentes().forEach(presente -> {
			System.out.println("Id: " + presente.getId());
			System.out.println("Nome: " + presente.getNome());
			System.out.println("Preco: " + presente.getPreco());
		});
		
		presenteService.deleteById(1L);
		
		assertThat(presenteService.getById(1L)).isNotIn(presenteService.listaPresentes());
		
		System.out.println("--Lista Presentes depois da remoção--");
		presenteService.listaPresentes().forEach(presente -> {
			System.out.println("Id: " + presente.getId());
			System.out.println("Nome: " + presente.getNome());
			System.out.println("Preco: " + presente.getPreco());
		});
		
	}

}
