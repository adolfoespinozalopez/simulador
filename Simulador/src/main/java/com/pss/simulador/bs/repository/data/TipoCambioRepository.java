/**
 * 
 */
package com.pss.simulador.bs.repository.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.TipoCambio;

/**
 * @author pierre.obregon
 * @version 21/1/2016
 */
@Repository
public interface TipoCambioRepository extends CrudRepository<TipoCambio, Integer> {

}
