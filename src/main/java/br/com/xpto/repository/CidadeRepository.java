package br.com.xpto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.xpto.entitys.Capital;
import br.com.xpto.entitys.Cidade;
import br.com.xpto.entitys.Estado;
import br.com.xpto.entitys.dto.EstadoQuantidadeCidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	Cidade findByName(String nome);
	
	List<Cidade> findByCapitalOrderByNameDesc(Capital string);
	
	@Query("select new br.com.xpto.entitys.dto.EstadoQuantidadeCidade (e.nome, count(*) as contagem) "
			+ "from Cidade c join c.estado e group by e.id order by contagem desc")
	List<EstadoQuantidadeCidade> findEstadoMaiorMenor();
	
	Cidade findByIdIbge(Integer codigoIbge);
	
	@Query("Select c.name from Cidade c where c.estado.nome = :name")
	List<String> findByEstado(@Param("name") String estado);
	
	Cidade findFirstByOrderByIdIbgeDesc();
	
	Cidade findByNameAndEstado(String nome, Estado estado);
	
	
	
	
}
