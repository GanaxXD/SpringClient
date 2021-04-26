package com.example.demo.models;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
 * Classe que vai trazer os dados do usuário;
 * Isso evita que ele saiba de dados que eu não queira que ele 
 * visualize ou mexa no cadastro de uma ordem se serviço.
 * Por exemplo, os status sempre iniciam como aberto, e não quero que ele altere a data de 
 * início da ordem de serviço.
 * 
 * ESSA É UMA FORMA ALTERNATIVA DE VALIDAR AS ENTRADAS, SEM USAR AS ANOTAÇÕES
 * PRESENTES EM ALGUMAS PROPRIEDADES DA CLASSE ORDEM DE SERVIÇO
 */
public class OrdemServicoInput {
	
	private String descricao;
	private BigDecimal preco;
	private Long clienteId;
	/*
	 * @Valid private ClientsInputId clienteId;
	 */
	
	
	public String getDescricao() {
		return descricao;
	}
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	/*
	 * public ClientsInputId getClientsId() { return clienteId; } public void
	 * setClientsId(ClientsInputId clienteId) { this.clienteId = clienteId; }
	 */
	
}
