/**
 * 
 */
package com.pss.simulador.bs.repository.data;

import org.springframework.data.repository.CrudRepository;

import com.pss.simulador.bs.domain.ProcesoCarga;

/**
 * @author pierre.obregon
 * @version 31/1/2016
 */
public interface ProcesoLogRepository extends CrudRepository<ProcesoCarga, Integer> {

}
