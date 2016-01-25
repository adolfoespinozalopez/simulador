package com.pss.simulador.web.bean;

import java.io.Serializable;
import java.util.Date;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 25/01/2016
* @since 1.0
*/
public class Ordenes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombreFondo;
	private String nombreOperacion;
	private String moneda;
	private String contraparte;
	private String especie;
	private String isim;
	private String mnemoniaco;
	private Date fechaEfectividad;
	private String estado;
	
	public Ordenes(Integer id, String nombreFondo, String nombreOperacion, String moneda, String contraparte, String especie,
			String isim, String mnemoniaco, Date fechaEfectividad, String estado) {
		super();
		this.id = id;
		this.nombreFondo = nombreFondo;
		this.nombreOperacion = nombreOperacion;
		this.moneda = moneda;
		this.contraparte = contraparte;
		this.especie = especie;
		this.isim = isim;
		this.mnemoniaco = mnemoniaco;
		this.fechaEfectividad = fechaEfectividad;
		this.estado = estado;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreFondo() {
		return nombreFondo;
	}
	public void setNombreFondo(String nombreFondo) {
		this.nombreFondo = nombreFondo;
	}
	public String getNombreOperacion() {
		return nombreOperacion;
	}
	public void setNombreOperacion(String nombreOperacion) {
		this.nombreOperacion = nombreOperacion;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getContraparte() {
		return contraparte;
	}
	public void setContraparte(String contraparte) {
		this.contraparte = contraparte;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getMnemoniaco() {
		return mnemoniaco;
	}
	public void setMnemoniaco(String mnemoniaco) {
		this.mnemoniaco = mnemoniaco;
	}
	public Date getFechaEfectividad() {
		return fechaEfectividad;
	}
	public void setFechaEfectividad(Date fechaEfectividad) {
		this.fechaEfectividad = fechaEfectividad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
