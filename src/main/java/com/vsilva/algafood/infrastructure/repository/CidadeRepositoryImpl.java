package com.vsilva.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.vsilva.algafood.domain.model.Cidade;
import com.vsilva.algafood.domain.repository.CidadeRepository;

@Repository
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cidade> todos() {
		TypedQuery<Cidade> query = manager.createQuery("from Cidade", Cidade.class);

		return query.getResultList();
	}

	@Override
	public Cidade porId(Long id) {
		return manager.find(Cidade.class, id);
	}

	@Transactional
	@Override
	public Cidade Adionar(Cidade cidade) {
		return manager.merge(cidade);
	}

	@Transactional
	@Override
	public void remover(Long id) {
		
		Cidade cidade = porId(id);
		
		if(cidade == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(cidade);

	}

}
