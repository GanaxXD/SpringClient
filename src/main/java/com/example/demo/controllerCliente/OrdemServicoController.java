package com.example.demo.controllerCliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.OrdemServiceInterface;
import com.example.demo.models.OrdemServico;

@RestController
@RequestMapping("/ordemservico")
public class OrdemServicoController {
	
	@Autowired
	OrdemServiceInterface os;
	
	@GetMapping()
	public List<OrdemServico> listarOrdensServico(){
		return os.findAll();
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico criarOrdemServico(OrdemServico ordem) {
		return os.save(ordem);
	}
	
	@DeleteMapping("/{ordemserviceId}")
	public ResponseEntity<OrdemServico> deletar(@PathVariable Long ordemserviceId){
		if(!os.findById(ordemserviceId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		os.deleteById(ordemserviceId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{ordemservicoId}")
	public ResponseEntity<OrdemServico> atualizar(@PathVariable Long ordemservicoId, @RequestParam OrdemServico ordemServico){
		if(!os.findById(ordemservicoId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		os.save(ordemServico);
		return ResponseEntity.ok().build();
	}
}
