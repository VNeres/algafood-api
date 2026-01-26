package com.vsilva.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsilva.algafood.domain.model.Cozinha;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{
	
	//List<Cozinha> porNome(String nome);

}
