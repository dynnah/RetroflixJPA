package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Genero;

public class DAOGenero extends DAO<Genero>{

	public Genero read (Object chave){
		try{
			String nome = (String) chave;
			Query q = manager.createQuery("select p from Genero p where p.nome= '" + nome +"'");
			return (Genero) q.getSingleResult();

		}catch(NoResultException e){
			return null;
		}
	}
	
	//GENEROS
	
	public static List<Genero> consultarGeneroPorAtor(String nome) {
		List<Genero> generos;
		Query query = manager.createQuery("SELECT f.generos from Filme f JOIN Ator a ON f.atores.nome = a.nome where a.nome = '" + nome + "'");
		generos = query.getResultList();
		return generos;
	}
}