package com.pss.simulador.bs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.repository.data.ExpoFondoRepository;
import com.pss.simulador.bs.service.ExpoFondoManager;
/**
*
* @author Adolfo Espinoza
* @version 1.0, 05/02/2016
* @since 1.0
*/
@Service
@Transactional(readOnly = true)
public class ExpoFondoManagerImpl implements ExpoFondoManager{

	@Autowired
	ExpoFondoRepository expoFondoRepository;

	public boolean executeExposicionDelFondo(String nbFondo, String stestado) {
		return expoFondoRepository.executeExposicionDelFondo(nbFondo, stestado);
	}
	
}
