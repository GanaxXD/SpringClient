package com.example.demo.controllerCliente;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.handlerexception.NegocioException;
import com.example.demo.interfaces.OrdemServiceInterface;
import com.example.demo.models.Estados;
import com.example.demo.models.OrdemServico;
import com.example.demo.models.OrdemServicoInput;
import com.example.demo.representationmodelclass.RepresentationModelOrdemServico;
import com.example.demo.services.OrdemServiceService;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@RestController
@RequestMapping(value="/ordemservico", produces = "application/vnd.baeldung.api.v1+json")
public class OrdemServicoController {
	
	@Autowired
	OrdemServiceInterface osInterface;
	
	@Autowired
	OrdemServiceService osService;
	
	@Autowired
	ModelMapper ordemServicoMap;
	
	@GetMapping()
	public List<RepresentationModelOrdemServico> listarOrdensServico(){
		List<OrdemServico> listaDeOrdens =  osInterface.findAll();
		return toModelList(listaDeOrdens);
	}
	
	@GetMapping("/{ordemServicoId}")
	public ResponseEntity<RepresentationModelOrdemServico> listarOrdensServicoPeoId(@PathVariable Long ordemServicoId){
		if(!osInterface.findById(ordemServicoId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		RepresentationModelOrdemServico os = toModel(osInterface.findById(ordemServicoId).get());
		return ResponseEntity.ok(os);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico criarOrdemServico(@Valid @RequestBody OrdemServicoInput ordemInput) {
		OrdemServico ordem = toInputModel(ordemInput);
		return osService.criar(ordem);
	}

	@PutMapping("/{ordemservicoId}")
	public ResponseEntity<OrdemServico> atualizar(@Valid @PathVariable Long ordemservicoId, @RequestBody OrdemServico ordemServico){
		if(!osInterface.findById(ordemservicoId).isPresent()) { 
			return ResponseEntity.notFound().build();
		}
		ordemServico.setId(ordemservicoId);
		return ResponseEntity.ok(osService.criar(ordemServico));
	}
	
	@DeleteMapping("/{ordemserviceId}")
	public ResponseEntity<OrdemServico> deletar(@PathVariable Long ordemserviceId){
		if(!osInterface.findById(ordemserviceId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		osInterface.deleteById(ordemserviceId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{ordemserviceId}/finalizar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long ordemserviceId) {
		OrdemServico os = osInterface.findById(ordemserviceId)
				.orElseThrow(() -> new NegocioException("Ordem de serviço não encontrada!"));
		if(!os.getStatus().equals(Estados.ABERTO)) {
			throw new NegocioException("A ordem está ou cancelada ou finaizada.");
		}
		os.setStatus(Estados.FINALIZADO);
		os.setDataFinalizacao(OffsetDateTime.now());
		osInterface.save(os);
	}
	
	@PutMapping("/{ordemserviceId}/cancelar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void cancelar(@PathVariable Long ordemserviceId) {
		OrdemServico os = osInterface.findById(ordemserviceId)
				.orElseThrow(() -> new NegocioException("Ordem de serviço não encontrada!"));
		if(!os.getStatus().equals(Estados.ABERTO)) {
			throw new NegocioException("A ordem está ou cancelada ou finaizada.");
		}
		os.setStatus(Estados.CANCELADO);
		os.setDataFinalizacao(OffsetDateTime.now());
		osInterface.save(os);
	}
	
	//transforma uma ordem de serviço numa representation model
	public RepresentationModelOrdemServico toModel(OrdemServico ordem) {
		return ordemServicoMap.map(ordem, RepresentationModelOrdemServico.class);
	}
	//transforma uma lista de ordem de serviços em uma lista de representation model
	public List<RepresentationModelOrdemServico> toModelList(List<OrdemServico> ordens){
		return ordens.stream()
				.map(ordemServico -> toModel(ordemServico))
				.collect(Collectors.toList());
	}
	
	public OrdemServico toInputModel(OrdemServicoInput ordem) {
		return ordemServicoMap.map(ordem, OrdemServico.class);
	}
}