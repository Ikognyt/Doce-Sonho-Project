package com.example.desafio.produto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.produto.dto.ProdutoDTO;

@Service
@Transactional
public class ProdutoService {

    @Autowired private ProdutoRepository repository;
    
    @PostConstruct
    public void geraProdutos() {
		System.out.println("--Gerando produtos--");
		// Gera uma lista contendo 20 chocolates
		IntStream.range(0, 20).forEach(i -> {
			var produto = new ProdutoPreco();
			produto.setNome("Chocolate " + i);
			produto.setPreco((i + 1) / 10D);
			produto.getNota().add((i + 1) / 20D * 10);
			
			System.out.println("Produto criado:\r\n" + produto.toString());
			
			repository.save(produto);
		});
    }
    
    public List<ProdutoDTO> getListaProdutos() {
    	List<ProdutoDTO> produtoDTO = ProdutoDTO.buildFromList(repository.findAll());
    	
        /*
        As altera√ß√µes do Desafio 3 v√£o aqui...
        Lembre-se que o tipo da lista para retorno n√£o √© Produto, e sim uma classe de DTO que dever√° ser criada!
         */

        return produtoDTO;
    }
    
    public List<ProdutoDTO> getTopProdutos() {
    	List<ProdutoDTO> produtoDTO = ProdutoDTO.buildFromList(repository.findAll());
    	
    	
    	Collections.sort(produtoDTO, Comparator.comparing(ProdutoDTO::getMediaNotas));
    	
        /*
        As alteraÁıes do Desafio 3 v„o aqui...
        Lembre-se que o tipo da lista para retorno n„o È Produto, e sim uma classe de DTO que dever· ser criada!
         */

    	produtoDTO.forEach(produto -> { System.out.println(produto);});
    	
        return produtoDTO;
    }
    
    
}
