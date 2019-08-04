/**********************************

 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Equipe - George Lucas
 * 		  - Dynnah Hanna
 **********************************/

package modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import org.eclipse.persistence.annotations.Index;

@Entity
@Index(name="IND",columnNames={"statusPagamento"})
public class Pedido {
	@Id
	private String codPedido;
	@Index
	private String statusPagamento;
	private String dataPedido;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Filme> filmes = new ArrayList<>();
	
	public Pedido (){}
	
	public Pedido (String codP, Cliente cli, Filme filme, String dataPed) {
		this.codPedido = codP;
		this.cliente = cli;
		this.statusPagamento = "PENDENTE";
		this.dataPedido = dataPed;
		filmes.add(filme);
	}
	
	public void addFilmePed (Filme filme) {
		this.filmes.add(filme);
	}

	public String getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(String codPedido) {
		this.codPedido = codPedido;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente (Cliente cli) {
		this.cliente = cli;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(ArrayList<Filme> filmes) {
		this.filmes = filmes;
	}

	@Override
	public String toString() {
		String classe = getClass().getSimpleName() + "=";
		String texto =  String.format("%10s", classe)  + 
				" C�digo: " + codPedido;
				if(this.cliente != null) {
				texto += " Cliente: " + cliente.getNome();
				}else {
					texto += " Cliente: Cliente Anonimo";
				}
				texto += " Status de Pagamento: " + statusPagamento +
				", Data do Pedido: " + dataPedido +
				", Filmes: [ ";
				for (Filme fi : filmes) {
					texto += fi.getTitulo() + ", ";
				}
				texto += "]";

		return texto;
	}
	
	
	
}
