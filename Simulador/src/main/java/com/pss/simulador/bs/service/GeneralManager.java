package com.pss.simulador.bs.service;

import java.util.List;
import com.pss.simulador.bs.domain.General;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 13/01/2016
* @since 1.0
*/
public interface GeneralManager {

	public List<General> findByDomainAndState(String domain, String stEstado);
	
	public List<General> findByDomain(String domain);
	
	public List<String> findAllDomainsActive();
}
