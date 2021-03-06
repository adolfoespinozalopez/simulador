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

	@Query(value = "SELECT g FROM General g WHERE g.nbDominio = :domain AND g.stEstado = :estado ORDER BY g.nbDescGeneral")	
	public abstract List<General> findByDomainAndState(@Param("domain") String strNbDominio, @Param("estado") String strStEstado);
	
	@Query(value = "SELECT g FROM General g WHERE (g.nbDominio = :domain OR :domain = '-1') AND ( g.fgEditable = :flagEdit OR :flagEdit = '-1' ) ORDER BY g.nbDominio, g.stEstado DESC")
	public abstract List<General> findByDomain(@Param("domain") String domain, @Param("flagEdit") String flagEdit);
	
	@Query(value = "SELECT distinct g.nbDominio FROM General g WHERE g.stEstado = 1 AND g.fgEditable = 1 ORDER BY g.nbDominio")
	public abstract List<String> findAllDomainsActive();

	@Query(value = "SELECT distinct g.nbDominio FROM General g WHERE g.fgEditable = 1 ORDER BY g.nbDominio")
	public abstract List<String> findAllDomains();

	@Query(value = "SELECT DISTINCT g FROM General g, Emisor e, Infoport f "
			+ "WHERE e.nbNomEmisor = f.nbNomEmisor "
			+ "AND g.nbValorGeneral = f.nbEspecie "
			+ "AND f.nbNomFondo LIKE :nomFondo AND g.stEstado = 1 "
			+ "AND e.nbNomEmisor LIKE :nomEmisor")
	public abstract List<General> findByFundAndTransmitter(@Param("nomFondo") String strNomFondo, @Param("nomEmisor") String strNomEmisor);
}
