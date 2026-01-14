package com.vsilva.algafood.domain.repository;

import java.util.List;

import com.vsilva.algafood.domain.model.Cidade;

public interface CidadeRepository {

	List<Cidade> todos();

	Cidade porId(Long id);

	Cidade Adionar(Cidade cidade);

	void remover(Cidade cidade);

}
