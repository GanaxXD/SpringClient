package com.example.demo.models;

import javax.validation.constraints.NotBlank;

public class ComentariosInput {
	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
