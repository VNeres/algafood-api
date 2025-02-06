package com.treinamento.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.treinamento.algafood.domain.model.Cozinha;
import com.treinamento.algafood.domain.model.Restaurante;
import com.treinamento.algafood.domain.repository.CozinhaRepository;
import com.treinamento.algafood.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {

	@Autowired
	RestauranteRepository restauranteRepository;

	@Autowired
	CozinhaRepository cozinhaRepository;

	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com código %d", cozinhaId)));

		restaurante.setCozinha(cozinha);

		return restauranteRepository.save(restaurante);
	}

}
