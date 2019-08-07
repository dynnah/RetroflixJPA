package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Filme;
import modelo.Genero;

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

	//CONSULTA

	public static List<Filme> consultarFilmesPorCliente(String cli) {
		List<Filme> filmes;
		Query query = manager.createQuery("SELECT f from Filme f JOIN f.pedidos p JOIN p.cliente c where c.cpf = '" + cli + "'");
		filmes = query.getResultList();
		return filmes;
	}
	
	public static List<Genero> consultarGeneroPorAtor(String nome) {
		List<Genero> generos;
		Query query = manager.createQuery("SELECT f.generos from Filme f JOIN f.atores a where a.nome = '" + nome + "'");
		generos = query.getResultList();
		return generos;
	}
}