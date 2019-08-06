package aplicacao;

import fachada.Fachada;

public class Atualizar {

	public Atualizar() {
		Fachada.inicializar();
		System.out.println("Atualizando...");

		// Atualização da Tabela Filme - FilmeAtor
		try{
			Fachada.openManager();
			Fachada.addAtorFilme("Tom Holland", "Spider-Man");
			Fachada.addAtorFilme("Brie Larson", "Room");
			Fachada.addAtorFilme("Mark Ruffalo", "Avengers: Endgame");
			Fachada.addAtorFilme("Letitia Wright", "Avengers: Endgame");
			Fachada.addAtorFilme("Tom Holland", "Avengers: Endgame");
			Fachada.addAtorFilme("Brie Larson", "Captain Marvel");
			Fachada.addAtorFilme("Evan Peters", "X-Men: Apocalypse");
			Fachada.closeManager();
		}catch (Exception e) {System.out.println(e.getMessage());}

		// Atualização da Tabela Filme - FilmeGenero
		try{
			Fachada.openManager();
			Fachada.addGeneroFilme("Terror", "Spider-Man");
			Fachada.addGeneroFilme("Suspense", "Room");
			Fachada.addGeneroFilme("Suspense", "Captain Marvel");
			Fachada.addGeneroFilme("Ficcao cientifica", "Avengers: Endgame");
			Fachada.addGeneroFilme("Ficcao cientifica", "X-Men: Apocalypse");
			Fachada.closeManager();
		}catch (Exception e) {System.out.println(e.getMessage());}

		//Atualização de Filmes em Pedidos - PedidoFilme
		try{
			Fachada.openManager();
			Fachada.addFilmePedido("Spider-Man", "3");
			Fachada.addFilmePedido("Room", "4");
			Fachada.addFilmePedido("Captain Marvel", "5");
			Fachada.addFilmePedido("X-Men: Apocalypse", "1");
			Fachada.addFilmePedido("Avengers: Endgame", "3");
			Fachada.closeManager();
		}catch (Exception e) {System.out.println(e.getMessage());}


		//Atualização de Pedidos em Clientes - ClientePedido
		try{
			Fachada.openManager();
			Fachada.addPedidoCliente("3", "999.999.999-99");
			Fachada.addPedidoCliente("2", "888.888.888-88");
			Fachada.addPedidoCliente("1", "777.777.777-77");
			Fachada.addPedidoCliente("5", "555.555.555-55");
			Fachada.addPedidoCliente("4", "333.333.333-33");
			Fachada.closeManager();
		}catch (Exception e) {System.out.println(e.getMessage());}



		Fachada.finalizar();
		System.out.println("Programa finalizado");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Atualizar();
	}
}