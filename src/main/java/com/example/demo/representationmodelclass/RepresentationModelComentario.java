package com.example.demo.representationmodelclass;

import com.example.demo.models.OrdemServico;

public class RepresentationModelComentario {
	private OrdemServico ordemServico;
	private String descricao;
	
	
	public OrdemServico getOrdemServico() {
		return ordemServico;
	}
	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
