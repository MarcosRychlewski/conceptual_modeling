package com.rychlewski.cursomc.resource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rychlewski.cursomc.domain.Cliente;
import com.rychlewski.cursomc.services.ClienteService;


//RestController anotaçao de controlador do app
//RequestMapping nome do end point rest

// @PathVariable == para conectar o id do RequestMapping com o id do parametro do metodo find

// ResponseEntity<?> == tipo especial do spring que encapsula varias informaçoes de uma resposta http para um serviço rest (?==idica qualquer tipo)

// ResponseEntity.ok().body(obj) == resposta indicando que esta ok e envio no corpo da resposta o obj



@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable  Integer id) {
		
		Cliente obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	
	
}
