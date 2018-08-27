package com.simulador.autobooking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.simulador.autobooking.model.AbstractEntity;


@Entity
public class LogNegociacao extends AbstractEntity{
	
	//[YZK] Compra: 10.15, Volume: 10000, Saldo: 0.00
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataHora;
	@NotBlank
	private String nomeAcao;
	@NotBlank
	private String operacao;
	@NotNull
	private double valorOperacao;
	@NotNull
	private double volumeAcoes;
	@NotNull
	private double saldo;
	
	
	
	public LogNegociacao(Date dataHora, String nomeAcao, String operacao, double valorOperacao, double volumeAcoes,
			double saldo) {
		super();
		this.dataHora = dataHora;
		this.nomeAcao = nomeAcao;
		this.operacao = operacao;
		this.valorOperacao = valorOperacao;
		this.volumeAcoes = volumeAcoes;
		this.saldo = saldo;
	}
	
	public LogNegociacao() {
		super();
	}



	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getNomeAcao() {
		return nomeAcao;
	}
	public void setNomeAcao(String nomeAcao) {
		this.nomeAcao = nomeAcao;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public double getValorOperacao() {
		return valorOperacao;
	}
	public void setValorOperacao(double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}
	public double getVolumeAcoes() {
		return volumeAcoes;
	}
	public void setVolumeAcoes(double volumeAcoes) {
		this.volumeAcoes = volumeAcoes;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "#"+ dataHora +": [" + nomeAcao + "] " + operacao + ": "
				+ valorOperacao + ", Volume: " + volumeAcoes + ", Saldo: " + saldo;
	}
	
	

}
