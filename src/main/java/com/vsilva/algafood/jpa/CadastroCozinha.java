package com.vsilva.algafood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.vsilva.algafood.domain.model.Cozinha;

@Component
public class CadastroCozinha {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Cozinha> listar() {
		//select * from Cozinha
		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
		
		return query.getResultList();
	}
	
	public Cozinha buscar(Long id) {
		// select * from Cozinha where id = id
		return manager.find(Cozinha.class, id);
	}
	
	@Transactional // anotação para fazer com que o método seja executado dentro de uma transação.
	public Cozinha salvar(Cozinha cozinha) {
		// insert into Cozinha (nome) values ('value');
		//or
		// update Cozinha set nome = 'nome' where id = 'id'
		return manager.merge(cozinha);
	}
	
	@Transactional // pra executar dentro de uma transação
	public void remover(Cozinha cozinha) {
		cozinha = buscar(cozinha.getId());
		manager.remove(cozinha);
	}
	
}
