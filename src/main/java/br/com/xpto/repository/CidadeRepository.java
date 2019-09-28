package br.com.xpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.xpto.entitys.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	public Cidade findByName(String nome);
	
}
