/**
 * 
 */
package com.pss.simulador.bs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.domain.Usuario;
import com.pss.simulador.bs.repository.data.UsuarioRepository;
import com.pss.simulador.bs.service.AccesoManager;
import com.pss.simulador.util.Constante;

/**
 * @author pierre.obregon
 * @version 21/1/2016
 */
@Service("accesoManager")
@Transactional(readOnly = true)
public class AccesoManagerImpl implements AccesoManager {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario findOne(Integer id) {
		return usuarioRepository.findOne(id);
	}

	public Usuario findByRegUser(String registroUsuario) {
		return usuarioRepository.findByRegUser(registroUsuario, Constante.ESTADO_ACTIVO);
	}
}
