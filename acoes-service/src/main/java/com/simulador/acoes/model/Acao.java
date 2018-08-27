package com.simulador.acoes.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Acao extends AbstractEntity{
	
	@NotBlank	
	private String name;
	
	private Long idComprador;
			
	private boolean iniciar;
	
	@NotNull
	@JsonFormat (shape=JsonFormat.Shape.STRING)
	private double valor;

	@NotNull
	@JsonFormat (shape=JsonFormat.Shape.STRING)
	private double precoVenda;
	
	@NotNull
	@JsonFormat (shape=JsonFormat.Shape.STRING)
	private double precoCompra;
	
	public Acao() {
		
	}
	
	public Acao(String name, Long idComprador, boolean iniciar, double valor, double precoVenda, double precoCompra) {
		super();
		this.name = name;
		this.idComprador = idComprador;
		this.iniciar = iniciar;
		this.valor = valor;
		this.precoVenda = precoVenda;
		this.precoCompra = precoCompra;
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
		return "Nome: " + name + ", Comprador: " + idComprador +  ", Iniciar: " + iniciar + ", Valor: " + valor + ", Preco Venda: " + precoVenda
				+ ", Preco Compra: " + precoCompra + "\n";
	}

	
}
