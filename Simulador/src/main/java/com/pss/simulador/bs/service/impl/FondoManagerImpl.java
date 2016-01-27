/**
 * 
 */
package com.pss.simulador.bs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.domain.Fondo;
import com.pss.simulador.bs.repository.data.FondoRepository;
import com.pss.simulador.bs.service.FondoManager;

/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
@Service
@Transactional(readOnly = true)
public class FondoManagerImpl implements FondoManager {
	
	@Autowired
	FondoRepository fondoRepository;
	
	public List<Fondo> findFondoAll() {
		return (List<Fondo>) fondoRepository.findAll();
	}

}
