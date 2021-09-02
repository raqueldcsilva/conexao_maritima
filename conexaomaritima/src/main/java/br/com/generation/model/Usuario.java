package br.com.generation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//notblack é comando para não aceitar vazio 
	@NotNull
	@NotBlank(message = "Aviso! é obrigatório um nome")
	@Size(min = 2, max = 255, message = "O nome deve ter no mínimo 2 e no máximo 255 caracteres")
	private String nome;
	
	@NotNull
	@NotBlank(message = "Aviso! é obrigatório um e-mail")
	private String email;
	
	@NotNull
	@NotBlank(message = "Insira sua senha")
	@Size(min = 10, max = 12, message = "A senha deve ter no mínimo 10 e no máximo 12 caracteres")
	private String senha;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
