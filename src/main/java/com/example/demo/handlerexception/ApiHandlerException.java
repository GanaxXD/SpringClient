package com.example.demo.handlerexception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.handlerexception.Problema.Campo;

@ControllerAdvice
public class ApiHandlerException extends ResponseEntityExceptionHandler{
	
	//instanciando o messages.properties do src/main/resources
	@Autowired
	private MessageSource messageSource;
	
//	var campos = new ArrayList<Problema.Campo>();
//	
//	//Iterando pelos erros existentes no MethodArgumentNotValidException
//	for(ObjectError erro : ex.getBindingResult().getAllErrors()) {
//		String nome =((FieldError) erro).getField();
//		String mensagem = erro.messageSource.getMessage(error, LocaleContextHolder.getLocale()); //ou é error ou erro
//		
//		campos.add(new Problema.Campo(nome, mensagem));
//	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		var problema = new Problema();
		problema.setDataErro(LocalDateTime.now());
		//problema.setCampos(campos);
		problema.setTitulo("Dados incorretos ou não preenchidos. Preencha todos os dados e tente novamente.");
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}
}
