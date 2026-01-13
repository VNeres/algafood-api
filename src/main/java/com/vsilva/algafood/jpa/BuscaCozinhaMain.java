package com.vsilva.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.vsilva.algafood.AlgafoodApiApplication;
import com.vsilva.algafood.domain.model.Cozinha;
import com.vsilva.algafood.domain.repository.CozinhaRepository;

public class BuscaCozinhaMain {

	// Classe responsável para utilização do JPA sem utilizar Spring Data JPA

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);

		// Retornar cozinha
		Cozinha cozinha = cozinhas.porId(1L);

		System.out.println(cozinha.getNome());

	}

}
