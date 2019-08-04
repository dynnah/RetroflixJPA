package daojpa;


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
}