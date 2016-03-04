package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pss.simulador.bs.domain.OrdenFondo;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 24/02/2016
* @since 1.0
*/
public interface OrdenFondoRepository extends CrudRepository<OrdenFondo, Integer> {

	@Query(value = "SELECT o FROM OrdenFondo o WHERE o.stEstado = '1' AND o.orden.cdIdorden = :idOrden ")
	public abstract List<OrdenFondo> findFondoByOrden(@Param("idOrden") Integer idOrden);
	
}
