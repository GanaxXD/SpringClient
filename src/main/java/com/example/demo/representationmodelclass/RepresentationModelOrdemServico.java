package com.example.demo.representationmodelclass;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.models.ClientResumeModel;
import com.example.demo.models.Estados;

/*
 *  A Representation model será o modelo de representação das
 * models lançadas.
 * O Objetivo é que durante a utilização da API, caso eu 
 * precise mostrar apenas alguns dados da model nos 
 * resultados dos endpoints, eu utilize as representationsmodels
 * e não as models. Ao criá-las, o tipo de retorno dos métiodos
 * no controller e nos services devem ser dessas models.
 * Para mapeá-las na utilização, foi usada a lib modelmapper
 * que facilita o processo.
 */

public class RepresentationModelOrdemServico {
	
	private Long id;
	private String descricao;
	private ClientResumeModel cliente;
	private BigDecimal preco;
	private LocalDateTime dataAbertura;
	private LocalDateTime dataFinalizacao;
	private Estados status;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ClientResumeModel getCliente() {
		return cliente;
	}
	public void setCliente(ClientResumeModel cliente) {
		this.cliente = cliente;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public LocalDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	public Estados getStatus() {
		return status;
	}
	public void setStatus(Estados status) {
		this.status = status;
	}

	
}
