package com.vsilva.algafood.api.controller;

import static com.vsilva.algafood.infrastructure.repository.spec.RestaurantesSpecs.comFreteGratis;
import static com.vsilva.algafood.infrastructure.repository.spec.RestaurantesSpecs.comNomeSemelhante;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vsilva.algafood.domain.model.Cozinha;
import com.vsilva.algafood.domain.model.Restaurante;
import com.vsilva.algafood.domain.repository.CozinhaRepository;
import com.vsilva.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	CozinhaRepository cozinhaRepository;

	@Autowired
	RestauranteRepository restauranteRepository;

	@GetMapping("/cozinha/por-nome")
	public List<Cozinha> buscarPorNome(@RequestParam String nome) {
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}

	@GetMapping("/cozinha/unica-por-nome")
	public Optional<Cozinha> buscarUnicaPorNome(@RequestParam String nome) {
		return cozinhaRepository.findByNome(nome);
	}

	@GetMapping("/restaurante/por-taxa-frete")
	public List<Restaurante> buscarEntreTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
	}

	@GetMapping("/restaurante/por-nome-cozinha-id")
	public List<Restaurante> buscarPorNomeCozinhaId(String nome, Long cozinhaId) {
		return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
	}

	@GetMapping("/restaurante/por-nome-query")
	public List<Restaurante> buscarPorNomeQuery(String nome, Long cozinhaId) {
		return restauranteRepository.buscarPorNome(nome, cozinhaId);
	}

	@GetMapping("/restaurante/por-primeiro-nome")
	public Optional<Restaurante> buscarPrimeiroPorNome(String nome) {
		return restauranteRepository.findFirstByNomeContaining(nome);
	}

	@GetMapping("/restaurante/por-top2-nome")
	public List<Restaurante> buscarPorTop2Nome(String nome) {
		return restauranteRepository.findTop2ByNomeContaining(nome);
	}

	@GetMapping("/cozinha/exists-nome")
	public boolean verificarExisteNome(String nome) {
		return cozinhaRepository.existsByNome(nome);
	}

	@GetMapping("/restaurante/exists-por-cozinha")
	public int countPorCozinhaId(Long cozinhaId) {
		return restauranteRepository.countByCozinhaId(cozinhaId);
	}

	@GetMapping("/restaurante/por-nome-e-frete")
	public List<Restaurante> restaurantesPorNomeEFrete(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.find(nome, taxaInicial, taxaFinal);
	}

	@GetMapping("/restaurante/com-frete-gratis")
	public List<Restaurante> restaurantesComFreteGratis(String nome) {

		return restauranteRepository.findAll(comFreteGratis().and(comNomeSemelhante(nome)));
	}
}
