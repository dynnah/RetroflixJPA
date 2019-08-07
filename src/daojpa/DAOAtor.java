package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Ator;

public class DAOAtor extends DAO<Ator>{
	public Ator read (Object chave){
		try{
			String nome = (String) chave;
			Query q = manager.createQuery("select p from Ator p where p.nome= '" + nome +"'");
			return (Ator) q.getSingleResult();

		}catch(NoResultException e){
			return null;
		}
	}
	// Consulta
	public static List<Ator> consultarAtoresPorParteNome(String caracteres) {
		List<Ator> atores;
		Query query = manager.createQuery("SELECT a FROM Ator a where a.nome LIKE '%" + caracteres + "%'");
		atores = query.getResultList();
		return atores;
	}
}