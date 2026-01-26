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
//import com.vsilva.algafood.domain.model.FormaPagamento;
//import com.vsilva.algafood.domain.repository.FormaPagamentoRepository;
//
//@Repository
//public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {
//
//	@PersistenceContext
//	private EntityManager manager;
//	
//	@Override
//	public List<FormaPagamento> todos() {
//		TypedQuery<FormaPagamento> query = manager.createQuery("from FormaPagamento", FormaPagamento.class);
//		
//		return query.getResultList();
//	}
//
//	@Override
//	public FormaPagamento porId(Long id) {
//		return manager.find(FormaPagamento.class, id);
//	}
//
//	@Override
//	@Transactional
//	public FormaPagamento adicionar(FormaPagamento formaPagamento) {
//		return manager.merge(formaPagamento);
//	}
//
//	@Override
//	@Transactional
//	public void remover(FormaPagamento formaPagamento) {
//		formaPagamento = porId(formaPagamento.getId());
//		
//		manager.remove(formaPagamento);
//		
//	}
//
//}
