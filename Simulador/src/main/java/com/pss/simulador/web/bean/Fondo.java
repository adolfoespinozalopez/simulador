package com.pss.simulador.web.bean;

import java.io.Serializable;

import com.pss.simulador.bs.domain.Saldo;
/**
 *
 * @author Adolfo Espinoza
 * @version 1.0, 04/01/2016
 * @since 1.0
 */
public class Fondo implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String codigo;
    private String nombre;
    private String tipoMoneda;
    private String estado;
    private Saldo saldo;
    
    public Fondo(){
        
    }
    
    public Fondo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }
    
    public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Saldo getSaldo() {
		return saldo;
	}

	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}
	
	@Override
    public String toString() {
        return id.toString();
    }
    
    
}
