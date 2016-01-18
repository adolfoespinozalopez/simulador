package com.pss.simulador.bs.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TSI012_LIMFONDOESPECIE")
public class LimFondoEspecie implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CD_IDCONFIGURACION", nullable = false)
	private Integer cdIdconfiguracion;
	@Column(name = "PC_PORC_INI")
	private Double pcPorcIni;
	@Column(name = "PC_PORC_FIN")
	private Double pcPorcFin;
	@Column(name = "NU_MONTO_INI")
	private Double nuMontoIni;
	@Column(name = "NU_MONTO_FIN")
	private Double nuMontoFin;
	@Column(name = "ST_ESTADO")
	private String stEstado;
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
	@JoinColumn(name = "CD_IDEMISOR", referencedColumnName = "CD_IDEMISOR", nullable = false)
	@ManyToOne(optional = false)
	private Emisor cdIdemisor;
	@JoinColumn(name = "CD_IDFONDO", referencedColumnName = "CD_IDFONDO", nullable = false)
	@ManyToOne(optional = false)
	private Fondo cdIdfondo;
	@JoinColumn(name = "CD_IDGENERAL", referencedColumnName = "CD_IDGENERAL", nullable = false)
	@ManyToOne(optional = false)
	private General cdIdgeneral;

	public LimFondoEspecie() {
	}

	public LimFondoEspecie(Integer cdIdconfiguracion) {
		this.cdIdconfiguracion = cdIdconfiguracion;
	}

	public Integer getCdIdconfiguracion() {
		return cdIdconfiguracion;
	}

	public void setCdIdconfiguracion(Integer cdIdconfiguracion) {
		this.cdIdconfiguracion = cdIdconfiguracion;
	}

	public Double getPcPorcIni() {
		return pcPorcIni;
	}

	public void setPcPorcIni(Double pcPorcIni) {
		this.pcPorcIni = pcPorcIni;
	}

	public Double getPcPorcFin() {
		return pcPorcFin;
	}

	public void setPcPorcFin(Double pcPorcFin) {
		this.pcPorcFin = pcPorcFin;
	}

	public Double getNuMontoIni() {
		return nuMontoIni;
	}

	public void setNuMontoIni(Double nuMontoIni) {
		this.nuMontoIni = nuMontoIni;
	}

	public Double getNuMontoFin() {
		return nuMontoFin;
	}

	public void setNuMontoFin(Double nuMontoFin) {
		this.nuMontoFin = nuMontoFin;
	}

	public String getStEstado() {
		return stEstado;
	}

	public void setStEstado(String stEstado) {
		this.stEstado = stEstado;
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

	public Emisor getCdIdemisor() {
		return cdIdemisor;
	}

	public void setCdIdemisor(Emisor cdIdemisor) {
		this.cdIdemisor = cdIdemisor;
	}

	public Fondo getCdIdfondo() {
		return cdIdfondo;
	}

	public void setCdIdfondo(Fondo cdIdfondo) {
		this.cdIdfondo = cdIdfondo;
	}

	public General getCdIdgeneral() {
		return cdIdgeneral;
	}

	public void setCdIdgeneral(General cdIdgeneral) {
		this.cdIdgeneral = cdIdgeneral;
	}

}
