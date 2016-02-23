/**
 * 
 */
package com.pss.simulador.bs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.domain.ExpoFondo;
import com.pss.simulador.bs.domain.Fondo;
import com.pss.simulador.bs.domain.LimFondoEspecie;
import com.pss.simulador.bs.domain.Saldo;
import com.pss.simulador.bs.repository.data.FondoRepository;
import com.pss.simulador.bs.repository.data.LimFondoEspecieRepository;
import com.pss.simulador.bs.repository.data.SaldoRepository;
import com.pss.simulador.bs.service.FondoManager;
import com.pss.simulador.util.Constante;

/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
@Service
@Transactional(readOnly = true)
public class FondoManagerImpl implements FondoManager {
	
	@Autowired
	FondoRepository fondoRepository;
	
	@Autowired
	SaldoRepository saldoRepository;
	
	@Autowired
	LimFondoEspecieRepository limFondoEspecieRepository;
	
	public List<Fondo> findFondoAll() {
		return (List<Fondo>) fondoRepository.findAll();
	}

	@Transactional
	public LimFondoEspecie saveLimFondoEspecie(LimFondoEspecie limFondoEspecie) {
		return limFondoEspecieRepository.save(limFondoEspecie);
	}
	
	public List<Saldo> findSaldoAll(){
		return (List<Saldo>) saldoRepository.findAll();
	}
	
	public List<Saldo> findSaldoByName(String strNombre){
		return (List<Saldo>) saldoRepository.findByName(strNombre);
	}
	
	public Fondo findFondoByName(String strNombName){
		return fondoRepository.findByName(strNombName);
	}
	
	public LimFondoEspecie findLimFondoEspecieByFondoAndEmisorAndEspecie(LimFondoEspecie limFondoEspecie){
		return limFondoEspecieRepository.findByFondoAndEmisorAndEspecie(
				limFondoEspecie.getFondo().getCdIdfondo(), 
				limFondoEspecie.getEmisor().getCdIdemisor(),
				limFondoEspecie.getGeneral().getCdIdgeneral(), 
				Constante.ESTADO_ACTIVO);
	}

	public List<Fondo> findAll() {
		return fondoRepository.findAll();
	}
	
	public List<ExpoFondo> obtenerExposicionDelFondo(Integer idFondo, String stEstado) {
		return fondoRepository.obtenerExposicionDelFondo(idFondo, stEstado);
	}
	
}
