/**********************************

 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Equipe - George Lucas
 * 		  - Dynnah Hanna
 **********************************/

package fachada;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import aplicacao.Cadastrar;
import aplicacao.Atualizar;
//import aplicacao.Teste;
import daojpa.DAO;
import daojpa.DAOAtor;
import daojpa.DAOCliente;
import daojpa.DAOFilme;
import daojpa.DAOGenero;
import daojpa.DAOPedido;
import modelo.Ator;
import modelo.Cliente;
import modelo.Filme;
import modelo.Genero;
import modelo.Pedido;

public class Fachada {
	private static DAOAtor daoator = new DAOAtor();
	private static DAOCliente daocliente = new DAOCliente();
	private static DAOFilme daofilme = new DAOFilme();
	private static DAOGenero daogenero = new DAOGenero();
	private static DAOPedido daopedido = new DAOPedido();
	protected static EntityManager manager;
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("retroflix-eclipselink");
	
	public static void openManager() {
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
	}
	
	public static void closeManager() {
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}

	public static Ator cadastrarAtor(String nome, String data, String nacionalidade) throws Exception{
		DAO.begin();
		Ator a = daoator.read(nome);
		if(a != null) {
			DAO.rollback();
			throw new Exception("Cadastrar Ator - ator já cadastrado: " + nome);
		}
		a = new Ator(nome,data,nacionalidade);
		daoator.create(a);
		DAO.commit();
		return a;
	}

	public static Genero cadastrarGenero(String nome) throws Exception{
		DAO.begin();
		Genero g = daogenero.read(nome);
		if(g != null) {
			DAO.rollback();
			throw new Exception("Cadastrar Gênero - gênero já cadastrado: " + nome);
		}
		g = new Genero(nome);
		daogenero.create(g);
		DAO.commit();
		return g;
	}

	public static Filme cadastrarFilme(String titulo, double preco, int lancamento) throws Exception{
		DAO.begin();
		Filme f = daofilme.read(titulo);
		if(f != null) {
			DAO.rollback();
			throw new Exception("Cadastrar Filme - filme já cadastrado: " + titulo);
		}
		f = new Filme(titulo, preco, lancamento);
		daofilme.create(f);
		DAO.commit();
		return f;
	}

	public static Pedido cadastrarPedido(String codPedido, String cliente, String filme, String dataPed) throws Exception{
		DAO.begin();
		Pedido p = daopedido.read(codPedido);
		if(p != null) {
			DAO.rollback();
			throw new Exception("Cadastrar Pedido - pedido já cadastrado: " + codPedido);
		}
		Filme f = daofilme.read(filme);
		if(f == null) {
			DAO.rollback();
			throw new Exception("Filme inexistente");
		}

		Cliente c = daocliente.read(cliente);
		if(c == null) {
			DAO.rollback();
			throw new Exception("Cliente inexistente");
		}

		p = new Pedido(codPedido, c, f, dataPed);
		daopedido.create(p);
		DAO.commit();
		return p;
	}

	public static Cliente cadastrarCliente(String nome, String email, String cep, String cpf) throws Exception{
		DAO.begin();
		Cliente c = daocliente.read(cpf);
		if(c != null) {
			DAO.rollback();
			throw new Exception("Cadastrar Cliente - cliente já cadastrado: " + nome + " - " + cpf);
		}
		c = new Cliente(nome, email, cep, cpf);
		daocliente.create(c);
		DAO.commit();
		return c;
	}

	public static void addAtorFilme (String nome, String titulo) throws Exception {
		DAO.begin();
		Ator a = daoator.read(nome);
		if(a == null) {
			DAO.rollback();
			throw new Exception("Ator inexistente!");
		}
		Filme f = daofilme.read(titulo);
		if(f == null) {
			DAO.rollback();
			throw new Exception("Filme inexistente");
		}
		f.addAtor(a);
		a.addFilme(f);
		daofilme.update(f);
		daoator.update(a);
		DAO.commit();
	}

	public static void addGeneroFilme (String nome, String titulo) throws Exception {
		DAO.begin();
		Genero g = daogenero.read(nome);
		if(g == null) {
			DAO.rollback();
			throw new Exception ("Gênero inexistente!");
		}
		Filme f = daofilme.read(titulo);
		if(f == null) {
			DAO.rollback();
			throw new Exception ("Filme inexistente!");
		}
		f.addGenero(g);
		g.addFilme(f);
		daofilme.update(f);
		daogenero.update(g);
		DAO.commit();
	}

	public static void addFilmePedido (String titulo, String cod) throws Exception {
		DAO.begin();
		Filme f = daofilme.read(titulo);
		if(f == null) {
			DAO.rollback();
			throw new Exception("Filme inexistente");
		}
		Pedido p = daopedido.read(cod);
		if(p == null) {
			DAO.rollback();
			throw new Exception ("Pedido inexistente!");
		}
		p.addFilmePed(f);
		f.addPedido(p);
		daopedido.update(p);
		daofilme.update(f);
		DAO.commit();
	}

