/**
 * 
 */
package com.pss.simulador.bs.service;

import java.util.List;

import com.pss.simulador.bs.domain.Perfil;

/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
public interface PerfilManager {
	public List<Perfil> findPerfilByName(String strNombre);
	public Perfil savePerfil(Perfil perfil);
}
