package com.simulador.comprador;

import java.sql.Date;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.simulador.comprador.model.Comprador;
import com.simulador.comprador.repository.CompradorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompradorApplicationTests {

	@Autowired
	private CompradorRepository compradorDAO;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createSholdPersistData() {
		//String name, double volume, double saldo, Long acoes
		Comprador comprador = new Comprador("Mifael", 20.30, 1000,2L);
		this.compradorDAO.save(comprador);
		Assertions.assertThat(comprador.getId()).isNotNull();
		Assertions.assertThat(comprador.getName()).isEqualTo("Mifael");
		Assertions.assertThat(comprador.getVolume()).isEqualTo(20.30);
		Assertions.assertThat(comprador.getSaldo()).isEqualTo(1000);
		Assertions.assertThat(comprador.getAcoes()).isEqualTo(2L);
	}

	@Test
	public void deleteSholdRemoveData() {
		Comprador comprador = new Comprador("Mifael", 20.30, 1000,2L);
		this.compradorDAO.save(comprador);
		this.compradorDAO.delete(comprador);
		Assertions.assertThat(this.compradorDAO.findOne(comprador.getId())).isNull();
	}
	
	@Test
	public void updateSholdChangeAndPersistData() {

		Comprador comprador = new Comprador("Mifael", 20.30, 1000,2L);		
		Comprador comprador1 = new Comprador("Mifael Moraes", 20.30, 1000,2L);
		this.compradorDAO.save(comprador);
		comprador.setName(comprador1.getName());
		this.compradorDAO.save(comprador);
		Assertions.assertThat(comprador.getId()).isNotNull();
		Assertions.assertThat(comprador.getName()).isEqualTo("Mifael Moraes");
		Assertions.assertThat(comprador.getVolume()).isEqualTo(20.30);
		Assertions.assertThat(comprador.getSaldo()).isEqualTo(1000);
		Assertions.assertThat(comprador.getAcoes()).isEqualTo(2L);
	}

}
