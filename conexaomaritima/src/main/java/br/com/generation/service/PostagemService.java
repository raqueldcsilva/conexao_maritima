package br.com.generation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.generation.model.Postagem;
import br.com.generation.repository.PostagemRepository;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository postagemRepository;

	/**
	 * Método Curtir -> Soma 1 ao atributo curtidos
	 */
	public Postagem curtir(Long id) {

		Postagem postagem = buscarPostagemPeloId(id);

		postagem.setCurtir(postagem.getCurtir() + 1);

		return postagemRepository.save(postagem);

	}

	/**
	 * Método Descurtir -> Subtrai 1 do atributo curtidos enquanto for maior do que
	 * zero. Se for igual a zero, mantém o zero
	 */
	public Postagem descurtir(Long id) {

		Postagem postagem = buscarPostagemPeloId(id);

		if (postagem.getCurtir() > 0) {

			postagem.setCurtir(postagem.getCurtir() - 1);

		} else {

			postagem.setCurtir(0);

		}

		return postagemRepository.save(postagem);

	}

	// método participar do evento
	public Postagem participar(Long id) {

		Postagem postagem = buscarPostagemPeloId(id);

		postagem.setParticipar(postagem.getParticipar() + 1);

		return postagemRepository.save(postagem);

	}

	/**
	 * Método buscarProdutoPeloId -> Implmenta o método findById checando se o
	 * produto existe.
	 */
	private Postagem buscarPostagemPeloId(Long id) {

		Postagem postagemSalvo = postagemRepository.findById(id).orElse(null);

		if (postagemSalvo == null) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Postagem não encontrada!", null);
		}

		return postagemSalvo;
	}

}
