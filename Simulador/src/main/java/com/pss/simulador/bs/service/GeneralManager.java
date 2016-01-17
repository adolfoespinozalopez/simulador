package com.pss.simulador.bs.service;

import java.util.List;

import com.pss.simulador.bs.domain.General;

public interface GeneralManager {

	public List<General> findByDomainAndState(String domain, String stEstado);
	
}
