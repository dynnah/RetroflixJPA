package aplicacao;
import fachada.Fachada;
import modelo.*;

/**********************************

 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Equipe - George Lucas
 * 		  - Dynnah Hanna
 **********************************/


public class AplicacaoConsole {

	public AplicacaoConsole(){	
		Fachada.inicializar();
		cadastrar(); 			
		//atualizar();		
		//apagar();			
		listar();			
		//consultar();
		Fachada.finalizar();
	}


	public void cadastrar(){
		Ator a;
		Genero g;
		Filme f;
		Pedido p;
		Cliente c;

		// População da Tabela Ator //
		try {
			a = Fachada.cadastrarAtor("Tom Holland","1996-06-01","Inglesa");
			a = Fachada.cadastrarAtor("Mark Ruffalo","1967-11-22","Americana");
			a = Fachada.cadastrarAtor("Letitia Wright","1993-10-31","Inglesa");
			a = Fachada.cadastrarAtor("Brie Larson","1989-10-01","Americana");
			a = Fachada.cadastrarAtor("Evan Peters","1987-01-20","Americana");
		}catch (Exception e) {System.out.println(e.getMessage());}

		// População da Tabela Gênero //
		try {
			g = Fachada.cadastrarGenero("Terror");
			g = Fachada.cadastrarGenero("Suspense");
			g = Fachada.cadastrarGenero("Ficção Científica");
			g = Fachada.cadastrarGenero("Romance");
			g = Fachada.cadastrarGenero("Musical");
		}catch (Exception e) {System.out.println(e.getMessage());}

		// População da Tabela Filme //
		try {
			f = Fachada.cadastrarFilme("Spider-Man", 14.90, 2017);
			f = Fachada.cadastrarFilme("Captain Marvel", 29.90, 2019);
			f = Fachada.cadastrarFilme("Avengers: Endgame", 39.90, 2019);
			f = Fachada.cadastrarFilme("X-Men: Apocalypse", 12.50, 2016);
			f = Fachada.cadastrarFilme("Room", 14.90, 2016);
		}catch (Exception e) {System.out.println(e.getMessage());}

		// População da Tabela Cliente //
		try {
			c = Fachada.cadastrarCliente("Dynnah Hanna", "eudynnah@gmail.com", "55555-555", "999.999.999-99");
			c = Fachada.cadastrarCliente("Helena Juliana", "euhelena@gmail.com", "44444-444", "888.888.888-88");
			c = Fachada.cadastrarCliente("George Gomes", "eugeorge@gmail.com", "33333-333", "777.777.777-77");
			c = Fachada.cadastrarCliente("Rafael Marinho", "eurafael@gmail.com", "22222-222", "555.555.555-55");
			c = Fachada.cadastrarCliente("Paulo Henrique", "eupaulo@gmail.com", "11111-111", "333.333.333-33");
		}catch (Exception e) {System.out.println(e.getMessage());}
		
		// População da Tabela Pedido //
		try {
			p = Fachada.cadastrarPedido("1", "777.777.777-77", "Spider-Man", "03/08/2019");
			p = Fachada.cadastrarPedido("2", "888.888.888-88", "Room", "03/08/2019");
			p = Fachada.cadastrarPedido("3", "999.999.999-99", "Captain Marvel", "03/08/2019");
			p = Fachada.cadastrarPedido("4", "333.333.333-33", "X-Men: Apocalypse", "03/08/2019");
			p = Fachada.cadastrarPedido("5", "555.555.555-55", "Avengers: Endgame", "03/08/2019");
		}catch (Exception e) {System.out.println(e.getMessage());}

		// Atualização da Tabela Filme - FilmeAtor
		try{
			Fachada.addAtorFilme("Tom Holland", "Spider-Man");
			Fachada.addAtorFilme("Brie Larson", "Room");
			Fachada.addAtorFilme("Mark Ruffalo", "Avengers: Endgame");
			Fachada.addAtorFilme("Letitia Wright", "Avengers: Endgame");
			Fachada.addAtorFilme("Tom Holland", "Avengers: Endgame");
			Fachada.addAtorFilme("Brie Larson", "Captain Marvel");
			Fachada.addAtorFilme("Evan Peters", "X-Men: Apocalypse");
		}catch (Exception e) {System.out.println(e.getMessage());}

		// Atualização da Tabela Filme - FilmeGenero
		try{
			Fachada.addGeneroFilme("Terror", "Spider-Man");
			Fachada.addGeneroFilme("Suspense", "Room");
			Fachada.addGeneroFilme("Suspense", "Captain Marvel");
			Fachada.addGeneroFilme("Ficção Científica", "Avengers: Endgame");
			Fachada.addGeneroFilme("Ficção Científica", "X-Men: Apocalypse");
		}catch (Exception e) {System.out.println(e.getMessage());}

		//Atualização de Filmes em Pedidos - PedidoFilme
		try{
			Fachada.addFilmePedido("Spider-Man", "3");
			Fachada.addFilmePedido("Room", "4");
			Fachada.addFilmePedido("Captain Marvel", "5");
			Fachada.addFilmePedido("X-Men: Apocalypse", "1");
			Fachada.addFilmePedido("Avengers: Endgame", "3");
		}catch (Exception e) {System.out.println(e.getMessage());}


		//Atualização de Pedidos em Clientes - ClientePedido
		try{
			Fachada.addPedidoCliente("3", "999.999.999-99");
			Fachada.addPedidoCliente("2", "888.888.888-88");
			Fachada.addPedidoCliente("1", "777.777.777-77");
			Fachada.addPedidoCliente("5", "555.555.555-55");
			Fachada.addPedidoCliente("4", "333.333.333-33");
		}catch (Exception e) {System.out.println(e.getMessage());}
	}

//	/************************/
//	public void atualizar(){
//		try {
//			Fachada.alterarPessoa("joao","joana");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	/************************/
//	public void apagar(){
//		try {
//			Fachada.excluirPessoa("maria");			
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}

	/************************/
	public void listar(){
		try {
			System.out.println(Fachada.listarAtores());
			System.out.println(Fachada.listarGeneros());
			System.out.println(Fachada.listarFilmes());
			System.out.println(Fachada.listarPedidos());
			System.out.println(Fachada.listarClientes());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



//	/************************/
//	public void consultar(){
//		try {
//			System.out.println(Fachada.consultarSexo(Sexo.MASCULINO));
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//	
//	
	//=================================================
	public static void main(String[] args) {
		new AplicacaoConsole();
	}
	//=================================================

}
