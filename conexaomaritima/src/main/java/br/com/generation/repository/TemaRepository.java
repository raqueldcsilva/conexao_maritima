package br.com.generation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);

	public List<Tema> findAllByNomeTemaContainingIgnoreCase(String nomeTema);

	public List<Tema> findAllByPalavrasChavesContainingIgnoreCase(String palavrasChaves);
}
