package com.simulador.mercado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.simulador.mercado.model.SimuladorPreco;


@SpringBootApplication
public class MercadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadoApplication.class, args);
		
			SimuladorPreco simuladorPreco = new SimuladorPreco();
			simuladorPreco.getAcoes();
		
	}
}
