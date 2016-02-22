/**
 * 
 */
package com.pss.simulador.bs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.domain.Perfil;
import com.pss.simulador.bs.repository.data.PerfilRepository;
import com.pss.simulador.bs.service.PerfilManager;

/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
@Service
@Transactional(readOnly = true)
public class PerfilManagerImpl implements PerfilManager {

	@Autowired
	PerfilRepository perfilRepository;

	public List<Perfil> findPerfilByName(String strNombre) {
		return perfilRepository.findPerfilByName(strNombre);
	}
	
	
	@Transactional
	public Perfil savePerfil(Perfil perfil) {
		return perfilRepository.save(perfil);
	}


}
