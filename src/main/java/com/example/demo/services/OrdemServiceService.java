package com.example.demo.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import com.example.demo.handlerexception.NegocioException;
import com.example.demo.interfaces.ClientsInterface;
import com.example.demo.interfaces.OrdemServiceInterface;
import com.example.demo.models.Clients;
import com.example.demo.models.Estados;
import com.example.demo.models.OrdemServico;

@Service
public class OrdemServiceService {
	
	@Autowired
	OrdemServiceInterface or;
	
	@Autowired
	ClientsInterface cliente;
	
	public OrdemServico criar(OrdemServico servico){
		
		Clients cli = cliente.findById(servico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente informado inexistente."));
		
		servico.setCliente(cli);
		servico.setDataAbertura(LocalDateTime.now());
		servico.setStatus(Estados.ABERTO);
		
		return or.save(servico);
	}
	
	public void excluir(Long ordemserviceId) {
		or.deleteById(ordemserviceId);
	}
	
	public void fecharOrdemById(Long ondermServicoId) {
		OrdemServico ordem = or.findById(ondermServicoId)
				.orElseThrow(()-> new NegocioException("Ordem de serviço não encontrada."));
		ordem.setStatus(Estados.FINALIZADO);
	}
	
	public OrdemServico fechaOrdem(OrdemServico ordem) {
		ordem.setStatus(Estados.FINALIZADO);
		return ordem;
	}
	
	public OrdemServico cancelaOrdem(OrdemServico ordem) {
		ordem.setStatus(Estados.CANCELADO);
		return ordem;
	}
}
