package com.example.desafio.produto.presente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.desafio.produto.Produto;
import com.example.desafio.produto.ProdutoPreco;

@Entity
@Table(name = "presente_item")
public class ItemPresente {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "presente_id", nullable = false, foreignKey = @ForeignKey(name = "presente_item_presente_fk"))
    private Presente presente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_preco_id", nullable = false, foreignKey = @ForeignKey(name = "presente_item_produto_preco_fk"))
    private ProdutoPreco produtoPreco;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Presente getPresente() {
        return presente;
    }

    public void setPresente(Presente presente) {
        this.presente = presente;
    }

    public Produto getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(ProdutoPreco produto) {
        this.produtoPreco = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
