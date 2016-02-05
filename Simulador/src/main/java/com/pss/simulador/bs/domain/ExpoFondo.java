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
@Table(name = "TSI009_EXPOFONDO", schema="BBVATESOR")
public class ExpoFondo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "CID_EXPO", nullable = false)
    private Integer cidExpo;
    @Column(name = "CD_IDFONDO")
    private Integer cdIdfondo;
    @Column(name = "NB_ESPECIE", length = 60)
    private String nbEspecie;
    @Column(name = "NB_MONTO")
    private Double nbMonto;
    @Column(name = "PC_PARTIC", length = 60)
    private String pcPartic;
    @Column(name = "NB_MONTO_PEN")
    private Double nbMontoPen;
    @Column(name = "PC_PARTIC_PEN", length = 60)
    private String pcParticPen;
    @Column(name = "NB_MONTO_USD")
    private Double nbMontoUsd;
    @Column(name = "PC_PARTIC_USD", length = 60)
    private String pcParticUsd;
    @Column(name = "NB_DURATION")
    private Double nbDuration;
    @Column(name = "PC_YTM", length = 60)
    private String pcYtm;
    @Column(name = "TP_MNEMONICO")
    private String tpMnemonico;
    @Column(name = "TP_TOTAL")
    private String tpTotal;
    
    public ExpoFondo(){
    	
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
	public Double getNbMonto() {
		return nbMonto;
	}
	public void setNbMonto(Double nbMonto) {
		this.nbMonto = nbMonto;
	}
	public String getPcPartic() {
		return pcPartic;
	}
	public void setPcPartic(String pcPartic) {
		this.pcPartic = pcPartic;
	}
	public Double getNbMontoPen() {
		return nbMontoPen;
	}
	public void setNbMontoPen(Double nbMontoPen) {
		this.nbMontoPen = nbMontoPen;
	}
	public String getPcParticPen() {
		return pcParticPen;
	}
	public void setPcParticPen(String pcParticPen) {
		this.pcParticPen = pcParticPen;
	}
	public Double getNbMontoUsd() {
		return nbMontoUsd;
	}
	public void setNbMontoUsd(Double nbMontoUsd) {
		this.nbMontoUsd = nbMontoUsd;
	}
	public String getPcParticUsd() {
		return pcParticUsd;
	}
	public void setPcParticUsd(String pcParticUsd) {
		this.pcParticUsd = pcParticUsd;
	}
	public Double getNbDuration() {
		return nbDuration;
	}
	public void setNbDuration(Double nbDuration) {
		this.nbDuration = nbDuration;
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
    
}
