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
	
    public int hashCode() {
        int hash = 0;
        hash += (cdIdperfil != null ? cdIdperfil.hashCode() : 0);
        hash += (cdIdfondo != null ? cdIdfondo.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilFondoPK)) {
            return false;
        }
        PerfilFondoPK other = (PerfilFondoPK) object;
        if ((this.cdIdperfil == null && other.cdIdperfil != null) || (this.cdIdperfil != null && !this.cdIdperfil.equals(other.cdIdperfil))) {
            return false;
        }
        if ((this.cdIdfondo == null && other.cdIdfondo != null) || (this.cdIdfondo != null && !this.cdIdfondo.equals(other.cdIdfondo))) {
            return false;
        }
        return true;
    }
}
