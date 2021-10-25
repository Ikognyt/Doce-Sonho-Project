package com.example.desafio.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.produto.dto.ProdutoDTO;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired private ProdutoService produtoService;
	
	
	@GetMapping({"", "/"})
	List<ProdutoDTO> getAll() {
		return produtoService.getTopProdutos(); 
	}
	
}
