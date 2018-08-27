package com.simulador.autobooking.repository;


import org.springframework.data.repository.CrudRepository;

import com.simulador.autobooking.model.LogNegociacao;

public interface AutobookingRepository extends CrudRepository<LogNegociacao, Long> {

}
