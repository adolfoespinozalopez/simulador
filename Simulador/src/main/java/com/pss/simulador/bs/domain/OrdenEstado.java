package com.pss.simulador.bs.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 28/01/2016
* @since 1.0
*/
@Entity
@Table(name = "TSI014_ORDENESTADO", schema = "BBVATESOR")
public class OrdenEstado implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "secOrdenEstado", sequenceName = "BBVATESOR.SEQ_ORDENESTADO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secOrdenEstado")
    @Column(name = "CD_IDESTORDEN", nullable = false)
    private Integer cdIdestorden;
    @Column(name = "FH_FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fhFecCreacion;
    @Column(name = "CD_USU_CREACION", length = 10)
    private String cdUsuCreacion;
    @JoinColumn(name = "CD_IDORDEN", referencedColumnName = "CD_IDORDEN")
    @ManyToOne(optional = false)
    private Orden orden;
    @JoinColumn(name = "CD_IDGENERAL", referencedColumnName = "CD_IDGENERAL")
    @ManyToOne(optional = false)
    private General cdIdgeneral;
    
    public OrdenEstado(){
    	
    }
    
    public OrdenEstado(Integer cdIdestorden){
    	this.cdIdestorden = cdIdestorden;
    }
    
	public Integer getCdIdestorden() {
		return cdIdestorden;
	}
	public void setCdIdestorden(Integer cdIdestorden) {
		this.cdIdestorden = cdIdestorden;
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
	public Orden getOrden() {
		return orden;
	}
	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public General getCdIdgeneral() {
		return cdIdgeneral;
	}

	public void setCdIdgeneral(General cdIdgeneral) {
		this.cdIdgeneral = cdIdgeneral;
	}
    
}
