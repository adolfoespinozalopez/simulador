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

import com.pss.simulador.bs.domain.ProcesoCarga;

/**
 * @author pierre.obregon
 * @version 31/1/2016
 */
@Repository
public interface ProcesoCargaRepository extends CrudRepository<ProcesoCarga, Integer> {

	@Query(value = "SELECT g FROM ProcesoCarga g "
			+ " WHERE SQL('TRUNC(?)',g.fhFecIni) >= SQL('TRUNC(?)', :dtDesde ) "
			+ " AND SQL('TRUNC(?)',g.fhFecIni) <= SQL('TRUNC(?)', :dtHasta ) "
			+ " AND g.stEstado = :stEstado "
			+ " order by g.fhFecIni desc")
	public abstract List<ProcesoCarga> findByFechaDesdeHasta(@Param("dtDesde") Date dtDesde, @Param("dtHasta") Date dtHasta, @Param("stEstado") String strStEstado);

}
