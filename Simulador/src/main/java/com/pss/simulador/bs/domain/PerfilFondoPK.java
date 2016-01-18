package com.pss.simulador.bs.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
*
* @author Adolfo Espinoza
* @version 1.0, 12/01/2016
* @since 1.0
*/
@Embeddable
public class PerfilFondoPK implements Serializable{

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "CD_IDPERFIL", nullable = false)
	private Integer cdIdperfil;
	@Basic(optional = false)
	@Column(name = "CD_IDFONDO", nullable = false)
	private Integer cdIdfondo;

	public PerfilFondoPK() {
	}

	public PerfilFondoPK(Integer cdIdperfil, Integer cdIdfondo) {
		this.cdIdperfil = cdIdperfil;
		this.cdIdfondo = cdIdfondo;
	}

	public Integer getCdIdperfil() {
		return cdIdperfil;
	}

	public void setCdIdperfil(Integer cdIdperfil) {
		this.cdIdperfil = cdIdperfil;
	}

	public Integer getCdIdfondo() {
		return cdIdfondo;
	}

	public void setCdIdfondo(Integer cdIdfondo) {
		this.cdIdfondo = cdIdfondo;
	}
}
