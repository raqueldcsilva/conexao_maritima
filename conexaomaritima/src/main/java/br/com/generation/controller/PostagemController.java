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

import br.com.generation.model.Postagem;
import br.com.generation.repository.PostagemRepository;
import br.com.generation.service.PostagemService;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	@Autowired
	private PostagemRepository postagemRepository;

	@Autowired
	private PostagemService postagemService;

	// Consultar todas categorias
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll() {
		return ResponseEntity.ok(postagemRepository.findAll());
	}

	// Consultar Postagem por ID
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable long id) {
		return postagemRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// Consultar Postagem pelo titulo
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	// Consultar Postagem pelo texto
	@GetMapping("/texto/{texto}")
	public ResponseEntity<List<Postagem>> getByTexto(@PathVariable String texto) {
		return ResponseEntity.ok(postagemRepository.findAllByTextoContainingIgnoreCase(texto));
	}

	// Cadastrar nova Postagem
	@PostMapping
	public ResponseEntity<Postagem> postPostagem(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	}

	// Editar Postagem
	@PutMapping
	public ResponseEntity<Postagem> putPostagem(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
	}

	// Deletar Postagem
	@DeleteMapping("/{id}")
	public void deletePostagem(@PathVariable long id) {
		postagemRepository.deleteById(id);
	}

	// curtir
	@PutMapping("/curtir/{id}")
	public ResponseEntity<Postagem> putCurtirPostagemId(@PathVariable Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(postagemService.curtir(id));

	}

	// descurtir
	@PutMapping("/descurtir/{id}")
	public ResponseEntity<Postagem> putDescurtirPostagemId(@PathVariable Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(postagemService.descurtir(id));

	}

	// Participar
	@PutMapping("/participar/{id}")
	public ResponseEntity<Postagem> putParticiparPostagemId(@PathVariable Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(postagemService.participar(id));

	}

}
