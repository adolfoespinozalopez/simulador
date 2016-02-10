package com.pss.simulador.bs.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.repository.data.GeneralRepository;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.util.Constante;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 13/01/2016
* @since 1.0
*/

@Service("generalManager")
@Transactional(readOnly=true)
public class GeneralManagerImpl implements GeneralManager {

	private static final Logger LOG = Logger.getLogger(GeneralManagerImpl.class);
	
	@Autowired
	private GeneralRepository generalRepository;
	
	public List<General> findByDomainAndState(String domain, String stEstado) {
		return generalRepository.findByDomainAndState(domain, stEstado);
	}

	public List<General> findByDomain(String domain) {
		return generalRepository.findByDomain(domain,Constante.ESTADO_ACTIVO);
	}
	public List<General> findByDomain(String domain, String stEstado) {
		return generalRepository.findByDomain(domain,stEstado);
	}
	
	public List<String> findAllDomainsActive() {
		return generalRepository.findAllDomainsActive();
	}

	public List<String> findAllDomains() {
		return generalRepository.findAllDomains();
	}
	@Transactional
	public General save(General general){
		return generalRepository.save(general);
	}

	public List<General> findByFundAndTransmitter(String strNomFondo, String strNomEmisor) {
		return generalRepository.findByFundAndTransmitter(strNomFondo, strNomEmisor);
	}

}
