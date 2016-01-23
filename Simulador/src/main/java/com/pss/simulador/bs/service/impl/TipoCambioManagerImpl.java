package com.pss.simulador.bs.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.domain.TipoCambio;
import com.pss.simulador.bs.repository.data.TipoCambioRepository;
import com.pss.simulador.bs.service.TipoCambioManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.web.bean.UsuarioSession;
/**
 * @author pierre.obregon
 * @version 21/1/2016
 */
@Service("tipoCambioManager")
@Transactional(readOnly=true)
public class TipoCambioManagerImpl implements TipoCambioManager {

	private static final Logger logger = Logger.getLogger(TipoCambioManagerImpl.class);
	
	@Autowired
	private TipoCambioRepository tipoCambioRepository;
	
	@Transactional
	public TipoCambio save(TipoCambio tipoCambio) {
		return tipoCambioRepository.save(tipoCambio);
	}
	
	public List<TipoCambio> findAll(){
		return (List<TipoCambio>) tipoCambioRepository.findAll();
	}
	public List<TipoCambio> findAllActivo(){
		return (List<TipoCambio>) tipoCambioRepository.findAllActivos(Constante.ESTADO_ACTIVO);
	}
	@Transactional
	public TipoCambio saveNuevoTipoCambio(TipoCambio tipoCambio, UsuarioSession usuarioSession) {
		TipoCambio tipoCambioResult = null;
		List<TipoCambio> lstTipoCambio = tipoCambioRepository.findByFechaIng(tipoCambio.getFhFecIngreso(), Constante.ESTADO_ACTIVO);
		if (lstTipoCambio!=null){
			for (TipoCambio tipCambIter : lstTipoCambio) {
				tipCambIter.setStEstado(Constante.ESTADO_INACTIVO);
				tipCambIter.setCdUsuElimina(usuarioSession.getUsuario().getUID());
				tipCambIter.setFhFecElimina(new Date());
			}
			tipoCambioRepository.save(lstTipoCambio);
			tipoCambioResult = tipoCambioRepository.save(tipoCambio);
		}
		return tipoCambioResult;
	}
	
	

	

}
