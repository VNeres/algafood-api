package com.vsilva.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.vsilva.algafood.domain.model.Estado;
import com.vsilva.algafood.domain.repository.EstadoRepository;

@Repository
public class EstadoRepositoryImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Estado> todos() {
		TypedQuery<Estado> query = manager.createQuery("from Estado", Estado.class);

		return query.getResultList();
	}

	@Override
	public Estado porId(Long id) {
		return manager.find(Estado.class, id);
	}

	@Override
	@Transactional
	public Estado adicionar(Estado estado) {
		return manager.merge(estado);
	}

	@Override
	@Transactional
	public void remover(Estado estado) {
		estado = porId(estado.getId());
		manager.remove(estado);

	}

}
