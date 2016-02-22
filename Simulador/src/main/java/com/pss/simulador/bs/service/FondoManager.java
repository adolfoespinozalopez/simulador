/**
 * 
 */
package com.pss.simulador.bs.service;

import java.util.List;

import com.pss.simulador.bs.domain.ExpoFondo;
import com.pss.simulador.bs.domain.Fondo;
import com.pss.simulador.bs.domain.LimFondoEspecie;
import com.pss.simulador.bs.domain.Saldo;

/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
public interface FondoManager {
	public List<Fondo> findFondoAll();
	public LimFondoEspecie saveLimFondoEspecie(LimFondoEspecie limFondoEspecie);
	public List<Saldo> findSaldoAll();
	public List<Saldo> findSaldoByName(String strNombre);
	public Fondo findFondoByName(String strNombName);
	public LimFondoEspecie findLimFondoEspecieByFondoAndEmisorAndEspecie(LimFondoEspecie limFondoEspecie);
	public List<Fondo> findAll();
	public List<ExpoFondo> obtenerExposicionDelFondo(Integer idFondo);
	
}
