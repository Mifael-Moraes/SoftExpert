package com.simulador.autobooking.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Acao {
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("idComprador")
	private Long idComprador;

	@JsonProperty("iniciar")
	private boolean iniciar;
	
	@JsonProperty("valor")
	private double valor;
	
	@JsonProperty("precoVenda")
	private double precoVenda;

	@JsonProperty("precoCompra")
	private double precoCompra;

	public Acao() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdComprador() {
		return idComprador;
	}

	public void setIdComprador(Long idComprador) {
		this.idComprador = idComprador;
	}

	public boolean isIniciar() {
		return iniciar;
	}

	public void setIniciar(boolean iniciar) {
		this.iniciar = iniciar;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}

	@Override
	public String toString() {
		return "Nome: " + name + ", Comprador Numero: " + idComprador + ", Iniciar: " + iniciar + ", Valor: " + valor + ", Preco Venda: " + precoVenda
				+ ", Preco Compra: " + precoCompra + "\n";
	}

}
