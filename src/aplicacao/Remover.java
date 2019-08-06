package aplicacao;

import fachada.Fachada;

public class Remover {

	public Remover() {
		Fachada.inicializar();
		System.out.println("Removendo...");

		try {
			Fachada.openManager();
			Fachada.excluirCliente("333.333.333-33");
			Fachada.excluirCliente("555.555.555-55");
			Fachada.closeManager();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("Programa finalizado");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Remover();
	}
}