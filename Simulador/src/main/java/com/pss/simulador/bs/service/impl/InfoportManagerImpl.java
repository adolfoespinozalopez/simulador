package com.pss.simulador.bs.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pss.simulador.bs.domain.Infoport;
import com.pss.simulador.bs.repository.data.InfoportRepository;
import com.pss.simulador.bs.service.InfoportManager;

@Service("infoportManager")
public class InfoportManagerImpl implements InfoportManager {

	private static final Logger LOG = Logger.getLogger(InfoportManagerImpl.class);
	
	@Autowired
	private InfoportRepository infoportRepository; 
	
	public List<Infoport> findAllInfo() {
		return infoportRepository.findAllInfo();
	}

}
