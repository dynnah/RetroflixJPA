package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Filme;

public class DAOFilme extends DAO<Filme>{

	public Filme read (Object chave){
		try{
			String nome = (String) chave;
			Query q = manager.createQuery("select p from Filme p where p.titulo= '" + nome +"'");
			return (Filme) q.getSingleResult();

		}catch(NoResultException e){
			return null;
		}
	}

	//CONSULTAS

	public static List<Filme> consultarFilmesPorCliente(String cli) {
		List<Filme> filmes;
		Query query = manager.createQuery("SELECT p.filmes from Pedido p JOIN Cliente c ON p.cliente.cpf = c.cpf where c.cpf = '" + cli + "'");
		filmes = query.getResultList();
		return filmes;
	}
}