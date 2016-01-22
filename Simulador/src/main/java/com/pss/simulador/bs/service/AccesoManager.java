/**
 * 
 */
package com.pss.simulador.bs.service;

import com.pss.simulador.bs.domain.Usuario;

/**
 * @author pierre.obregon
 * @version 21/1/2016
 */
public interface AccesoManager {
	public Usuario findOne(Integer id);
	public Usuario findByRegUser(String registroUsuario);
}
