package com.pss.simulador.bs.repository.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.LimitesEmisor;
/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
@Repository
public interface LimiteEmisorRepository extends CrudRepository<LimitesEmisor, Integer> {

	@Query(value = "SELECT g FROM LimitesEmisor g WHERE g.fondo.cdIdfondo = :cdIdfondo AND g.emisor.cdIdemisor = :cdIdemisor AND g.stEstado = :estado")	
	public abstract LimitesEmisor findByFondoAndEmisor(@Param("cdIdfondo") Integer idFondo, @Param("cdIdemisor") Integer idEmisor, @Param("estado") String strStEstado);

}
