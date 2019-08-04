/**********************************

 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Equipe - George Lucas
 * 		  - Dynnah Hanna
 **********************************/

package modelo;

import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.persistence.*;
import org.eclipse.persistence.annotations.Index;

@Entity
public class Genero {
	@Id
	private String nome;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Filme> filmes = new ArrayList<>();
	
	public Genero (){}
	
	public Genero (String nome) {
		this.nome = nome;
	}
	
	public void addFilme (Filme filme) {
		this.filmes.add(filme);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
				" Nome: " + nome +
				", Filmes: [ ";
		for (Filme fe : filmes) {
			texto += fe.getTitulo() + ", ";
		}
		texto += "]";

		return texto;
	}
	
	
	
}
