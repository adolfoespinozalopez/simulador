package com.pss.simulador.bs.dao;

import java.util.List;
import com.pss.simulador.bs.domain.General;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 13/01/2016
* @since 1.0
*/
public interface GeneralDao {

	public List<General> findByDomainAndState(String domain, String stEstado);
	
}
