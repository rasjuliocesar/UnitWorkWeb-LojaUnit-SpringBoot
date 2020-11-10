package com.lojaunit.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Produto implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	private String descricao;
	
	@Column(name = "preco_unitario")
	private Double precoUnitario;
	
	private String unidade;
	
	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;
	
	@ManyToOne
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@JsonIgnore
	@OneToMany(mappedBy = "produto")
	private List<Faq> faqs = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private Set<ItensVenda> itens = new HashSet<>();
	
	public Produto() {
	}

	public Produto(Long id, String nome, String descricao, Double precoUnitario, String unidade, Marca marca, Fornecedor fornecedor, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.unidade = unidade;
		this.marca = marca;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public Marca getMarca() {
		return marca;
	}
	
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public Fornecedor getFornecedores() {
		return fornecedor;
	}
	
	public void setFornecedores(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public Categoria getCategorias() {
		return categoria;
	}

	public void setCategorias(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Faq> getFaqs(){
		return faqs;
	}
	
	@JsonIgnore
	public Set<Venda> getVendas(){
		Set<Venda> set = new HashSet<>();
		for(ItensVenda item : itens) {
			set.add(item.getVendas());
		}
		return set;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
