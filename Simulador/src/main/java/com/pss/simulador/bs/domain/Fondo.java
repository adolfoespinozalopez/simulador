package com.pss.simulador.bs.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 12/01/2016
* @since 1.0
*/
@Entity
@Table(name = "TSI008_FONDO", schema="BBVATESOR")
public class Fondo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CD_IDFONDO", nullable = false)
	private Integer cdIdfondo;
	@Column(name = "CD_COD_FONDO", length = 4)
	private String cdCodFondo;
	@Column(name = "NB_NOM_FONDO", length = 40)
	private String nbNomFondo;
	@Column(name = "TP_TIPMONEDA")
	private Integer tpTipmoneda;
	@Column(name = "TP_TIPFONDO")
	private String tpTipfondo;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fondo")
	private List<LimitesEmisor> limitesEmisorList;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fondo")
    private List<OrdenFondo> ordenFondoList;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fondo")
	private List<LimFondoEspecie> limFondoEspecieList;
	
	
	@Transient
	private String monto;
	@Transient
	private String porcentaje;
	
	@Transient
	private String montoNuevo;
	@Transient
	private String porcentajeNuevo;
	
	public Fondo() {
	}

	public Fondo(Integer cdIdfondo) {
		this.cdIdfondo = cdIdfondo;
	}

	public Integer getCdIdfondo() {
		return cdIdfondo;
	}

	public void setCdIdfondo(Integer cdIdfondo) {
		this.cdIdfondo = cdIdfondo;
	}

	public String getCdCodFondo() {
		return cdCodFondo;
	}

	public void setCdCodFondo(String cdCodFondo) {
		this.cdCodFondo = cdCodFondo;
	}

	public String getNbNomFondo() {
		return nbNomFondo;
	}

	public void setNbNomFondo(String nbNomFondo) {
		this.nbNomFondo = nbNomFondo;
	}

	public Integer getTpTipmoneda() {
		return tpTipmoneda;
	}

	public void setTpTipmoneda(Integer tpTipmoneda) {
		this.tpTipmoneda = tpTipmoneda;
	}

	public String getTpTipfondo() {
		return tpTipfondo;
	}

	public void setTpTipfondo(String tpTipfondo) {
		this.tpTipfondo = tpTipfondo;
	}

	public List<LimFondoEspecie> getLimFondoEspecieList() {
		return limFondoEspecieList;
	}

	public void setLimFondoEspecieList(List<LimFondoEspecie> limFondoEspecieList) {
		this.limFondoEspecieList = limFondoEspecieList;
	}

	public List<OrdenFondo> getOrdenFondoList() {
		return ordenFondoList;
	}

	public void setOrdenFondoList(List<OrdenFondo> ordenFondoList) {
		this.ordenFondoList = ordenFondoList;
	}

	public List<LimitesEmisor> getLimitesEmisorList() {
		return limitesEmisorList;
	}

	public void setLimitesEmisorList(List<LimitesEmisor> limitesEmisorList) {
		this.limitesEmisorList = limitesEmisorList;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getMontoNuevo() {
		return montoNuevo;
	}

	public void setMontoNuevo(String montoNuevo) {
		this.montoNuevo = montoNuevo;
	}

	public String getPorcentajeNuevo() {
		return porcentajeNuevo;
	}

	public void setPorcentajeNuevo(String porcentajeNuevo) {
		this.porcentajeNuevo = porcentajeNuevo;
	}
	
}
