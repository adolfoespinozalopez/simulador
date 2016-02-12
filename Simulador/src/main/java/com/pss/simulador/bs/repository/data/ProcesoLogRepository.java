/**
 * 
 */
package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pss.simulador.bs.domain.ProcesoLog;

/**
 * @author pierre.obregon
 * @version 31/1/2016
 */
public interface ProcesoLogRepository extends CrudRepository<ProcesoLog, Integer> {
	
	@Query(value = "SELECT g FROM ProcesoLog g WHERE g.procesoCarga.cdIdproceso = :cdIdproceso")	
	public abstract List<ProcesoLog> findByIdProceso(@Param("cdIdproceso") Integer cdIdproceso);

}
