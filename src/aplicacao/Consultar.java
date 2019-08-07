package aplicacao;

import fachada.Fachada;

public class Consultar {

	public Consultar() {
		Fachada.inicializar();
		System.out.println("Consultando...");

		try {
			Fachada.consultarAtoresPorParteNome("o");
			Fachada.consultarFilmesPorCliente("777.777.777-77");
			Fachada.consultarGeneroPorAtor("Tom Holland");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("Programa finalizado");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Consultar();
	}

}
