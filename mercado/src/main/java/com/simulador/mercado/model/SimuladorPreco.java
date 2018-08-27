package com.simulador.mercado.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.simulador.mercado.model.Acao;



public class SimuladorPreco extends Thread {

	List<Acao> listaAcoes = new ArrayList<Acao>();

	boolean t = true;

	private RestTemplate acoesTemplate = new RestTemplateBuilder().rootUri("http://localhost:8088/acoes").build();

	

	public SimuladorPreco() {

	}

	public void getAcoes() {
		ResponseEntity<List<Acao>> listAcoes = acoesTemplate.exchange("/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Acao>>() {
				});

		if (listAcoes.hasBody()) {
			while (t) {
				try {
					for (int i = 0; i < listAcoes.getBody().size(); i++) {
						if (listAcoes.getBody().get(i).isIniciar()) {
							run(listAcoes.getBody().get(i));
						}
					}
					sleep(5000);
				} catch (Exception e) {
					e.getStackTrace();
				}
				listAcoes = acoesTemplate.exchange("/", HttpMethod.GET, null,
						new ParameterizedTypeReference<List<Acao>>() {
						});
			}
		}
	}

		public ResponseEntity<?> run(Acao acao) {
		Acao acaoNovoPreco = variaValor(acao);
		return new ResponseEntity<>(acoesTemplate.exchange("/", HttpMethod.PUT,
				new HttpEntity<>(acaoNovoPreco, creatJsonHeader()), Acao.class), HttpStatus.OK);
	}

	public Acao variaValor(Acao acao) {
		double PMin = acao.getPrecoCompra() - (acao.getPrecoCompra() * 0.1);
		double PMax = acao.getPrecoVenda() + (acao.getPrecoVenda() * 0.1);
		acao.setValor((Math.floor(ThreadLocalRandom.current().nextDouble(PMin, PMax) * 100)) / 100);
		return acao;
	}
	

	private static HttpHeaders creatJsonHeader() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		return header;
	}

	public boolean isT() {
		return t;
	}

	public void setT(boolean t) {
		this.t = t;
	}

}
