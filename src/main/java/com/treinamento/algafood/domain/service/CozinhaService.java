package com.treinamento.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.treinamento.algafood.domain.exception.EntidadeEmUsoException;
import com.treinamento.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.treinamento.algafood.domain.model.Cozinha;
import com.treinamento.algafood.domain.repository.CozinhaRepository;

@Service
public class CozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}

	public void excluir(Long cozinhaId) {
		try {

			if (!cozinhaRepository.existsById(cozinhaId)) {
				throw new EntidadeNaoEncontradaException(
						String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
			}
			cozinhaRepository.deleteById(cozinhaId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId));
		}
	}
}
