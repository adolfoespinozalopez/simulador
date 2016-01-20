package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.General;

@Repository
public interface GeneralRepository extends CrudRepository<General, Integer> {

	@Query(value = "SELECT * FROM BBVATESOR.TSI005_GENERAL WHERE NB_DOMINIO = ?1 AND ST_ESTADO = ?2", nativeQuery = true)
	public abstract List<General> findByDomainAndState(String strNbDominio,
			String strStEstado);
	
	@Query(value = "SELECT * FROM BBVATESOR.TSI005_GENERAL WHERE '-1' = ?1 OR ST_ESTADO = ?1", nativeQuery = true)
	public List<General> findByDomain(String domain);
	
	@Query(value = "SELECT distinct(NB_DOMINIO) NB_DOMINIO FROM BBVATESOR.TSI005_GENERAL WHERE ST_ESTADO = 1", nativeQuery = true)
	public List<String> findAllDomainsActive();

}
