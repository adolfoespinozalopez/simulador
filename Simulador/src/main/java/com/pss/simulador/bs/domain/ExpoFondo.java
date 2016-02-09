package com.pss.simulador.bs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Adolfo Espinoza
 * @version 1.0, 05/02/2016
 * @since 1.0
 */
@Entity
@Table(name = "TSI009_EXPOFONDO", schema = "BBVATESOR")
public class ExpoFondo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CID_EXPO", nullable = false)
	private Integer cidExpo;
	@Column(name = "CD_IDFONDO")
	private Integer cdIdfondo;
	@Column(name = "NB_ESPECIE", length = 60)
	private String nbEspecie;
	@Column(name = "IM_MONTO")
	private Double imMonto;
	@Column(name = "PC_PARTIC", length = 60)
	private String pcPartic;
	@Column(name = "IM_MONTO_PEN")
	private Double imMontoPen;
	@Column(name = "PC_PARTIC_PEN", length = 60)
	private String pcParticPen;
	@Column(name = "IM_MONTO_USD")
	private Double imMontoUsd;
	@Column(name = "PC_PARTIC_USD", length = 60)
	private String pcParticUsd;
	@Column(name = "IM_DURATION")
	private Double imDuration;
	@Column(name = "PC_YTM", length = 60)
	private String pcYtm;
	@Column(name = "TP_MNEMONICO")
	private String tpMnemonico;
	@Column(name = "TP_TOTAL")
	private String tpTotal;
	@Column(name = "TO_TOTAL_EMI")
	private Double toTotalEmi;
	@Column(name = "PC_EXPOSICION", length = 60)
	private String pcExposicion;
	@Column(name = "PC_LIMITE", length = 60)
	private String pcLimite;
	@Column(name = "PC_ESPACIO", length = 60)
	private String pcEspacio;
	@Column(name = "IM_ESPACIO")
	private Double imEspacio;
	@Column(name = "TP_SUBTITULO")
	private String tpSubtitulo;
	@Column(name = "TP_EMISOR")
	private String tpEmisor;
	
	public ExpoFondo() {

	}

	public Integer getCidExpo() {
		return cidExpo;
	}

	public void setCidExpo(Integer cidExpo) {
		this.cidExpo = cidExpo;
	}

	public Integer getCdIdfondo() {
		return cdIdfondo;
	}

	public void setCdIdfondo(Integer cdIdfondo) {
		this.cdIdfondo = cdIdfondo;
	}

	public String getNbEspecie() {
		return nbEspecie;
	}

	public void setNbEspecie(String nbEspecie) {
		this.nbEspecie = nbEspecie;
	}

	public Double getImMonto() {
		return imMonto;
	}

	public void setImMonto(Double imMonto) {
		this.imMonto = imMonto;
	}

	public String getPcPartic() {
		return pcPartic;
	}

	public void setPcPartic(String pcPartic) {
		this.pcPartic = pcPartic;
	}

	public Double getImMontoPen() {
		return imMontoPen;
	}

	public void setImMontoPen(Double imMontoPen) {
		this.imMontoPen = imMontoPen;
	}

	public String getPcParticPen() {
		return pcParticPen;
	}

	public void setPcParticPen(String pcParticPen) {
		this.pcParticPen = pcParticPen;
	}

	public Double getImMontoUsd() {
		return imMontoUsd;
	}

	public void setImMontoUsd(Double imMontoUsd) {
		this.imMontoUsd = imMontoUsd;
	}

	public String getPcParticUsd() {
		return pcParticUsd;
	}

	public void setPcParticUsd(String pcParticUsd) {
		this.pcParticUsd = pcParticUsd;
	}

	public Double getImDuration() {
		return imDuration;
	}

	public void setImDuration(Double imDuration) {
		this.imDuration = imDuration;
	}

	public String getPcYtm() {
		return pcYtm;
	}

	public void setPcYtm(String pcYtm) {
		this.pcYtm = pcYtm;
	}

	public String getTpMnemonico() {
		return tpMnemonico;
	}

	public void setTpMnemonico(String tpMnemonico) {
		this.tpMnemonico = tpMnemonico;
	}

	public String getTpTotal() {
		return tpTotal;
	}

	public void setTpTotal(String tpTotal) {
		this.tpTotal = tpTotal;
	}

	public Double getToTotalEmi() {
		return toTotalEmi;
	}

	public void setToTotalEmi(Double toTotalEmi) {
		this.toTotalEmi = toTotalEmi;
	}

	public String getPcExposicion() {
		return pcExposicion;
	}

	public void setPcExposicion(String pcExposicion) {
		this.pcExposicion = pcExposicion;
	}

	public String getPcLimite() {
		return pcLimite;
	}

	public void setPcLimite(String pcLimite) {
		this.pcLimite = pcLimite;
	}

	public String getPcEspacio() {
		return pcEspacio;
	}

	public void setPcEspacio(String pcEspacio) {
		this.pcEspacio = pcEspacio;
	}

	public Double getImEspacio() {
		return imEspacio;
	}

	public void setImEspacio(Double imEspacio) {
		this.imEspacio = imEspacio;
	}

	public String getTpSubtitulo() {
		return tpSubtitulo;
	}

	public void setTpSubtitulo(String tpSubtitulo) {
		this.tpSubtitulo = tpSubtitulo;
	}

	public String getTpEmisor() {
		return tpEmisor;
	}

	public void setTpEmisor(String tpEmisor) {
		this.tpEmisor = tpEmisor;
	}
	
}
