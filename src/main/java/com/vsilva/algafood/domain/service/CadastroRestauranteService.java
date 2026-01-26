package com.vsilva.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.vsilva.algafood.domain.exception.EntidadeEmUsoException;
import com.vsilva.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.vsilva.algafood.domain.model.Cozinha;
import com.vsilva.algafood.domain.model.Restaurante;
import com.vsilva.algafood.domain.repository.CozinhaRepository;
import com.vsilva.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	RestauranteRepository restauranteRepository;

	@Autowired
	CozinhaRepository cozinhaRepository;

	public Restaurante salvar(Restaurante restaurante) {

		Long cozinhaId = restaurante.getCozinha().getId();

		Cozinha cozinha = cozinhaRepository.findById(cozinhaId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("Não existe cadastro de cozinha com código %d", cozinhaId)));

		restaurante.setCozinha(cozinha);

		return restauranteRepository.save(restaurante);
	}
	
	public void remover(Long estadoId) {

		try {
			if (!restauranteRepository.existsById(estadoId)) {
				throw new EntidadeNaoEncontradaException(
						String.format("Não existe um cadstro de estado com código %d", estadoId));
			}
			
			restauranteRepository.deleteById(estadoId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Estado de código %d não pode ser removida, pois está em uso.", estadoId));
		}
	}
}
