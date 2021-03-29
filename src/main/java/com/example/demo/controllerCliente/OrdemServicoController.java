package com.example.demo.controllerCliente;

import java.util.List;
import java.util.stream.Collector;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.OrdemServiceInterface;
import com.example.demo.models.OrdemServico;
import com.example.demo.representationmodelclass.RepresentationModelOrdemServico;
import com.example.demo.services.OrdemServiceService;

@RestController
@RequestMapping("/ordemservico")
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
	public OrdemServico criarOrdemServico(@Valid @RequestBody OrdemServico ordem) {
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
}