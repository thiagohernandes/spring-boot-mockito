package com.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
@Entity
@Table(name="tbl_produtos")
public class Produto {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="descricao")
	private String descricao;
	@Column(name="qtd")
	private int qtd;
	@Column(name="valor")
	private Double valor;
	
	public Produto() {
	}
	
	public Produto(Integer id, String descricao, int qtd, Double valor) {
		this.id = id;
		this.descricao = descricao;
		this.qtd = qtd;
		this.valor = valor;
	}
	
	public Produto(String descricao, int qtd, Double valor) {
		this.descricao = descricao;
		this.qtd = qtd;
		this.valor = valor;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
