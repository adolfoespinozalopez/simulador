package com.pss.simulador.bs.service;

import java.util.List;

import com.pss.simulador.bs.domain.TipoCambio;
import com.pss.simulador.web.bean.UsuarioSession;

/**
 * @author pierre.obregon
 * @version 21/1/2016
 */
public interface TipoCambioManager {

	public TipoCambio save(TipoCambio tipoCambio);
	public List<TipoCambio> findAll();
	public List<TipoCambio> findAllActivo();
	public TipoCambio saveNuevoTipoCambio(TipoCambio tipoCambio, UsuarioSession usuarioSession);
	
}
