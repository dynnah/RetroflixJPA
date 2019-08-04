package aplicacao;

import fachada.Fachada;


public class Cadastrar {
	
	public Cadastrar() {
		Fachada.inicializar();
		System.out.println("Cadastrando...");
		
		try {
			Fachada.cadastrarAtor("Tom Holland","1996-06-01","Inglesa");
			Fachada.cadastrarAtor("Mark Ruffalo","1967-11-22","Americana");
			Fachada.cadastrarAtor("Letitia Wright","1993-10-31","Inglesa");
			Fachada.cadastrarAtor("Brie Larson","1989-10-01","Americana");
			Fachada.cadastrarAtor("Evan Peters","1987-01-20","Americana");
			
			Fachada.cadastrarGenero("Terror");
			Fachada.cadastrarGenero("Suspense");
			Fachada.cadastrarGenero("Ficcao cientifica");
			Fachada.cadastrarGenero("Romance");
			Fachada.cadastrarGenero("Musical");
			
			Fachada.cadastrarFilme("Spider-Man", 14.90, 2017);
			Fachada.cadastrarFilme("Captain Marvel", 29.90, 2019);
			Fachada.cadastrarFilme("Avengers: Endgame", 39.90, 2019);
			Fachada.cadastrarFilme("X-Men: Apocalypse", 12.50, 2016);
			Fachada.cadastrarFilme("Room", 14.90, 2016);
			
			Fachada.cadastrarCliente("Dynnah Hanna", "eudynnah@gmail.com", "55555-555", "999.999.999-99");
			Fachada.cadastrarCliente("Helena Juliana", "euhelena@gmail.com", "44444-444", "888.888.888-88");
			Fachada.cadastrarCliente("George Gomes", "eugeorge@gmail.com", "33333-333", "777.777.777-77");
			Fachada.cadastrarCliente("Rafael Marinho", "eurafael@gmail.com", "22222-222", "555.555.555-55");
			Fachada.cadastrarCliente("Paulo Henrique", "eupaulo@gmail.com", "11111-111", "333.333.333-33");
		
			Fachada.cadastrarPedido("1", "777.777.777-77", "Spider-Man", "03/08/2019");
			Fachada.cadastrarPedido("2", "888.888.888-88", "Room", "03/08/2019");
			Fachada.cadastrarPedido("3", "999.999.999-99", "Captain Marvel", "03/08/2019");
			Fachada.cadastrarPedido("4", "333.333.333-33", "X-Men: Apocalypse", "03/08/2019");
			Fachada.cadastrarPedido("5", "555.555.555-55", "Avengers: Endgame", "03/08/2019");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		  }
		
		Fachada.finalizar();
		System.out.println("Programa finalizado");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Cadastrar();
	}

}
