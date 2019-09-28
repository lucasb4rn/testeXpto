package br.com.xpto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xpto.entitys.Capital;
import br.com.xpto.entitys.Cidade;
import br.com.xpto.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository cidadeRepository;

	public Cidade salvar(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	public Cidade findByName(String nome) {
		return cidadeRepository.findByName(nome);

	}

	public List<Cidade> getCidadeCapitalOrdemByName(Capital capital) {
		return cidadeRepository.findByCapitalOrderByNameDesc(capital);

	}

}
