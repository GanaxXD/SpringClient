package com.example.demo.services;


import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.handlerexception.NegocioException;
import com.example.demo.interfaces.ClientsInterface;
import com.example.demo.interfaces.ComentariosInterface;
import com.example.demo.interfaces.OrdemServiceInterface;
import com.example.demo.models.Clients;
import com.example.demo.models.Comentarios;
import com.example.demo.models.Estados;
import com.example.demo.models.OrdemServico;

@Service
public class OrdemServiceService {
	
	@Autowired
	OrdemServiceInterface or;
	
	@Autowired
	ClientsInterface cliente;
	
	@Autowired
	ComentariosInterface comentarios;
	
	public OrdemServico criar(OrdemServico servico){
		System.out.print(OffsetDateTime.now());
		if(servico.getCliente()==null) {
			throw new NegocioException("Todos os campos solicitados são obrigatórios!");
		}
		Clients cli = cliente.findById(servico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente informado inexistente."));
		
		servico.setCliente(cli);
		servico.setDataAbertura(OffsetDateTime.now());
		servico.setStatus(Estados.ABERTO);
		
		if(servico.getPreco() == null  
				|| servico.getPreco().toString().trim().equals("")
				|| servico.getDescricao().trim().equals("")
				|| servico.getCliente().getId().toString().equals("")) {
			throw new NegocioException("Todas as informações solicitadas são obrigatórias!");
		}
		
		return or.save(servico);
	}
	
	public void excluir(Long ordemserviceId) {
		if(or.findById(ordemserviceId) == null) {
			throw new NegocioException("Ordem de serviço não encontrada.");
		}
	}
	
	public void fecharOrdemById(Long ondermServicoId) {
		OrdemServico ordem = or.findById(ondermServicoId)
				.orElseThrow(()-> new NegocioException("Ordem de serviço não encontrada."));
		ordem.setStatus(Estados.FINALIZADO);
	}
	
	
	public OrdemServico fechaOrdem(OrdemServico ordem) {
		if(ordem == null || ordem.getId()==null || ordem.getId().toString().trim().equals("")) {
			throw new NegocioException("Ordem de serviço não encontrada!");
		}
		ordem.setStatus(Estados.FINALIZADO);
		return ordem;
	}
	
	public OrdemServico cancelaOrdem(OrdemServico ordem) {
		if(ordem == null || ordem.getId()==null || ordem.getId().toString().trim().equals("")) {
			throw new NegocioException("Ordem de serviço não encontrada!");
		}
		ordem.setStatus(Estados.CANCELADO);
		return ordem;
	}
	
	public Comentarios adicionarcomentario(Long ordemServicoId, String descricao){
		OrdemServico ordem = or.findById(ordemServicoId)
				.orElseThrow(()-> new NegocioException("Ordem de serviço não encontrada."));
	
		if(descricao.trim().equals(" ") || descricao == null) {
			throw new NegocioException("Todos os campos devem ser preenchidos!");
		}
		
		Comentarios coment = new Comentarios();
		coment.setDataEnvio(OffsetDateTime.now());
		coment.setDescricao(descricao);
		coment.setOrdemServico(ordem);
		
		return comentarios.save(coment);
	}
	
}