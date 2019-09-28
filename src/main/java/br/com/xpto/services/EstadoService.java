package br.com.xpto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xpto.entitys.Estado;
import br.com.xpto.repository.EstadoRepositoy;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepositoy estadoRepository;

	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}

	public Estado findByName(String nome) {
		return estadoRepository.findByNome(nome);
	}

}
