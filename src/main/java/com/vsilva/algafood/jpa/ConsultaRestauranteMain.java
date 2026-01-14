package com.vsilva.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.vsilva.algafood.AlgafoodApiApplication;
import com.vsilva.algafood.domain.model.Restaurante;
import com.vsilva.algafood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

	// Classe responsável para utilização do JPA sem utilizar Spring Data JPA

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);

		// Retornar restaurantes
		List<Restaurante> todosRestaurantes = restaurantes.todos();

		for(Restaurante restaurante : todosRestaurantes) {			
			System.out.printf("%s - %f - %s\n", restaurante.getNome(), restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
		}

	}

}
