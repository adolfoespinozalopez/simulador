/**
 * 
 */
package com.pss.simulador.web.bean;

import java.io.Serializable;

import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.pss.simulador.bs.domain.Perfil;

/**
 * @author pierre.obregon
 * @version 21/1/2016
 */
public class UsuarioSession implements Serializable {

	private static final long serialVersionUID = 1L;
	private IILDPeUsuario usuario;
	private Boolean bEsInversion;
	private Boolean bEsAdmin;
	private Perfil perfil;

	public UsuarioSession() {
		usuario = new IILDPeUsuario();
		bEsInversion = false;
		bEsInversion = false;
	}

	/**
	 * @return the usuario
	 */
	public IILDPeUsuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(IILDPeUsuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the bEsInversion
	 */
	public Boolean getbEsInversion() {
		return bEsInversion;
	}

	/**
	 * @param bEsInversion
	 *            the bEsInversion to set
	 */
	public void setbEsInversion(Boolean bEsInversion) {
		this.bEsInversion = bEsInversion;
	}

	

	/**
	 * @return the bEsAdmin
	 */
	public Boolean getbEsAdmin() {
		return bEsAdmin;
	}

	/**
	 * @param bEsAdmin the bEsAdmin to set
	 */
	public void setbEsAdmin(Boolean bEsAdmin) {
		this.bEsAdmin = bEsAdmin;
	}

	/**
	 * @return the perfil
	 */
	public Perfil getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil
	 *            the perfil to set
	 */
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
