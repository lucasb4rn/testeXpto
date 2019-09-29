package br.com.xpto.services;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
				maiorMenor.stream().max(Comparator.comparingLong(EstadoQuantidadeCidade::getQuantidadeDeCidades))
						.map(e -> e).get(),
				maiorMenor.stream().min(Comparator.comparingLong(EstadoQuantidadeCidade::getQuantidadeDeCidades))
						.map(e -> e).get());
	}

	public List<EstadoQuantidadeCidade> findCidadeEstado() {
		return cidadeRepository.findEstadoMaiorMenor();
	}

	public Cidade findByIdIbge(Integer codigoIbge) {
		return cidadeRepository.findByIdIbge(codigoIbge);
	}

	public List<String> findByEstado(String estado) {
		return cidadeRepository.findByEstado(estado);
	}

	public Cidade adicionarCidade(Cidade cidade) {

		Cidade c = cidadeRepository.findByNameAndEstado(cidade.getName(), cidade.getEstado());
		if (c != null)
			throw new IllegalArgumentException("Já existe cidade");
		Integer idIbge = cidadeRepository.findFirstByOrderByIdIbgeDesc().getIdIbge();
		cidade.setIdIbge(++idIbge);
		return cidadeRepository.save(cidade);
	}

	@Transactional
	public void deleteCidade(Integer idIbge) {
		cidadeRepository.delete(idIbge);
	}

	public List<Cidade> getColunaPorConteudo(String coluna, String conteudo) {

		Set<Integer> listaFiltrada = new HashSet<Integer>();

		List<Cidade> todasCidades = cidadeRepository.findAll();

		for (Cidade cidade : todasCidades) {

			String retonaCampo = retonaCampo(cidade, coluna);

			if (retonaCampo.toLowerCase().equals(conteudo.toLowerCase())) {
				listaFiltrada.add(cidade.getIdIbge());
			}

		}

		return cidadeRepository.findAll(listaFiltrada);
	}

	private String retonaCampo(Cidade cidade, String coluna) {

		switch (coluna) {

		case "ibge_id":
			return cidade.getIdIbge() != null ? cidade.getIdIbge().toString() : "";
		case "uf":
			return cidade.getEstado() != null ? cidade.getEstado().getNome() : "";
		case "name":
			return cidade.getName();
		case "capital":
			return cidade.getCapital() != null ? cidade.getCapital().toString() : "";
		case "lon":
			return "" + cidade.getLongitude();
		case "lat":
			return "" + cidade.getLatitude();
		case "alternative_names":
			return cidade.getNomeSecundario();
		case "microregion":
			return cidade.getRegiao() != null ? cidade.getRegiao().getMicroRegion() : "";
		case "mesoregion":
			return cidade.getRegiao() != null ? cidade.getRegiao().getMesoRegion() : "";
		default:
			return "";
		}
	}

	public Long getQuantidadeRegistrosPorColuna(String coluna) {

		List<Cidade> todasCidades = cidadeRepository.findAll();
		Map<Integer, String> mapColuna = new HashMap<Integer, String>();

		for (Cidade cidade : todasCidades) {
			mapColuna.put(cidade.getIdIbge(), retonaCampo(cidade, coluna));
		}
		
		return mapColuna.values().stream().distinct().count();

	}

	public Long geQuantidadeTotalRegistros() {
		return cidadeRepository.count();
	};
	

}
