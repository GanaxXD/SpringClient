package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.handlerexception.NegocioException;
import com.example.demo.interfaces.ClientsInterface;
import com.example.demo.models.Clients;

/*
 * Service:
 * Coloque aqui as regras de negócio da API,
 * ou funções mais específicas que não existem
 * na interface ClientsInterface, como por
 * exemplo, a manipulação e conversão de datas
 */

@Service
public class CadastroClienteService {
	
	@Autowired
	ClientsInterface interf;
	
	public Clients salvar(Clients client) {
		
		Clients cli = interf.findByEmail(client.getEmail());
		if(cli != null && cli.equals(cli)) {
			throw new NegocioException("O cliente com o email informado já foi criado!");
		}
		
		 return interf.save(client);
	}
	
	public void deletar(Long clientId) {
		interf.deleteById(clientId);
	}
}
