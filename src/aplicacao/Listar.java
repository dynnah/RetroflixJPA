package aplicacao;

import fachada.Fachada;

public class Listar {

	public Listar() {
		Fachada.inicializar();
		System.out.println("Listando...");

		try {
			System.out.println(Fachada.listarAtores());
			System.out.println(Fachada.listarGeneros());
			System.out.println(Fachada.listarFilmes());
			System.out.println(Fachada.listarPedidos());
			System.out.println(Fachada.listarClientes());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("Programa finalizado");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Listar();
	}

}