package com.example.desafio.produto.chocolate;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.desafio.produto.ProdutoGranel;

@Entity
@Table(name = "chocolate")
public class Chocolate extends ProdutoGranel {

	@Override
	public String toString() {
		return "Chocolate ["
		+ "\r\ngetPeso()=" + getPeso()
		+ "\r\ngetId()=" + getId()
		+ "\r\ngetNome()=" + getNome()
		+ "\r\ngetNota()=" + getNota()
		+ "\r\ngetPrecoPorQuilograma()=" + getPrecoPorQuilograma() 
		+ "]";
	}




	
	
	
	
	
}
