package com.simulador.comprador.resource;

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

import com.simulador.comprador.error.CustomErrorType;
import com.simulador.comprador.model.Comprador;
import com.simulador.comprador.repository.CompradorRepository;


@RestController
@RequestMapping(path = "compradores")
public class CompradorResource {
	
	
	private final CompradorRepository compradorDAO;
	
	@Autowired
	public CompradorResource(CompradorRepository compradorDAO) {
		this.compradorDAO = compradorDAO;
	}
		
	@GetMapping
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(compradorDAO.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path= "/{id}")
	public ResponseEntity<?> getCompradorById(@PathVariable(name= "id") Long id){
		Comprador comprador = compradorDAO.findOne(id);
		if(comprador == null)
			return new ResponseEntity<>(new CustomErrorType("Comprador não Encontrado"), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(comprador, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Comprador comprador){
		return new ResponseEntity<>(compradorDAO.save(comprador), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Comprador comprador){
		return new ResponseEntity<>(compradorDAO.save(comprador),HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody Comprador comprador){
		compradorDAO.delete(comprador);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
