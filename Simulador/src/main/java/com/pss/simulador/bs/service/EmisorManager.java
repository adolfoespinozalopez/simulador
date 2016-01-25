/**
 * 
 */
package com.pss.simulador.bs.service;

import java.util.List;

import com.pss.simulador.bs.domain.Emisor;
import com.pss.simulador.bs.domain.LimitesEmisor;
import com.pss.simulador.bs.domain.LimitesEmisorPK;

/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
public interface EmisorManager {

	public List<Emisor> findEmisorByNameAndType(Emisor emisorBusqueda);
	public Emisor save(Emisor emisor);
	public LimitesEmisor saveLimiteEmisor(LimitesEmisor limitesEmisor);
	public List<LimitesEmisor> findLimiteEmisorByPK(LimitesEmisorPK limitesEmisor);
}
