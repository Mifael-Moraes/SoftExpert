package com.simulador.acoes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.simulador.acoes.model.Acao;

public interface AcoesRepository extends CrudRepository<Acao, Long>{
	
	List<Acao> findByName(String name);

}
