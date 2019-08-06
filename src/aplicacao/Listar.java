package aplicacao;

import fachada.Fachada;

public class Listar {
	
	public Listar() {
		Fachada.inicializar();
		System.out.println("Listando...");
		
		try {
			Fachada.openManager();
			System.out.println(Fachada.listarAtores());
			System.out.println(Fachada.listarGeneros());
			System.out.println(Fachada.listarFilmes());
			System.out.println(Fachada.listarPedidos());
			System.out.println(Fachada.listarClientes());
			Fachada.closeManager();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		  }
		
		Fachada.finalizar();
		System.out.println("Programa finalizado");
	}
}