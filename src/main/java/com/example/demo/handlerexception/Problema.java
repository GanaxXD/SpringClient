package com.example.demo.handlerexception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Date;

public class Problema {
	private String titulo;
	private LocalDateTime dataErro;
	
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
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public LocalDateTime getDataErro() {
		return dataErro;
	}
	public void setDataErro(LocalDateTime dataErro) {
		this.dataErro = dataErro;
	}
	public List<Campo> getCampos() {
		return campos;
	}
	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}
	
	
}
