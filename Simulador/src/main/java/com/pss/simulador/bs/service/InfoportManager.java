package com.pss.simulador.bs.service;

import java.util.List;

import com.pss.simulador.bs.domain.Infoport;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 20/01/2016
* @since 1.0
*/
public interface InfoportManager {

	public List<Infoport> findByFilter(String nomFondo, String nomEmisor, String vencehoy, String operacion);
	public Infoport save(Infoport infoport);
}
