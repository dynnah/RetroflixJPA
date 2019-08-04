package daojpa;

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
}