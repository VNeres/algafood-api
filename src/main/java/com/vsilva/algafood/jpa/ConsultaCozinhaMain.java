package com.vsilva.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.vsilva.algafood.AlgafoodApiApplication;
import com.vsilva.algafood.domain.model.Cozinha;
import com.vsilva.algafood.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {
	
	//Classe responsável para utilização do JPA sem utilizar Spring Data JPA 

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
		
		// Retornar cozinha
		List<Cozinha> todasCozinhas = cozinhas.findAll();
		
		for(Cozinha cozinha : todasCozinhas) {
			System.out.println(cozinha.getNome());
		}
	}

}
