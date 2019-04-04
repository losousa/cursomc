package com.leonardo.service.exceptions;

public class ObjetoNaoEncontrado extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	//Mensagem de erro personalizada
	public ObjetoNaoEncontrado(String msg) {
		super(msg);
	}

	//Causa de algo que aconteceu antes e a mensagem de erro
	public ObjetoNaoEncontrado(String msg,Throwable thro) {
		super(msg,thro);
	}
}
