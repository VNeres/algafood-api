//package com.vsilva.algafood.infrastructure.repository;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;
//
//import com.vsilva.algafood.domain.model.Restaurante;
//import com.vsilva.algafood.domain.repository.RestauranteRepository;
//
//@Repository
//public class RestauranteRepositoryImpl implements RestauranteRepository {
//
//	@PersistenceContext
//	private EntityManager manager;
//	
//	@Override
//	public List<Restaurante> todos() {
//		TypedQuery<Restaurante> query = manager.createQuery("from Restaurante", Restaurante.class);
//		
//		return query.getResultList();
//	}
//
//	@Override
//	public Restaurante porId(Long id) {
//		
//		return manager.find(Restaurante.class, id);
//	}
//
//	@Transactional
//	@Override
//	public Restaurante adicionar(Restaurante restaurante) {
//		
//		return manager.merge(restaurante);
//	}
//
//	@Transactional
//	@Override
//	public void remover(Restaurante restaurante) {
//		
//		restaurante = porId(restaurante.getId());
//		manager.merge(restaurante);
//		
//	}
//
//}
