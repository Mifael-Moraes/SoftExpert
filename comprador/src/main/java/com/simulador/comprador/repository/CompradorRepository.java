package com.simulador.comprador.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.simulador.comprador.model.Comprador;

public interface CompradorRepository extends CrudRepository<Comprador, Long> {
	
	List<Comprador> findByName(String name);
}
