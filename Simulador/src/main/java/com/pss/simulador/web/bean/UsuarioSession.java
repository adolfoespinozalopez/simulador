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
	private Boolean bEsRiesgo;
	private Boolean bEsAdmin;
	private Perfil perfil;

	public UsuarioSession() {
		usuario = new IILDPeUsuario();
		bEsRiesgo = false;
		bEsInversion = false;
	}

	public IILDPeUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(IILDPeUsuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getbEsInversion() {
		return bEsInversion;
	}

	public void setbEsInversion(Boolean bEsInversion) {
		this.bEsInversion = bEsInversion;
	}

	public Boolean getbEsRiesgo() {
		return bEsRiesgo;
	}

	public void setbEsRiesgo(Boolean bEsRiesgo) {
		this.bEsRiesgo = bEsRiesgo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Boolean getbEsAdmin() {
		return bEsAdmin;
	}

	public void setbEsAdmin(Boolean bEsAdmin) {
		this.bEsAdmin = bEsAdmin;
	}

}
