package br.com.xpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.xpto.entitys.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Integer>{
	
	Regiao findByMesoRegionAndMicroRegion(String mesoRegion, String microRegion);

}
