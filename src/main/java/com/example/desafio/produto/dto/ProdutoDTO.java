package com.example.desafio.produto.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;

import com.example.desafio.produto.Produto;

public class ProdutoDTO{

	private String nome;
	private Double mediaNotas;

	public ProdutoDTO(Produto produto) {
		this.nome = produto.getNome();

		OptionalDouble optDouble = produto.getNota().stream().mapToDouble(nota -> nota).average();

		this.mediaNotas = optDouble.getAsDouble();

	}

	public static List<ProdutoDTO> buildFromList(Iterable<Produto> listaProduto) {

		ArrayList<ProdutoDTO> listDTO = new ArrayList<>();

		Iterator<Produto> iteratorProduto = listaProduto.iterator();

		while (iteratorProduto.hasNext()) {
			listDTO.add(new ProdutoDTO(iteratorProduto.next()));
		}

		return listDTO;
	}

	public String getNome() {
		return nome;
	}

	public Double getMediaNotas() {
		return mediaNotas;
	}

}
