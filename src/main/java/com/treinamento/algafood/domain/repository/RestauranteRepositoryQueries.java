package com.treinamento.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.treinamento.algafood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}