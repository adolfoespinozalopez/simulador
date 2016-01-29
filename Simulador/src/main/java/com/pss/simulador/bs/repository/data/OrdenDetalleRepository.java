package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pss.simulador.bs.domain.DetalleOrden;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 28/01/2016
* @since 1.0
*/
public interface OrdenDetalleRepository extends CrudRepository<DetalleOrden, Integer>{

	@Query(value = "SELECT d FROM DetalleOrden d WHERE d.orden.cdIdorden = :idOrden ")
	public abstract List<DetalleOrden> findDetalleByOrden(@Param("idOrden") Integer idOrden);
	
}
