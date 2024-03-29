package com.example.demo.handlerexception;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.handlerexception.Problema.Campo;

@ControllerAdvice
public class ApiHandlerException extends ResponseEntityExceptionHandler {
	// instanciando o messages.properties do src/main/resources
	@Autowired
	public MessageSource messageSource;	 

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handlerNegocio(NegocioException ex, WebRequest web){
		var status = HttpStatus.BAD_REQUEST;
		Problema problema = new Problema();
		
		problema.setStatus(status.value());
		problema.setDataErro(OffsetDateTime.now());
		problema.setTitulo(ex.getMessage());
		
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, web);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ArrayList<Campo> campos = new ArrayList<Campo>();
		  
		  //Iterando pelos erros existentes no MethodArgumentNotValidException
		  for(ObjectError erro : ex.getBindingResult().getAllErrors()) { 
			  String nome=((FieldError) erro).getField(); 
			  String mensagem = erro.getDefaultMessage();//erro.messageSource.getMessage(erro, LocaleContextHolder.getLocale()); //ou é error ou erro
		  
			  campos.add(new Problema.Campo(nome, mensagem)); 
		  }
		
		var problema = new Problema();
		problema.setStatus(status.value());
		problema.setDataErro(OffsetDateTime.now());
		problema.setCampos(campos);
		problema.setTitulo("Dados incorretos ou não preenchidos. Preencha todos os dados e tente novamente.");
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}
}