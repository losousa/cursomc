package com.leonardo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leonardo.beans.Categoria;
import com.leonardo.beans.Cidade;
import com.leonardo.beans.Cliente;
import com.leonardo.beans.Endereco;
import com.leonardo.beans.Estado;
import com.leonardo.beans.EstadoPagamento;
import com.leonardo.beans.Pagamento;
import com.leonardo.beans.PagamentoBoleto;
import com.leonardo.beans.PagamentoCartao;
import com.leonardo.beans.Pedido;
import com.leonardo.beans.Produto;
import com.leonardo.beans.TipoCliente;
import com.leonardo.repository.CategoriaRepository;
import com.leonardo.repository.CidadeRepository;
import com.leonardo.repository.ClienteRepository;
import com.leonardo.repository.EnderecoRepository;
import com.leonardo.repository.EstadoRepository;
import com.leonardo.repository.PagamentoRepository;
import com.leonardo.repository.PedidoRepository;
import com.leonardo.repository.ProdutoRepository;

//Classe que vai fazer a aplicação funcionar
//Porta 8080. localhost:8080
@SpringBootApplication

//Implementa métodos pra toda vez que o programa rodar, fazer o que esta no método.
public class CursomcApplication implements CommandLineRunner{
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private CategoriaRepository repo;

	@Autowired
	private ProdutoRepository pro;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		//Instanciando os Produtos dizendo em qual categoria eles pertencem.
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
	 	//Falando qual categoria cada produto pertence.
		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1,cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));
		
		//Salvando no banco o que foi definido acima
		repo.saveAll(Arrays.asList(cat1,cat2));
		pro.saveAll(Arrays.asList(p1,p2,p3));
		
		//Cidades e Estados
		Estado e1 = new Estado(null,"Minas Gerais");
		Estado e2 = new Estado(null,"Sao Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia",e1);
		Cidade c2 = new Cidade(null,"Sao Paulo",e2);
		Cidade c3 = new Cidade(null,"Campinas",e2);
		
		e1.getCidade().addAll(Arrays.asList(c1));
		e2.getCidade().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(e1,e2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		//Clientes e Endereços
		Cliente cli1 = new Cliente(null,"Maria","maria@gmail.com","353789377", TipoCliente.fisica);
		cli1.getTelefone().addAll(Arrays.asList("964483584","1123898962"));
		
		Endereco end1 = new Endereco(null,"Rua Flores","300","Apto 203","Jardim","03884030",cli1,c1);
		Endereco end2 = new Endereco(null,"Avenida Mantos","105","Sala 800","Centro","38777012",cli1,c2);
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		//Pedido,Pagamento
		Pedido pe1 = new Pedido(null,sdf.parse("30/09/2017"),end1,cli1);
		Pagamento pa = new PagamentoCartao(null,EstadoPagamento.PAGO,pe1,6);
		pe1.setPagamento(pa);
		Pedido pe2 = new Pedido(null,sdf.parse("10/10/2017"),end2,cli1);
		Pagamento pa2 = new PagamentoBoleto(null, EstadoPagamento.NAOPAGO,pe2, sdf.parse("20/10/2017"), null);
		pe2.setPagamento(pa2);
		cli1.getPedidos().addAll(Arrays.asList(pe1,pe2));
		
		pedidoRepository.saveAll(Arrays.asList(pe1,pe2));
		pagamentoRepository.saveAll(Arrays.asList(pa,pa2));
		
	}

}
