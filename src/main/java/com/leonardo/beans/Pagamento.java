package com.leonardo.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
//Herança | Tabelão = Inheritance.Type=JOINED | Tabelinha pra cada entidade = Inheritance.Type=SINGLE_TABLE
//Não precisa mapear as classes filho
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private EstadoPagamento estado;
	
	//Mapeamento de um para um
	@OneToOne
	//Pegando o ID do pedido, precisam ser iguais.
	@JoinColumn(name="pedido_id")
	//Anotação pra saber que é do pedido.
	@MapsId
	private Pedido pedido;
	
	public Pagamento() {
	}
	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado;
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public EstadoPagamento getEstado() {
		return estado;
	}
	public void setEstado(EstadoPagamento estado) {
		this.estado = estado;
	}
	
	public Pagamento(Integer id, EstadoPagamento estado) {
		super();
		this.id = id;
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (estado != other.estado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	


}
