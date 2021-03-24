package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.OrdemServiceInterface;
import com.example.demo.models.OrdemServico;

@Service
public class OrdemServiceService {
	
	@Autowired
	OrdemServiceInterface or;
	
	public OrdemServico criar(OrdemServico servico) {
		return or.save(servico);
	}
	
	public void excluir(Long ordemserviceId) {
		or.deleteById(ordemserviceId);
	}
}
