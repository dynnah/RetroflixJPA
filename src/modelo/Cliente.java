/**********************************

 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Equipe - George Lucas
 * 		  - Dynnah Hanna
 **********************************/

package modelo;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.eclipse.persistence.annotations.Index;

@Entity
@Index(name="IND",columnNames={"nome"})
public class Cliente {
	
	@Index
	private String nome;
	private String email;
	private String cep;
	@Id
	private String cpf;
	
	//Relacionamento bidirecional
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	private List<Pedido> pedidos = new ArrayList<>();
	
	//Construtor vazio
	public Cliente () {}
	
	public Cliente (String nome, String email, String cep2, String cpf2) {
		this.nome = nome;
		this.email = email;
		this.cep = cep2;
		this.cpf = cpf2;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void addPedido (Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	@Override
	public String toString() {
		String classe = getClass().getSimpleName() + "=";
		String texto =  String.format("%10s", classe)  + 
				" Nome: " + nome + 
				", Email: " + email +
				", CEP: " + cep +
				", CPF: " + cpf +
				", Pedidos: [ ";
				for (Pedido pe : pedidos) {
					texto += pe.getCodPedido() + ", ";
				}
				texto += "]";

		return texto;
	}
}
