package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.ClientsInterface;
import com.example.demo.models.Clients;

/*
 * Service é onde eu coloco as regras de negpócio específicas
 * do projeto, como alteração do formato de data, etc
 */
@Service
public class CadastroClienteService {
	@Autowired
	private ClientsInterface clientRepository;
	
	public Clients salvar(Clients cliente) {
		return clientRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clientRepository.deleteById(clienteId);
	}
}
