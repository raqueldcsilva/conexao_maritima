package br.com.generation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_temas")
public class Tema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//notblack é comando para não aceitar vazio
	@NotNull
	@NotBlank(message = "Aviso! é obrigatório escrever uma descrição")
	private String descricao;
	
	@NotNull
	@NotBlank(message = "Aviso! é obrigatório escrever um tema")
	private String tema;
	
	@NotNull
	@NotBlank(message = "Insira as palavras chaves")
	private String palavrasChaves;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getPalavrasChaves() {
		return palavrasChaves;
	}

	public void setPalavrasChaves(String palavrasChaves) {
		this.palavrasChaves = palavrasChaves;
	}

}
