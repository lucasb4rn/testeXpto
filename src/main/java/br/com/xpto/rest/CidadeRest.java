package br.com.xpto.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	
	

}
