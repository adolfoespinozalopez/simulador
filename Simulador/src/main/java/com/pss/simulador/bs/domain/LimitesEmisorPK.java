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
public class LimitesEmisorPK implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
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

}
