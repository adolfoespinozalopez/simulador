package com.pss.simulador.bs.dao;

import java.util.List;

import com.pss.simulador.bs.domain.General;

public interface GeneralDao {

	public List<General> findByDomainAndState(String domain, String stEstado);
	
}
