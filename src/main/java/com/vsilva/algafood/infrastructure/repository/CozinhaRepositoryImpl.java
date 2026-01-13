package com.vsilva.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.vsilva.algafood.domain.model.Cozinha;
import com.vsilva.algafood.domain.repository.CozinhaRepository;

public class CozinhaRepositoryImpl implements CozinhaRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cozinha> todas() {
		//select * from Cozinha
		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
		
		return query.getResultList();
	}
	
	@Override
	public Cozinha porId(Long id) {
		// select * from Cozinha where id = id
		return manager.find(Cozinha.class, id);
	}
	
	@Transactional // anotação para fazer com que o método seja executado dentro de uma transação.
	@Override
	public Cozinha adicionar(Cozinha cozinha) {
		// insert into Cozinha (nome) values ('value');
		//or
		// update Cozinha set nome = 'nome' where id = 'id'
		return manager.merge(cozinha);
	}
	
	@Transactional // pra executar dentro de uma transação
	@Override
	public void remover(Cozinha cozinha) {
		cozinha = porId(cozinha.getId());
		manager.remove(cozinha);
	}

}
