package daojpa;

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
}