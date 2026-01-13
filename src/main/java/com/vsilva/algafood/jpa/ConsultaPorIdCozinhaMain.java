package com.vsilva.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.vsilva.algafood.AlgafoodApiApplication;
import com.vsilva.algafood.domain.model.Cozinha;

public class ConsultaPorIdCozinhaMain {

	// Classe responsável para utilização do JPA sem utilizar Spring Data JPA

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

		// Retornar cozinha
		Cozinha cozinha = cadastroCozinha.buscar(1L);

		System.out.println(cozinha.getNome());

	}

}
