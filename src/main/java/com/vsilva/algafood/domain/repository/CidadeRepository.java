package com.vsilva.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsilva.algafood.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
}
