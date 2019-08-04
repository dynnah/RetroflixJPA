package daojpa;


import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Cliente;

public class DAOCliente extends DAO<Cliente>{

	public Cliente read (Object chave){
		try{
			String cpf = (String) chave;
			Query q = manager.createQuery("select p from Cliente p where p.cpf= '" + cpf +"'");
			return (Cliente) q.getSingleResult();

		}catch(NoResultException e){
			return null;
		}
	}
	
}