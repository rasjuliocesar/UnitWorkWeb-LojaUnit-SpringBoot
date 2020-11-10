package com.lojaunit.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lojaunit.entities.pk.ItensVendaPK;
import com.sun.istack.NotNull;

@Entity
@Table(name = "itens_venda")
public class ItensVenda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItensVendaPK id = new ItensVendaPK();

	@NotNull
	private Integer quantidade;
	
	@NotNull
	@Column(name = "valor_unitario")
	private Double valorUnitario;
	
	public ItensVenda() {
	}

	public ItensVenda(Venda venda, Produto produto, Integer quantidade, Double valorUnitario) {
		super();
		id.setVenda(venda);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	@JsonIgnore
	public Venda getVendas() {
		return id.getVenda();
	}
	
	public void setVenda(Venda venda) {
		id.setVenda(venda);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setVenda(Produto produto) {
		id.setProduto(produto);
	}
	
	public Double getTotal() {
		return quantidade * valorUnitario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensVenda other = (ItensVenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
