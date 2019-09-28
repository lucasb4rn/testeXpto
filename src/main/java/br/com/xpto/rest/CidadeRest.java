package br.com.xpto.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.xpto.entitys.Capital;
import br.com.xpto.entitys.Cidade;
import br.com.xpto.services.CidadeService;

@RestController
public class CidadeRest {
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(value = "cidadeCapitaisOrdenadosPorNome", method = RequestMethod.GET)
	public List<Cidade> cidadePorNomeOrdenado() {
		return cidadeService.getCidadeCapitalOrdemByName(Capital.SIM);
	}

	

}
