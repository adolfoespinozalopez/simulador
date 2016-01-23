/**
 * 
 */
package com.pss.simulador.bs.repository.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.TipoCambio;

/**
 * @author pierre.obregon
 * @version 21/1/2016
 */
@Repository
public interface TipoCambioRepository extends CrudRepository<TipoCambio, Integer> {

	@Query(value = "SELECT g FROM TipoCambio g WHERE SQL('TRUNC(?)',g.fhFecIngreso) = SQL('TRUNC(?)',:dtFecha) AND g.stEstado = :estado")	
	public abstract List<TipoCambio> findByFechaIng(@Param("dtFecha") Date dtFecha, @Param("estado") String strStEstado);
	
	@Query(value = "SELECT g FROM TipoCambio g WHERE g.stEstado = :estado")	
	public abstract List<TipoCambio> findAllActivos(@Param("estado") String strStEstado);
	
}
