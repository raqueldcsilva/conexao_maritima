package br.com.generation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.model.Tema;
import br.com.generation.repository.TemaRepository;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

	@Autowired
	private TemaRepository temaRepository;

	// Consultar todas categorias
	@GetMapping
	public ResponseEntity<List<Tema>> getAll() {
		return ResponseEntity.ok(temaRepository.findAll());
	}

	// Consultar Tema por ID
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable long id) {
		return temaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// Consultar Tema pela descrição
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Tema>> getByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(temaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	// Consultar Tema pelo nomeTema
	@GetMapping("/nomeTema/{nomeTema}")
	public ResponseEntity<List<Tema>> getBynomeTema(@PathVariable String nomeTema) {
		return ResponseEntity.ok(temaRepository.findAllByNomeTemaContainingIgnoreCase(nomeTema));
	}

	// Consultar Tema pela palavrasChaves
	@GetMapping("/palavrasChaves/{palavrasChaves}")
	public ResponseEntity<List<Tema>> getByPalavrasChaves(@PathVariable String palavrasChaves) {
		return ResponseEntity.ok(temaRepository.findAllByPalavrasChavesContainingIgnoreCase(palavrasChaves));
	}

	// Cadastrar novo Tema
	@PostMapping
	public ResponseEntity<Tema> postTema(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
	}

	// Editar Tema
	@PutMapping
	public ResponseEntity<Tema> putTema(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.OK).body(temaRepository.save(tema));
	}

	// Deletar Tema
	@DeleteMapping("/{id}")
	public void deleteTema(@PathVariable long id) {
		temaRepository.deleteById(id);
	}

}
