package com.simulador.autobooking;

import java.sql.Date;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.simulador.autobooking.model.LogNegociacao;
import com.simulador.autobooking.repository.AutobookingRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AutobookingApplicationTests {

	@Autowired
	private AutobookingRepository bookingDAO;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createSholdPersistData() {
		LogNegociacao log = new LogNegociacao(new Date(System.currentTimeMillis()), "RENNER S/A", "VENDA",33.03, 1000, 0);
		this.bookingDAO.save(log);
		Assertions.assertThat(log.getId()).isNotNull();
		Assertions.assertThat(log.getNomeAcao()).isEqualTo("RENNER S/A");
		Assertions.assertThat(log.getValorOperacao()).isEqualTo(33.03);
		Assertions.assertThat(log.getVolumeAcoes()).isEqualTo(1000);
		Assertions.assertThat(log.getSaldo()).isEqualTo(0);
	}

	@Test
	public void deleteSholdRemoveData() {
		LogNegociacao log = new LogNegociacao(new Date(System.currentTimeMillis()), "RENNER S/A", "VENDA",33.03, 1000, 0);
		this.bookingDAO.save(log);
		this.bookingDAO.delete(log);
		Assertions.assertThat(this.bookingDAO.findOne(log.getId())).isNull();
	}
	
	@Test
	public void updateSholdChangeAndPersistData() {

		LogNegociacao log = new LogNegociacao(new Date(System.currentTimeMillis()), "RENNER S/A", "VENDA",33.03, 1000, 0);
		LogNegociacao log1 = new LogNegociacao(new Date(System.currentTimeMillis()), "RENNER - Camicado S/A", "VENDA",33.03, 1000, 0);
		this.bookingDAO.save(log);
		log.setNomeAcao(log1.getNomeAcao());
		this.bookingDAO.save(log);
		Assertions.assertThat(log.getId()).isNotNull();
		Assertions.assertThat(log.getNomeAcao()).isEqualTo("RENNER - Camicado S/A");
		Assertions.assertThat(log.getValorOperacao()).isEqualTo(33.03);
		Assertions.assertThat(log.getVolumeAcoes()).isEqualTo(1000);
		Assertions.assertThat(log.getSaldo()).isEqualTo(0);
	}

}
