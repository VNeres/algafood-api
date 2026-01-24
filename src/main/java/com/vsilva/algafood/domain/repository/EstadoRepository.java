package com.vsilva.algafood.domain.repository;

import java.util.List;

import com.vsilva.algafood.domain.model.Estado;

public interface EstadoRepository {

	List<Estado> todos();

	Estado porId(Long id);

	Estado adicionar(Estado estado);

	void remover(Long id);

}
