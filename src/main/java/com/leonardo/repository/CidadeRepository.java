package com.leonardo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonardo.beans.Cidade;

//Acessar as categorias CRUD
//Responsável pela comunicação e implementação dos métodos a serem feitos.

//Falar que é do tipo Repository
@Repository
//Declarar uma interface com os métodos implementados vindo da classe JpaRepository, 
//definindo o que vai ser utilizado no caso Categoria e o ID é do tipo Integer.
//Acesso a dados
public interface CidadeRepository extends JpaRepository<Cidade,Integer>{

}
