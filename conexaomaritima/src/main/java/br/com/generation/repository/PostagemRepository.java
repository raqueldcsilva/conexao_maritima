package br.com.generation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generation.model.Postagem;


public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	
	public List <Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	public List <Postagem> findAllByTextoContainingIgnoreCase(String texto);

}
