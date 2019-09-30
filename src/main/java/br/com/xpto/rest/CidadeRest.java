package br.com.xpto.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.xpto.entitys.Capital;
import br.com.xpto.entitys.Cidade;
import br.com.xpto.entitys.dto.EstadoQuantidadeCidade;
import br.com.xpto.services.CidadeService;

@RestController
public class CidadeRest {

	@Autowired
	private CidadeService cidadeService;

	@RequestMapping(value = "cidadeCapitaisOrdenadosPorNome", method = RequestMethod.GET)
	public List<Cidade> cidadePorNomeOrdenado() {
		return cidadeService.getCidadeCapitalOrdemByName(Capital.SIM);
	}

	@RequestMapping(value = "estadoMaiorEMenor", method = RequestMethod.GET)
	public List<EstadoQuantidadeCidade> getEstadoMaiorMenor() {
		return cidadeService.findEstadoMaiorEMenor();
	}

	@RequestMapping(value = "quantidadeCidadePorEstado", method = RequestMethod.GET)
	public List<EstadoQuantidadeCidade> geQuantidadeCidadePorEstado() {
		return cidadeService.findCidadeEstado();
	}

	@RequestMapping(value = "cidade/{idIbge}", method = RequestMethod.GET)
	public Cidade getCidade(@PathVariable(value = "idIbge") Integer codigoIbge) {
		return cidadeService.findByIdIbge(codigoIbge);
	}

	@RequestMapping(value = "retornaCidadePoroEstado/{estado}", method = RequestMethod.GET)
	public List<String> getCidadePorEstado(@PathVariable(value = "estado") String estado) {
		return cidadeService.findByEstado(estado);
	}

	@RequestMapping(value = "adicionarCidade", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cidade addCidade(@RequestBody Cidade cidade) {
		return cidadeService.adicionarCidade(cidade);
	}

	@RequestMapping(value = "deletaCidade/{idIbge}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteCidade(@PathVariable(value = "idIbge") Integer idIbge) {
		cidadeService.deleteCidade(idIbge);
	}

	@RequestMapping(value = "cidade/{coluna}/{conteudo}", method = RequestMethod.GET)
	public List<Cidade> getCidadePorColunaAndConteudo(@PathVariable(value = "coluna") String coluna,
			@PathVariable(value = "conteudo") String conteudo) {
		return cidadeService.getColunaPorConteudo(coluna, conteudo);
	}

	@RequestMapping(value = "quantidadeColuna/{coluna}", method = RequestMethod.GET)
	public Long getQuantidadeRegistrosPorColuna(@PathVariable(value = "coluna") String coluna) {
		return cidadeService.getQuantidadeRegistrosPorColuna(coluna);
	}

	@RequestMapping(value = "quantidadeTotalRegistros", method = RequestMethod.GET)
	public Long geQuantidadeTotalRegistros() {
		return cidadeService.geQuantidadeTotalRegistros();
	}

	@RequestMapping(value = "maiorDistanciaEntreDuasCidades", method = RequestMethod.GET)
	public List<Cidade> getCidadesMaisDistantes() {
		return cidadeService.getCidadesMaisDistantes();
	}

}
