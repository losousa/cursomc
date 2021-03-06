package com.leonardo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//Define que o nome da tabela e a associação vem dessa classe devido ao nome.
@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	//Define que é o ID da classe.
	@Id
	//Auto-Incrementa o ID.
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//Muda o nome da coluna conforme o parametro
	//@Column(name="nomeCompleto")
	private String nome;
	
	//JsonManagedReference que venha os objetos associados.
	@JsonManagedReference
	//Relacionamento muitos pra muitos com o Produto
	//MappedBy define que foi mapeado na classe de Produto e não precisa fazer novamente aqui.
	@ManyToMany(mappedBy="categorias")
	//Pegar uma Lista de Produtos.
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria() {
	}
	
	public Categoria(Integer id,String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}

	//HashCode e Equals método para comparar valores.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
