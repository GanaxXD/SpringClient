package com.example.demo.controllerCliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.ClientsInterface;
import com.example.demo.models.Clients;
import com.example.demo.services.CadastroClienteService;

@RestController
@RequestMapping("/clientes")
public class ClientController {
	
	@Autowired
	private ClientsInterface clientInterface;
	
	@Autowired
	private CadastroClienteService clienteService;
	
	@GetMapping()
	public List<Clients> listar() {
		return clientInterface.findAll();
		//return clientInterface.findAllByNome("Bruce Wayne");
	}
	
	@GetMapping("/{clientsId}")
	public ResponseEntity<Clients> buscar(@PathVariable Long clientsId) {
		//Optional pq o findById retorna um Optional, ou seja, um container contendo ou não objetos
		Optional<Clients> cliente = clientInterface.findById(clientsId);
		
		//O código de resposta da requisão não pode ser 200 caso seja nulo o cliente, logo...
		if(cliente.isPresent()) {
			//retorna o código 200 pra requisição
			return ResponseEntity.ok(cliente.get());
		}
		
		return ResponseEntity.notFound().build(); //build ao fim para construir o response entity do tipo informado na assinatura.
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Clients criar(@Valid @RequestBody Clients cliente) {
		return clienteService.salvar(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Clients> atualizar (@Valid @RequestBody Clients cliente, @PathVariable Long clienteId) {
		if(!clientInterface.existsById(clienteId)) {
			ResponseEntity.notFound().build();
		}
				
		cliente.setId(clienteId);
		return ResponseEntity.ok(clientInterface.save(cliente));
	}
	
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> deletar (@PathVariable Long clientId){
		if(!clientInterface.existsById(clientId)) {
			ResponseEntity.notFound().build();
		}
		//clientInterface.deletar(clientInterface.findById(clientId).get());
		clienteService.deletar(clientId);
		return ResponseEntity.noContent().build();
	}
	
}
