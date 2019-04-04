package com.leonardo.beans;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class PagamentoCartao extends Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroParcelas;
	
	public PagamentoCartao() {
	}
	
	public PagamentoCartao(Integer id, EstadoPagamento estado,Pedido pedido, Integer numeroParcelas) {
		super(id, estado,pedido);
		this.numeroParcelas = numeroParcelas;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
	
	

}
