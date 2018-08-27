package com.simulador.acoes.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simulador.acoes.error.CustomErrorType;
import com.simulador.acoes.model.Acao;
import com.simulador.acoes.repository.AcoesRepository;


@RestController
@RequestMapping("acoes")
public class AcoesResource {
	
	
	private final AcoesRepository acoesDao;
	
	@Autowired
	public AcoesResource(AcoesRepository acoesDao) {
		this.acoesDao = acoesDao;
	}
	
	@GetMapping()
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(acoesDao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getAcoesById(@PathVariable(name= "id") Long id){
		Acao acao = acoesDao.findOne(id);
		if(acao == null)
			return new ResponseEntity<>(new CustomErrorType("Ação não Encontradas"), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(acao, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Acao acao){
		return new ResponseEntity<>(acoesDao.save(acao),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Acao acao){
		acoesDao.save(acao);
		return  new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(path= "/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id")Long id){
	acoesDao.delete(id);	
	return new ResponseEntity<>(HttpStatus.OK);
	}
}
