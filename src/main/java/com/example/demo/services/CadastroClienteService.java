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
		/*
		 * System.out.println(cli.getEmail()); System.out.println(client.getEmail());
		 */
		System.out.print(client.getEmail()+ "  "+ client.getFone()+ "  "+ client.getNome());
		if(cli != null && !cli.equals(client)) {
			throw new NegocioException("O cliente com o email informado já foi criado!");
		}
		if(client.getEmail().trim().equals("")|| client.getNome().trim().equals("") 
				|| client.getFone().trim().equals("") || client.equals(null)) {
			System.out.println("CHEGUEI AQUI");
			throw new NegocioException("Todos os dados solicitados são obrigatórios");
		}
		
		 return interf.save(client);
	}
	
	public void deletar(Long clientId) {
		interf.deleteById(clientId);
	}
}