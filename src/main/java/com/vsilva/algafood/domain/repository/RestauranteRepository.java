package com.vsilva.algafood.domain.repository;

import java.util.List;

import com.vsilva.algafood.domain.model.Restaurante;

public interface RestauranteRepository {

	List<Restaurante> todos();

	Restaurante porId(Long id);

	Restaurante adicionar(Restaurante restaurante);

	void remover(Restaurante restaurante);
}
