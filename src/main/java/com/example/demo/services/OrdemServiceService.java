package com.example.demo.services;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
		
		Clients cli = cliente.findById(servico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente informado inexistente."));
		
		servico.setCliente(cli);
		servico.setDataAbertura(OffsetDateTime.now());
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
	
	public Comentarios adicionarcomentario(Long ordemServicoId, String descricao){
		OrdemServico ordem = or.findById(ordemServicoId)
				.orElseThrow(()-> new NegocioException("Ordem de serviço não encontrada."));
	
		Comentarios coment = new Comentarios();
		coment.setDataEnvio(OffsetDateTime.now());
		coment.setDescricao(descricao);
		coment.setOrdemServico(ordem);
		
		return comentarios.save(coment);
	}
	
}
