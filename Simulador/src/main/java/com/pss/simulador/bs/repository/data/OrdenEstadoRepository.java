package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pss.simulador.bs.domain.OrdenEstado;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 28/01/2016
* @since 1.0
*/
public interface OrdenEstadoRepository extends CrudRepository<OrdenEstado, Integer>{

	@Query(value = "SELECT s FROM OrdenEstado s WHERE s.orden.cdIdorden = :idOrden ORDER BY s.fhFecCreacion DESC")
	public abstract List<OrdenEstado> findEstadoByOrden(@Param("idOrden") Integer idOrden);
	
}
