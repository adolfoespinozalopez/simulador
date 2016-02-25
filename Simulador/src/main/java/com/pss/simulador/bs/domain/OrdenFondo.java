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
* @version 1.0, 24/02/2016
* @since 1.0
*/
@Entity
@Table(name = "TSI018_ORDENFONDO", schema = "BBVATESOR")
public class OrdenFondo  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "secOrdenFondo", sequenceName = "BBVATESOR.SEQ_ORDENFONDO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secOrdenFondo")
    @Column(name = "CD_IDDETALLE", nullable = false)
    private Integer cdIddetalle;
	@Column(name = "IM_MONTO_FINAL")
    private Double imMontoFinal;
    @Column(name = "PC_PARTICIPA")
    private Double pcParticipa;
    @Column(name = "ST_ESTADO")
    private String stEstado;
    @Column(name = "FH_FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fhFecCreacion;
    @Column(name = "CD_USU_CREACION", length = 10)
	private String cdUsuCreacion;
	@Column(name = "FH_FEC_MODIFICA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecModifica;
	@Column(name = "CD_USU_MODIFICA", length = 10)
	private String cdUsuModifica;
	@Column(name = "FH_FEC_ELIMINA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecElimina;
	@Column(name = "CD_USU_ELIMINA", length = 10)
	private String cdUsuElimina;
	@JoinColumn(name = "CD_IDORDEN", referencedColumnName = "CD_IDORDEN")
	@ManyToOne(optional = false)
    private Orden orden;
	@JoinColumn(name = "CD_IDFONDO", referencedColumnName = "CD_IDFONDO")
    @ManyToOne
    private Fondo fondo;
	
	public OrdenFondo(){
		
	}
	
	public OrdenFondo(Fondo fondo){
		this.fondo = fondo;
	}
	
	public Integer getCdIddetalle() {
		return cdIddetalle;
	}
	public void setCdIddetalle(Integer cdIddetalle) {
		this.cdIddetalle = cdIddetalle;
	}
	public Double getImMontoFinal() {
		return imMontoFinal;
	}
	public void setImMontoFinal(Double imMontoFinal) {
		this.imMontoFinal = imMontoFinal;
	}
	public Double getPcParticipa() {
		return pcParticipa;
	}
	public void setPcParticipa(Double pcParticipa) {
		this.pcParticipa = pcParticipa;
	}
	public String getStEstado() {
		return stEstado;
	}
	public void setStEstado(String stEstado) {
		this.stEstado = stEstado;
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
	public Date getFhFecModifica() {
		return fhFecModifica;
	}
	public void setFhFecModifica(Date fhFecModifica) {
		this.fhFecModifica = fhFecModifica;
	}
	public String getCdUsuModifica() {
		return cdUsuModifica;
	}
	public void setCdUsuModifica(String cdUsuModifica) {
		this.cdUsuModifica = cdUsuModifica;
	}
	public Date getFhFecElimina() {
		return fhFecElimina;
	}
	public void setFhFecElimina(Date fhFecElimina) {
		this.fhFecElimina = fhFecElimina;
	}
	public String getCdUsuElimina() {
		return cdUsuElimina;
	}
	public void setCdUsuElimina(String cdUsuElimina) {
		this.cdUsuElimina = cdUsuElimina;
	}
	public Orden getOrden() {
		return orden;
	}
	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	public Fondo getFondo() {
		return fondo;
	}
	public void setFondo(Fondo fondo) {
		this.fondo = fondo;
	}
	
}
