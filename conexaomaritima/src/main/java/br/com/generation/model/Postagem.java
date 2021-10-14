package br.com.generation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_postagens")
public class Postagem {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	@NotNull(message = "Aviso! é obrigatório escrever um título")
	@Size(min = 5, max = 100, message = "O título deve ter no mínimo 5 e no máximo 100 caracteres")
	private String titulo;
	
	@NotNull(message = "Aviso! é obrigatório escrever um texto")
	@Size(min = 5, max = 5000, message = "O texto deve ter no mínimo 5 e no máximo 5000 caracteres")
	private String texto;
		
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	private int curtir;
	
	private int participar;
	
	private Date dataEvento;
	
	private String fotoPostagem;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;


	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getCurtir() {
		return this.curtir;
	}

	public void setCurtir(int curtir) {
		this.curtir = curtir;
	}

	public int getParticipar() {
		return this.participar;
	}

	public void setParticipar(int participar) {
		this.participar = participar;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getFotoPostagem() {
		return fotoPostagem;
	}

	public void setFotoPostagem(String fotoPostagem) {
		this.fotoPostagem = fotoPostagem;
	}
		
	
}
