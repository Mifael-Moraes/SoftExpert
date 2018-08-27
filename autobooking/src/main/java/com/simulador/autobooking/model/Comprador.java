package com.simulador.autobooking.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comprador {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("volume")
	private double volume;
	
	@JsonProperty("saldo")
	private double saldo;
	
	@JsonProperty("acoes")
	private Long acoes;

	public Comprador() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Long getAcoes() {
		return acoes;
	}

	public void setAcoes(Long acoes) {
		this.acoes = acoes;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", Nome: " + name + ", Volume: " + volume + ", Saldo: " + saldo + ", Acoes: " + acoes
				+ "\n";
	}
	
	
	
}
