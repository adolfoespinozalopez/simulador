package com.pss.simulador.bs.domain;

// default package
// Generated 16/01/2016 12:44:26 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tsi008Fondo generated by hbm2java
 */
@Entity
@Table(name = "TSI008_FONDO")
public class Fondo implements java.io.Serializable {

	private BigDecimal cdIdfondo;
	private String cdCodFondo;
	private String nbNomFondo;
	private BigDecimal tpTipmoneda;
	private Character tpTipfondo;
	private Set tsi009Perfilfondos = new HashSet(0);
	private Set tsi012Limfondoespecies = new HashSet(0);

	public Fondo() {
	}

	public Fondo(BigDecimal cdIdfondo) {
		this.cdIdfondo = cdIdfondo;
	}

	public Fondo(BigDecimal cdIdfondo, String cdCodFondo,
			String nbNomFondo, BigDecimal tpTipmoneda, Character tpTipfondo,
			Set tsi009Perfilfondos, Set tsi012Limfondoespecies) {
		this.cdIdfondo = cdIdfondo;
		this.cdCodFondo = cdCodFondo;
		this.nbNomFondo = nbNomFondo;
		this.tpTipmoneda = tpTipmoneda;
		this.tpTipfondo = tpTipfondo;
		this.tsi009Perfilfondos = tsi009Perfilfondos;
		this.tsi012Limfondoespecies = tsi012Limfondoespecies;
	}

	@Id
	@Column(name = "CD_IDFONDO", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCdIdfondo() {
		return this.cdIdfondo;
	}

	public void setCdIdfondo(BigDecimal cdIdfondo) {
		this.cdIdfondo = cdIdfondo;
	}

	@Column(name = "CD_COD_FONDO", length = 4)
	public String getCdCodFondo() {
		return this.cdCodFondo;
	}

	public void setCdCodFondo(String cdCodFondo) {
		this.cdCodFondo = cdCodFondo;
	}

	@Column(name = "NB_NOM_FONDO", length = 40)
	public String getNbNomFondo() {
		return this.nbNomFondo;
	}

	public void setNbNomFondo(String nbNomFondo) {
		this.nbNomFondo = nbNomFondo;
	}

	@Column(name = "TP_TIPMONEDA", precision = 22, scale = 0)
	public BigDecimal getTpTipmoneda() {
		return this.tpTipmoneda;
	}

	public void setTpTipmoneda(BigDecimal tpTipmoneda) {
		this.tpTipmoneda = tpTipmoneda;
	}

	@Column(name = "TP_TIPFONDO", length = 1)
	public Character getTpTipfondo() {
		return this.tpTipfondo;
	}

	public void setTpTipfondo(Character tpTipfondo) {
		this.tpTipfondo = tpTipfondo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tsi008Fondo")
	public Set getTsi009Perfilfondos() {
		return this.tsi009Perfilfondos;
	}

	public void setTsi009Perfilfondos(Set tsi009Perfilfondos) {
		this.tsi009Perfilfondos = tsi009Perfilfondos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tsi008Fondo")
	public Set getTsi012Limfondoespecies() {
		return this.tsi012Limfondoespecies;
	}

	public void setTsi012Limfondoespecies(Set tsi012Limfondoespecies) {
		this.tsi012Limfondoespecies = tsi012Limfondoespecies;
	}

}
