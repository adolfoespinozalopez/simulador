package com.pss.simulador.bs.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table(name = "TSI004_TIPOCAMBIO", schema = "BBVATESOR")
public class TipoCambio implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "secTipoCambio", sequenceName = "BBVATESOR.SEQ_TIPOCAMBIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secTipoCambio")
	@Column(name = "CD_IDTIPOCAMBIO", nullable = false)
	private Integer cdIdtipocambio;
	@Column(name = "FH_FEC_INGRESO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecIngreso;
	@Column(name = "NU_VALOR")
	private Double nuValor;
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
	

	public TipoCambio() {
	}

	public TipoCambio(Double nuvalor) {
		this.nuValor = nuvalor;
	}
	
	public TipoCambio(Integer cdIdtipocambio) {
		this.cdIdtipocambio = cdIdtipocambio;
	}

	public Integer getCdIdtipocambio() {
		return cdIdtipocambio;
	}

	public void setCdIdtipocambio(Integer cdIdtipocambio) {
		this.cdIdtipocambio = cdIdtipocambio;
	}

	public Date getFhFecIngreso() {
		return fhFecIngreso;
	}

	public void setFhFecIngreso(Date fhFecIngreso) {
		this.fhFecIngreso = fhFecIngreso;
	}

	public Double getNuValor() {
		return nuValor;
	}

	public void setNuValor(Double nuValor) {
		this.nuValor = nuValor;
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

}
