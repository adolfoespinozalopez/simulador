package com.pss.simulador.bs.repository.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pss.simulador.bs.domain.Orden;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 28/01/2016
* @since 1.0
*/
public interface OrdenRepository extends CrudRepository<Orden, Integer>{

	@Query(value="SELECT o FROM Orden o WHERE o.fhFecEfectividad >= :fecEfectividad "
			+ "AND (:tipoOperacion  IS NULL OR o.tpTipoOperacion = :tipoOperacion) "
			+ "AND (:estado 	 IS NULL OR o.stEstado = :estado) "
			+ "AND (:userName 	 IS NULL OR o.cdUsuCreacion LIKE :userName) "
			+ "ORDER BY o.fhFecEfectividad ")
	public abstract List<Orden> findByFilter(@Param("fecEfectividad") Date fecEfectividad, @Param("tipoOperacion") String tipoOperacion, @Param("estado") String strEstado, @Param("userName") String strUserName);
	
	
	
}
