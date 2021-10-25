package com.example.desafio.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "produto_preco")
public class ProdutoPreco extends Produto {

    @Column(name = "preco", nullable = false)
    private Double preco;

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "ProdutoPreco ["
				+ "\r\npreco=" + preco 
				+ "\r\ngetPreco()=" + getPreco() 
				+ "\r\ngetId()=" + getId() 
				+ "\r\ngetNome()=" + getNome() 
				+ "\r\ngetNota()=" + getNota() 
				+ "\r\ngetClass()=" + getClass() 
				+ "\r\nhashCode()=" + hashCode()
				+ "]";
	}
	
	
	
}
