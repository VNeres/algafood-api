package com.vsilva.algafood.domain.repository;

import java.util.List;

import com.vsilva.algafood.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> todos();

	Permissao porId(Long id);

	Permissao adicionar(Permissao permissao);

	void remover(Permissao permissao);

}
