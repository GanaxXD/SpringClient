package com.example.demo.handlerexception;

import java.time.LocalDateTime;
import java.util.Date;

public class Problema {
	private String titulo;
	private LocalDateTime dataErro;
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
	
}
