package br.com.xpto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.xpto.entitys.Capital;
import br.com.xpto.entitys.Cidade;
import br.com.xpto.entitys.dto.EstadoQuantidadeCidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	Cidade findByName(String nome);
	
	List<Cidade> findByCapitalOrderByNameDesc(Capital string);
	
	@Query("select new br.com.xpto.entitys.dto.EstadoQuantidadeCidade (e.nome, count(*) as contagem) "
			+ "from Cidade c join c.estado e group by e.id order by contagem desc")
	List<EstadoQuantidadeCidade> findEstadoMaiorMenor();
	
	
	Cidade findByIdIbge(Integer codigoIbge);
	
	
	
}
