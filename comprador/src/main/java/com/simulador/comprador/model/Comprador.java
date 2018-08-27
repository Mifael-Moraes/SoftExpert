package com.simulador.comprador.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simulador.comprador.model.AbstractEntity;

@Entity
public class Comprador extends AbstractEntity{
	
	@NotBlank
	private String name;
	
	@NotNull
	@JsonFormat (shape=JsonFormat.Shape.STRING)
	private double volume;
	
	@NotNull
	@JsonFormat (shape=JsonFormat.Shape.STRING)
	private double saldo;
	
	
	private Long acoes;

	public Comprador() {
	}
	
	

	public Comprador(String name, double volume, double saldo, Long acoes) {
		super();
		this.name = name;
		this.volume = volume;
		this.saldo = saldo;
		this.acoes = acoes;
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
		return "Nome: " + name + ", Volume: " + volume + ", Saldo: " + saldo + ", Acoes: " + acoes
				+ "\n";
	}
	
	
	
}
