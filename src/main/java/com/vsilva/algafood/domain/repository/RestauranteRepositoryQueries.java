package com.vsilva.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.vsilva.algafood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal);

}