package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.General;

/**
*
* @author Pierre Obregon
* @version 1.0, 19/01/2016
* @since 1.0
*/
@Repository
public interface GeneralRepository extends CrudRepository<General, Integer> {

	@Query(value = "SELECT g FROM General g WHERE g.nbDominio LIKE :domain AND g.stEstado = :estado")	
	public abstract List<General> findByDomainAndState(@Param("domain") String strNbDominio, @Param("estado") String strStEstado);
	
	@Query(value = "SELECT g FROM General g WHERE (g.nbDominio = :domain OR :domain = '-1') ")
	public abstract List<General> findByDomain(@Param("domain") String domain);
	
	@Query(value = "SELECT distinct g.nbDominio FROM General g WHERE g.stEstado = 1")
	public abstract List<String> findAllDomainsActive();

	@Query(value = "SELECT distinct g.nbDominio FROM General g")
	public abstract List<String> findAllDomains();

}
