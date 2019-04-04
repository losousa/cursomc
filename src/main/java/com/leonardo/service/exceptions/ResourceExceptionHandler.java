package com.leonardo.service.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Interceptar as exceções.
@ControllerAdvice
public class ResourceExceptionHandler {
	
	//Receber as exceções.
	@ExceptionHandler(ObjetoNaoEncontrado.class)
	public ResponseEntity<StandandError> objetoNaoEncontrad(ObjetoNaoEncontrado e, HttpServletRequest req){
		
		//Definir os conteúdos de uma mensagem de erro.
		StandandError error = new StandandError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
