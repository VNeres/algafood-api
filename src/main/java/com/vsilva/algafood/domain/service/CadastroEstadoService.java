package com.vsilva.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.vsilva.algafood.domain.exception.EntidadeEmUsoException;
import com.vsilva.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.vsilva.algafood.domain.model.Estado;
import com.vsilva.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired 
	EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {
		return estadoRepository.adicionar(estado);
	}
	
	public void remover(Long estadoId) {
		
		try {
			estadoRepository.remover(estadoId);
			
		}catch(EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadstro de estado com código %d", estadoId));
		} catch(DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Estado de código %d não pode ser removida, pois está em uso.", estadoId));			
		}
	}
}
