package com.pss.simulador.web.bean;

import java.io.Serializable;
import java.util.Date;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 20/01/2016
* @since 1.0
*/
public class FlujoCaja implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Date fecha;
	private Double entradaSoles;
	private Double salidaSoles;
	private Double saldoSoles;
	private Double entradaDolar;
	private Double salidaDolar;
	private Double saldoDolar;
	
	public FlujoCaja(Date fecha, Double entradaSoles, Double salidaSoles, Double saldoSoles, Double entradaDolar,
			Double salidaDolar, Double saldoDolar) {
		this.fecha = fecha;
		this.entradaSoles = entradaSoles;
		this.salidaSoles = salidaSoles;
		this.saldoSoles = saldoSoles;
		this.entradaDolar = entradaDolar;
		this.salidaDolar = salidaDolar;
		this.saldoDolar = saldoDolar;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getEntradaSoles() {
		return entradaSoles;
	}
	public void setEntradaSoles(Double entradaSoles) {
		this.entradaSoles = entradaSoles;
	}
	public Double getSalidaSoles() {
		return salidaSoles;
	}
	public void setSalidaSoles(Double salidaSoles) {
		this.salidaSoles = salidaSoles;
	}
	public Double getSaldoSoles() {
		return saldoSoles;
	}
	public void setSaldoSoles(Double saldoSoles) {
		this.saldoSoles = saldoSoles;
	}
	public Double getEntradaDolar() {
		return entradaDolar;
	}
	public void setEntradaDolar(Double entradaDolar) {
		this.entradaDolar = entradaDolar;
	}
	public Double getSalidaDolar() {
		return salidaDolar;
	}
	public void setSalidaDolar(Double salidaDolar) {
		this.salidaDolar = salidaDolar;
	}
	public Double getSaldoDolar() {
		return saldoDolar;
	}
	public void setSaldoDolar(Double saldoDolar) {
		this.saldoDolar = saldoDolar;
	}
	
}
