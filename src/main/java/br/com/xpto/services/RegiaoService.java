package br.com.xpto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xpto.entitys.Regiao;
import br.com.xpto.repository.RegiaoRepository;

@Service
public class RegiaoService {

	@Autowired
	RegiaoRepository regiaoRepository;

	public Regiao salvar(Regiao regiao) {
		return regiaoRepository.save(regiao);
	}

	public Regiao findByMesoRegionAndMicroRegion(String mesoRegion, String microRegion) {
		return regiaoRepository.findByMesoRegionAndMicroRegion(mesoRegion, microRegion);
	}

}
