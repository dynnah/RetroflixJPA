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
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.eclipse.persistence.annotations.Index;

@Entity
@Index(name="IND",columnNames={"nacionalidade"})
public class Ator {
	@Id
	private String nome;
	private String dataNasc;
	@Index
	private String nacionalidade;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Filme> filmes = new ArrayList<>();
	
	public Ator (){}
	
	public Ator (String nome, String dataNasc, String nacionalidade) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.nacionalidade = nacionalidade;
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

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
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
				", Data Nascimento: " + dataNasc;
		texto += ", Nacionalidade: " + nacionalidade +
				", Filmes: [ ";
		for (Filme fe : filmes) {
			texto += fe.getTitulo() + ", ";
		}
		texto += "]";

		return texto;
		
	}
	
	
}
