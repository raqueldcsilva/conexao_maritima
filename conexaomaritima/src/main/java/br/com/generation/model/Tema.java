package br.com.generation.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_temas")
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Aviso! é obrigatório escrever uma descrição")
	@Size(min = 3, max = 1000, message = "A descrição deve ter no mínimo 3 e no máximo 1000 caracteres")
	private String descricao;

	@NotBlank(message = "Aviso! é obrigatório escrever um tema")
	@Size(min = 2, max = 100, message = "O tema deve ter no mínimo 2 e no máximo 1000 caracteres")
	private String nomeTema;

	@NotBlank(message = "Insira as palavras chaves")
	private String palavrasChaves;

	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeTema() {
		return this.nomeTema;
	}

	public void setNomeTema(String nomeTema) {
		this.nomeTema = nomeTema;
	}

	public String getPalavrasChaves() {
		return this.palavrasChaves;
	}

	public void setPalavrasChaves(String palavrasChaves) {
		this.palavrasChaves = palavrasChaves;
	}

	public List<Postagem> getPostagem() {
		return this.postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

}
