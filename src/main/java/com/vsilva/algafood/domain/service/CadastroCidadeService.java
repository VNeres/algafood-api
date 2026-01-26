package com.vsilva.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.vsilva.algafood.domain.exception.EntidadeEmUsoException;
import com.vsilva.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.vsilva.algafood.domain.model.Cidade;
import com.vsilva.algafood.domain.model.Estado;
import com.vsilva.algafood.domain.repository.CidadeRepository;
import com.vsilva.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.findById(estadoId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("Não existe cadastro de estado com códigp %d", estadoId)));

		cidade.setEstado(estado);

		return cidadeRepository.save(cidade);
	}

	public void excluir(Long cidadeId) {
		try {

			if (!cidadeRepository.existsById(cidadeId)) {
				throw new EntidadeNaoEncontradaException(
						String.format("Não existe um cadastro de cidade com código %d", cidadeId));
			}

			cidadeRepository.deleteById(cidadeId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cidade com código %d não pode ser removida, pois está em uso", cidadeId));
		}

	}
}
