package com.pss.simulador.web.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Adolfo Espinoza
 * @version 1.0, 30/12/2015
 * @since 1.0
 */
public class Perfil implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
    private String nombre;
    private Date fecInicio;
    private Date fecFin;
    private String estado;
    private Integer tipo;

    public Perfil() {

    }
    
    public Perfil(Integer id, String nombre, Integer tipo) {
        Calendar cal = Calendar.getInstance();
        this.fecInicio = cal.getTime();
        cal.add(Calendar.YEAR, 1);
        this.estado = "1";
        this.fecFin = cal.getTime();
        this.nombre = nombre;
        this.tipo = tipo;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    
    
}
