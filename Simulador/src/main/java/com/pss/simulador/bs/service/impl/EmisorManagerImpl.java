/**
 * 
 */
package com.pss.simulador.bs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.domain.Emisor;
import com.pss.simulador.bs.domain.LimitesEmisor;
import com.pss.simulador.bs.domain.LimitesEmisorPK;
import com.pss.simulador.bs.repository.data.EmisorRepository;
import com.pss.simulador.bs.repository.data.LimiteEmisorRepository;
import com.pss.simulador.bs.service.EmisorManager;
import com.pss.simulador.util.Constante;

/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
@Service
@Transactional(readOnly=true)
public class EmisorManagerImpl implements EmisorManager {

	@Autowired
	EmisorRepository emisorRepository;
	
	@Autowired
	LimiteEmisorRepository limiteEmisorRepository;
	
	public List<Emisor> findEmisorByNameAndType(Emisor emisorBusqueda) {
		return emisorRepository.findByNameAndType(emisorBusqueda.getNbNomEmisor(), emisorBusqueda.getTpTipemisor(), Constante.ESTADO_ACTIVO);
	}
	
	@Transactional
	public Emisor save(Emisor emisor) {
		return emisorRepository.save(emisor);
	}
	
	@Transactional
	public LimitesEmisor saveLimiteEmisor(LimitesEmisor limitesEmisor) {
		return limiteEmisorRepository.save(limitesEmisor);
	}
	
	public List<LimitesEmisor> findLimiteEmisorByPK(LimitesEmisorPK limitesEmisor) {
		return limiteEmisorRepository.findByPK(limitesEmisor.getCdIdlimite(), limitesEmisor.getCdIdemisor(), Constante.ESTADO_ACTIVO);
	}

}
