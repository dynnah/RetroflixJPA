/**********************************

 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Equipe - George Lucas
 * 		  - Dynnah Hanna
 **********************************/

package modelo;

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
import org.eclipse.persistence.annotations.Index;

@Entity
@Index(name="IND",columnNames={"lancamento"})
public class Filme {
	
	@Id
	private String titulo;
	private double preco;
	@Index
	private int lancamento;
	
	@ManyToMany(mappedBy="filmes", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Pedido> pedidos = new ArrayList<>();
	
	@ManyToMany(mappedBy="filmes", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Genero> generos = new ArrayList<>();
	
	@ManyToMany(mappedBy="filmes", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Ator> atores = new ArrayList<>();
	
	public Filme (){}
	
	public Filme (String titulo, double preco, int lancamento) {
		this.titulo = titulo;
		this.preco = preco;
		this.lancamento = lancamento;
	}
	
	public void addPedido (Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	public void addGenero (Genero genero) {
		this.generos.add(genero);
	}
	
	public void addAtor (Ator ator) {
		this.atores.add(ator);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getLancamento() {
		return lancamento;
	}

	public void setLancamento(int lancamento) {
		this.lancamento = lancamento;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(ArrayList<Genero> generos) {
		this.generos = generos;
	}

	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(ArrayList<Ator> atores) {
		this.atores = atores;
	}

	@Override
	public String toString() {
		String classe = getClass().getSimpleName() + "=";
		String texto =  String.format("%10s", classe)  + 
				" Titulo: " + titulo + 
				", Preco: " + preco +
				", Lancamento: " + lancamento +
				", Pedidos: [ ";
				for (Pedido pe : pedidos) {
					texto += pe.getCodPedido() + ", ";
				}
				texto += "], Generos: [ ";
				for (Genero ge : generos) {
					texto += ge.getNome() + ", ";
				}
				texto += "], Atores: [ ";
				for (Ator at : atores) {
					texto += at.getNome() + ", ";
				}
				texto += "]";

		return texto;
	}
	
	
	
	
}
