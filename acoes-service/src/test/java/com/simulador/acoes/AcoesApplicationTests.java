package com.simulador.acoes;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.simulador.acoes.model.Acao;
import com.simulador.acoes.repository.AcoesRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcoesApplicationTests {

	@Autowired
	private AcoesRepository acoesDAO;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createSholdPersistData() {
		Acao acao = new Acao("RENNER S/A",1L,true,33.03,29.00,36.30);
		this.acoesDAO.save(acao);
		Assertions.assertThat(acao.getId()).isNotNull();
		Assertions.assertThat(acao.getName()).isEqualTo("RENNER S/A");
		Assertions.assertThat(acao.isIniciar()).isEqualTo(true);
		Assertions.assertThat(acao.getValor()).isEqualTo(33.03);
		Assertions.assertThat(acao.getPrecoVenda()).isEqualTo(29.00);
		Assertions.assertThat(acao.getPrecoCompra()).isEqualTo(36.30);
	}

	@Test
	public void deleteSholdRemoveData() {
		Acao acao = new Acao("RENNER S/A",1L,true,33.03,29.00,36.30);
		this.acoesDAO.save(acao);
		this.acoesDAO.delete(acao);
		Assertions.assertThat(this.acoesDAO.findOne(acao.getId())).isNull();
	}
	
	@Test
	public void updateSholdChangeAndPersistData() {
		//String name, Long idComprador, boolean iniciar, double valor, double precoVenda, double precoCompra
		Acao acao = new Acao("RENNER S/A",2L,true,33.03,29.00,36.30);
		Acao acao2 = new Acao("RENNER-Camicado S/A",1L,true,33.03,29.00,36.30);
		this.acoesDAO.save(acao);
		acao.setIdComprador(acao2.getIdComprador());
		acao.setName(acao2.getName());
		this.acoesDAO.save(acao);
		Assertions.assertThat(acao.getId()).isNotNull();
		Assertions.assertThat(acao.getName()).isEqualTo("RENNER-Camicado S/A");
		Assertions.assertThat(acao.getIdComprador()).isEqualTo(1L);
		Assertions.assertThat(acao.isIniciar()).isEqualTo(true);
		Assertions.assertThat(acao.getValor()).isEqualTo(33.03);
		Assertions.assertThat(acao.getPrecoVenda()).isEqualTo(29.00);
		Assertions.assertThat(acao.getPrecoCompra()).isEqualTo(36.30);
	}
	
	

}
