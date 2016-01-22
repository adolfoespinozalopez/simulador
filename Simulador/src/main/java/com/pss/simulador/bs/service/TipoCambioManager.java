package com.pss.simulador.bs.service;

import java.util.List;

import com.pss.simulador.bs.domain.TipoCambio;

/**
 * @author pierre.obregon
 * @version 21/1/2016
 */
public interface TipoCambioManager {

	public TipoCambio save(TipoCambio tipoCambio);
	public void delete(TipoCambio tipoCambio);
	public List<TipoCambio> findAll();
	
}
