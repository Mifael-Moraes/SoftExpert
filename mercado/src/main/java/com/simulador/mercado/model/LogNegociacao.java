package com.simulador.mercado.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;



public class LogNegociacao {
	

	@JsonProperty("id")
	private Long id;
	@JsonProperty("dataHora")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataHora;
	@JsonProperty("nomeAcao")
	private String nomeAcao;
	@JsonProperty("operacao")
	private String operacao;
	@JsonProperty("valorOperacao")
	private double valorOperacao;
	@JsonProperty("volumeAcoes")
	private double volumeAcoes;
	@JsonProperty("saldo")
	private double saldo;
	
	
	
	public LogNegociacao() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