	public static void addPedidoCliente (String cod, String cpf) throws Exception {
		DAO.begin();
		Pedido p = daopedido.read(cod);
		if(p == null) {
			DAO.rollback();
			throw new Exception ("Pedido inexistente!");
		}
		Cliente c = daocliente.read(cpf);
		if(c == null) {
			DAO.rollback();
			throw new Exception ("Cliente inexistente!");
		}
		c.addPedido(p);
		daocliente.update(c);
		DAO.commit();
	}

	public static String listarAtores(){
		List<Ator> atores = daoator.readAll();
		String texto="-----------listagem de Atores-----------\n";
		for (Ator at : atores) {
			texto += at +"\n";
		}
		return texto;
	}

	public static String listarGeneros(){
		List<Genero> generos = daogenero.readAll();
		String texto="-----------listagem de Generos-----------\n";
		for (Genero ge : generos) {
			texto += ge +"\n";
		}
		return texto;
	}

	public static String listarFilmes(){
		List<Filme> filmes = daofilme.readAll();
		String texto="-----------listagem de Filmes-----------\n";
		for (Filme fi : filmes) {
			texto += fi +"\n";
		}
		return texto;
	}

	public static String listarPedidos(){
		List<Pedido> pedidos = daopedido.readAll();
		String texto="-----------listagem de Pedidos-----------\n";
		for (Pedido pe : pedidos) {
			texto += pe +"\n";
		}
		return texto;
	}

	public static String listarClientes(){
		List<Cliente> clientes = daocliente.readAll();
		String texto="-----------listagem de Clientes-----------\n";
		for (Cliente cl : clientes) {
			texto += cl +"\n";
		}
		return texto;
	}

	public static void alterarClienteCEP(String cpf, String novoCep) throws Exception{
		DAO.begin();		
		Cliente c = daocliente.read(cpf);	
		if (c==null) {
			DAO.rollback();
			throw new Exception("alterar CEP de cliente - cliente inexistente:" + cpf);
		}

		c.setCep(novoCep); 			
		c=daocliente.update(c);     	
		DAO.commit();	
	}

	public static void alterarPedidoStatus(String codPed, String novoStatus) throws Exception{
		DAO.begin();
		Pedido p = daopedido.read(codPed);
		if (p==null) {
			DAO.rollback();
			throw new Exception("alterar status de pedido - pedido inexistente:" + codPed);
		}

		p.setStatusPagamento(novoStatus);
		p=daopedido.update(p);
		DAO.commit();
	}

	public static void excluirCliente(String cpf) throws Exception {
		DAO.begin();
		Cliente c = daocliente.read(cpf);
		if (c==null) {
			DAO.rollback();
			throw new Exception("excluir cliente - cliente inexistente:" + cpf);
		}

		if(c.getPedidos().isEmpty()) {
			daocliente.delete(c);
			DAO.commit();
		}else {
			List<Pedido> ped = c.getPedidos();
			for (Pedido pe: ped) {
				pe.setCliente(null);
				daopedido.update(pe);
			}
			daocliente.delete(c);
			DAO.commit();
		}
	}
}
	/**********************************************************
	 * 
	 * CONSULTAS 
	 * 
	 **********************************************************/

	//	public static String consultarAtoresPorParteNome(String caracteres) {
	//		List<Ator> result = daoator.consultarAtoresPorParteNome(caracteres);
	//
	//		String texto = "\nConsultar atores por parte do nome:"+caracteres;
	//		if (result.isEmpty())  
	//			texto += "consulta vazia";
	//		else 
	//			for(Ator a: result)texto += "\n" + a;
	//		return texto;
	//	}
	//	
	//	public static String consultarFilmesPorCliente(String cli) {
	//		List<Filme> result = daofilme.consultarFilmesPorCliente(cli);
	//		
	//		String texto = "\nConsultar filmes por cliente:"+cli;
	//		if (result.isEmpty())
	//			texto += "consulta vazia";
	//		else
	//			for(Filme f: result)texto += "\n" + f;
	//		return texto;
	//	}
	//	
	//	public static String consultarGeneroPorAtor(String nome) {
	//		List<Genero> result = daogenero.consultarGeneroPorAtor(nome);
	//		
	//		String texto = "\nConsultar generos por ator:"+nome;
	//		if (result.isEmpty())
	//			texto += "consulta vazia";
	//		else
	//			for(Genero g: result)texto += "\n" + g.getNome();
	//		return texto;
	//	}
	//	
	//	public static String consultarTotalCliente(String cli) {
	//		List<Filme> result = daofilme.consultarTotalCliente(cli);
	//		
	//		String texto = "\nConsultar total do cliente:"+cli;
	//		double sum = 0;
	//		if (result.isEmpty())
	//			texto += "consulta vazia";
	//		else {
	//			for(Filme f: result) {
	//				sum += f.getPreco();
	//			}
	//			texto += "\n" + sum;
	//		}
	//		return texto;
	//	}

// consulta

