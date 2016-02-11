package com.pss.simulador.bs.service.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.domain.Infoport;
import com.pss.simulador.bs.repository.data.InfoportRepository;
import com.pss.simulador.bs.service.InfoportManager;
import com.pss.simulador.util.Constante;

@Service("infoportManager")
public class InfoportManagerImpl implements InfoportManager {

	private static final Logger LOG = Logger.getLogger(InfoportManagerImpl.class);
	
	@Autowired
	private InfoportRepository infoportRepository; 
	
	public List<Infoport> findByFilter(String nomFondo, String nomEmisor, String vencehoy, String operacion) {
		if(nomFondo.equals(Constante.NO_OPTION_SELECTED)){
			nomFondo = null;
		}
		if(nomEmisor.equals(Constante.NO_OPTION_SELECTED)){
			nomEmisor = null;
		}
		if(vencehoy.equals(Constante.NO_OPTION_SELECTED)){
			vencehoy = null;
		}else{
			vencehoy += "%"; 
		}
		if(operacion.equals(Constante.NO_OPTION_SELECTED)){
			operacion = null;
		}
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(Constante.FECHA_ACTUAL);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		return infoportRepository.findByFilter(calendar.getTime() ,nomFondo, nomEmisor, vencehoy, operacion);
	}

	@Transactional
	public Infoport save(Infoport infoport) {
		return infoportRepository.save(infoport);
	}
	
}
