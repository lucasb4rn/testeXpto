package br.com.xpto.services;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xpto.entitys.Capital;
import br.com.xpto.entitys.Cidade;
import br.com.xpto.entitys.dto.EstadoQuantidadeCidade;
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
	
	
	public List<EstadoQuantidadeCidade> findEstadoMaiorEMenor() {
		 List<EstadoQuantidadeCidade> maiorMenor = cidadeRepository.findEstadoMaiorMenor();
		 
		 return Arrays.asList(
				 maiorMenor.stream()
				.max(Comparator.comparingLong(EstadoQuantidadeCidade::getQuantidadeDeCidades))
				.map(e -> e).get(),
				 maiorMenor.stream()
				.min(Comparator.comparingLong(EstadoQuantidadeCidade::getQuantidadeDeCidades))
				.map(e -> e).get());
	}
	
	
	public List<EstadoQuantidadeCidade> findCidadeEstado() {
		return cidadeRepository.findEstadoMaiorMenor();
	}
	
	public Cidade findByIdIbge(Integer codigoIbge) {
		return cidadeRepository.findByIdIbge(codigoIbge);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
