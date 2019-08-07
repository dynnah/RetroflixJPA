package daojpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Pedido;

public class DAOPedido extends DAO<Pedido>{
	public Pedido read (Object chave){
		try{
			String nome = (String) chave;
			Query q = manager.createQuery("select p from Pedido p where p.codPedido= '" + nome +"'");
			return (Pedido) q.getSingleResult();

		}catch(NoResultException e){
			return null;
		}
	}
	
	//CONSULTAS
	
	public static Double consultarTotalCliente(String cli) {
		Double total;
		Query query = manager.createQuery("Select SUM(p.filmes.preco) FROM Pedido p where p.cliente.cpf = '" + cli + "'");
		total = (Double) query.getSingleResult();
		return total;
	}
}