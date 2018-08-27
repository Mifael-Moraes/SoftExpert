package com.simulador.autobooking.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.simulador.autobooking.repository.AutobookingRepository;
import com.simulador.autobooking.model.Acao;
import com.simulador.autobooking.model.Comprador;

@RestController
@RequestMapping("autobooking")
public class BookingAutomato {
	List<Acao> listaAcoes = new ArrayList<Acao>();

	boolean t = true;

	
	private final AutobookingRepository autobookingDAO;
	
	private RestTemplate acoesTemplate = new RestTemplateBuilder().rootUri("http://localhost:8088/acoes").build();
	private RestTemplate compradorTemplate = new RestTemplateBuilder().rootUri("http://localhost:8889/compradores").build();
	
	@Autowired
	public BookingAutomato(AutobookingRepository autobookingDAO) {
		this.autobookingDAO = autobookingDAO;
	}

	@GetMapping
	public ResponseEntity<?> buyOrSellAcoes() {
		ResponseEntity<List<Acao>> listAcoes = acoesTemplate.exchange("/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Acao>>() {
				});
		while (t) {
			try {
				for (int i = 0; i < listAcoes.getBody().size(); i++) {
					if (listAcoes.getBody().get(i).isIniciar()) {
						Comprador comprador = compradorTemplate.exchange("/{id}", HttpMethod.GET, null, Comprador.class,
									listAcoes.getBody().get(i).getIdComprador()).getBody();
						compraVende(listAcoes.getBody().get(i), comprador);
					}
				}
			} catch (Exception e) {
				e.getStackTrace();
			}
			listAcoes = acoesTemplate.exchange("/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Acao>>() {
			});
		}
		return new ResponseEntity<>(HttpStatus.GONE);
	}

	public LogNegociacao compraVende(Acao acao1, Comprador comprador1) {
		LogNegociacao log = new LogNegociacao();
		if (acao1.getIdComprador() != null) {
			if (acao1.getValor() >= acao1.getPrecoVenda() && comprador1.getVolume() > 0  ) {
				double novoSaldo = ((Math.floor(acao1.getValor() * comprador1.getVolume())* 100) / 100);
				comprador1.setSaldo(novoSaldo);
				comprador1.setVolume((double) 0);
				log.setDataHora(new Date(System.currentTimeMillis()));
				log.setNomeAcao(acao1.getName());
				log.setOperacao("VENDA");
				log.setValorOperacao(acao1.getValor());
				log.setVolumeAcoes((double) 0);
				log.setSaldo(novoSaldo);
				System.out.println(log);
				ResponseEntity<Comprador> responseEntityComprador = compradorTemplate.exchange("/", HttpMethod.PUT,new HttpEntity<>(comprador1, creatJsonHeader()), Comprador.class);
				autobookingDAO.save(log);
				return log;
				

			}else if (acao1.getValor() <= acao1.getPrecoCompra() && comprador1.getSaldo() > 0) {
				double novoVolume = (Math.floor((comprador1.getSaldo() / acao1.getValor()) * 100)/ 100);
				comprador1.setVolume(novoVolume);
				comprador1.setSaldo((double) 0);
				log.setDataHora(new Date(System.currentTimeMillis()));
				log.setNomeAcao(acao1.getName());
				log.setOperacao("COMPRA");
				log.setValorOperacao(acao1.getValor());
				log.setVolumeAcoes(novoVolume);
				log.setSaldo((double) 0);
				System.out.println(log);
				ResponseEntity<Comprador> responseEntityComprador = compradorTemplate.exchange("/", HttpMethod.PUT,new HttpEntity<>(comprador1, creatJsonHeader()), Comprador.class);
				autobookingDAO.save(log);
				return log;
			}
		}
		return log;
	}
	
	private static HttpHeaders creatJsonHeader() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		return header;
	}
}
