package com.pss.simulador.bs.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
/**
 *
 * @author Adolfo Espinoza
 * @version 1.0, 12/01/2016
 * @since 1.0
 */
@Embeddable
public class LimitesEmisorPK implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@SequenceGenerator(name = "secLimiteEmisor", sequenceName = "BBVATESOR.SEQ_LIMITESEMISOR", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secLimiteEmisor")
	@Column(name = "CD_IDLIMITE", nullable = false)
	private Integer cdIdlimite;
	@Basic(optional = false)
	@Column(name = "CD_IDEMISOR", nullable = false)
	private Integer cdIdemisor;

	public LimitesEmisorPK() {
	}

	public LimitesEmisorPK(Integer cdIdlimite, Integer cdIdemisor) {
		this.cdIdlimite = cdIdlimite;
		this.cdIdemisor = cdIdemisor;
	}

	public Integer getCdIdlimite() {
		return cdIdlimite;
	}

	public void setCdIdlimite(Integer cdIdlimite) {
		this.cdIdlimite = cdIdlimite;
	}

	public Integer getCdIdemisor() {
		return cdIdemisor;
	}

	public void setCdIdemisor(Integer cdIdemisor) {
		this.cdIdemisor = cdIdemisor;
	}

    public int hashCode() {
        int hash = 0;
        hash += (cdIdlimite != null ? cdIdlimite.hashCode() : 0);
        hash += (cdIdemisor != null ? cdIdemisor.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LimitesEmisorPK)) {
            return false;
        }
        LimitesEmisorPK other = (LimitesEmisorPK) object;
        if ((this.cdIdlimite == null && other.cdIdlimite != null) || (this.cdIdlimite != null && !this.cdIdlimite.equals(other.cdIdlimite))) {
            return false;
        }
        if ((this.cdIdemisor == null && other.cdIdemisor != null) || (this.cdIdemisor != null && !this.cdIdemisor.equals(other.cdIdemisor))) {
            return false;
        }
        return true;
    }
}
