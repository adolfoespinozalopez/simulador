package com.pss.simulador.web.bean;

import java.io.Serializable;

/**
 *
 * @author Adolfo Espinoza
 * @version 1.0, 08/01/2016
 * @since 1.0
 */
public class Simulacion implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private Fondo fondoSel;
    private String especie;
    private Double montoTotal;
    private Double porcenPartic;
    private Double montoSoles;
    private Double porcenParticSoles;
    private Double montoDolares;
    private Double porcenParticDolares;
    private Double montoDuration;
    private Double porcenYtm;

    public Simulacion(String especie, Double montoTotal, Double porcenPartic, Double montoSoles, Double porcenParticSoles, Double montoDolares, Double porcenParticDolares, Double montoDuration, Double porcenYtm) {
        this.especie = especie;
        this.montoTotal = montoTotal;
        this.porcenPartic = porcenPartic;
        this.montoSoles = montoSoles;
        this.porcenParticSoles = porcenParticSoles;
        this.montoDolares = montoDolares;
        this.porcenParticDolares = porcenParticDolares;
        this.montoDuration = montoDuration;
        this.porcenYtm = porcenYtm;
    }
    
    public Fondo getFondoSel() {
        return fondoSel;
    }

    public void setFondoSel(Fondo fondoSel) {
        this.fondoSel = fondoSel;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getPorcenPartic() {
        return porcenPartic;
    }

    public void setPorcenPartic(Double porcenPartic) {
        this.porcenPartic = porcenPartic;
    }

    public Double getMontoSoles() {
        return montoSoles;
    }

    public void setMontoSoles(Double montoSoles) {
        this.montoSoles = montoSoles;
    }

    public Double getPorcenParticSoles() {
        return porcenParticSoles;
    }

    public void setPorcenParticSoles(Double porcenParticSoles) {
        this.porcenParticSoles = porcenParticSoles;
    }

    public Double getMontoDolares() {
        return montoDolares;
    }

    public void setMontoDolares(Double montoDolares) {
        this.montoDolares = montoDolares;
    }

    public Double getPorcenParticDolares() {
        return porcenParticDolares;
    }

    public void setPorcenParticDolares(Double porcenParticDolares) {
        this.porcenParticDolares = porcenParticDolares;
    }

    public Double getMontoDuration() {
        return montoDuration;
    }

    public void setMontoDuration(Double montoDuration) {
        this.montoDuration = montoDuration;
    }

    public Double getPorcenYtm() {
        return porcenYtm;
    }

    public void setPorcenYtm(Double porcenYtm) {
        this.porcenYtm = porcenYtm;
    }
    
}
