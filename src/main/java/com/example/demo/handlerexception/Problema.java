package com.example.demo.handlerexception;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Date;

@JsonInclude(Include.NON_NULL)
public class Problema {
	private Integer status;
	private String titulo;
	private OffsetDateTime dataErro;
	
	public List<Campo> campos;
	
	public static class Campo {
		private String titulo;
		private String mensagem;
		
		
		public Campo(String titulo, String mensagem) {
			super();
			this.titulo = titulo;
			this.mensagem = mensagem;
		}
		
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getMensagem() {
			return mensagem;
		}
		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}
		
	}
		
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public OffsetDateTime getDataErro() {
		return dataErro;
	}
	public void setDataErro(OffsetDateTime dataErro) {
		this.dataErro = dataErro;
	}
	public List<Campo> getCampos() {
		return campos;
	}
	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}
	
	
}
