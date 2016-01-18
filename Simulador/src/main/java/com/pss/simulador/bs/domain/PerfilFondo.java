package com.pss.simulador.bs.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Adolfo Espinoza
 * @version 1.0, 12/01/2016
 * @since 1.0
 */
@Entity
@Table(name = "TSI009_PERFILFONDO")
public class PerfilFondo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected PerfilFondoPK perfilFondoPK;
	@Column(name = "FH_FEC_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecCreacion;
	@Column(name = "CD_USU_CREACION", length = 10)
	private String cdUsuCreacion;
	@Column(name = "FH_FEC_MODIFICA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecModifica;
	@Column(name = "CD_USU_MODIFICA", length = 10)
	private String cdUsuModifica;
	@Column(name = "FH_FEC_ELIMINA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecElimina;
	@Column(name = "CD_USU_ELIMINA", length = 10)
	private String cdUsuElimina;
	@Column(name = "ST_ESTADO")
	private String stEstado;
	@JoinColumn(name = "CD_IDFONDO", referencedColumnName = "CD_IDFONDO", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Fondo fondo;
	@JoinColumn(name = "CD_IDPERFIL", referencedColumnName = "CD_IDPERFIL", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Perfil perfil;

	public PerfilFondo() {
	}

	public PerfilFondo(PerfilFondoPK perfilFondoPK) {
		this.perfilFondoPK = perfilFondoPK;
	}

	public PerfilFondo(Integer cdIdperfil, Integer cdIdfondo) {
		this.perfilFondoPK = new PerfilFondoPK(cdIdperfil, cdIdfondo);
	}

	public PerfilFondoPK getPerfilFondoPK() {
		return perfilFondoPK;
	}

	public void setPerfilFondoPK(PerfilFondoPK perfilFondoPK) {
		this.perfilFondoPK = perfilFondoPK;
	}

	public Date getFhFecCreacion() {
		return fhFecCreacion;
	}

	public void setFhFecCreacion(Date fhFecCreacion) {
		this.fhFecCreacion = fhFecCreacion;
	}

	public String getCdUsuCreacion() {
		return cdUsuCreacion;
	}

	public void setCdUsuCreacion(String cdUsuCreacion) {
		this.cdUsuCreacion = cdUsuCreacion;
	}

	public Date getFhFecModifica() {
		return fhFecModifica;
	}

	public void setFhFecModifica(Date fhFecModifica) {
		this.fhFecModifica = fhFecModifica;
	}

	public String getCdUsuModifica() {
		return cdUsuModifica;
	}

	public void setCdUsuModifica(String cdUsuModifica) {
		this.cdUsuModifica = cdUsuModifica;
	}

	public Date getFhFecElimina() {
		return fhFecElimina;
	}

	public void setFhFecElimina(Date fhFecElimina) {
		this.fhFecElimina = fhFecElimina;
	}

	public String getCdUsuElimina() {
		return cdUsuElimina;
	}

	public void setCdUsuElimina(String cdUsuElimina) {
		this.cdUsuElimina = cdUsuElimina;
	}

	public String getStEstado() {
		return stEstado;
	}

	public void setStEstado(String stEstado) {
		this.stEstado = stEstado;
	}

	public Fondo getFondo() {
		return fondo;
	}

	public void setFondo(Fondo fondo) {
		this.fondo = fondo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
