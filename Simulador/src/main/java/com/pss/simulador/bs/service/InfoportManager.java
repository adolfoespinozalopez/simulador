package com.pss.simulador.bs.service;

import java.util.List;

import com.pss.simulador.bs.domain.Infoport;

public interface InfoportManager {

	public List<Infoport> findByFilter(String nomFondo, String nomEmisor, String vencehoy, String operacion);
	
}
