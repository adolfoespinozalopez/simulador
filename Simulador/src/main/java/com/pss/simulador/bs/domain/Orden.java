package com.pss.simulador.bs.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "TSI013_ORDEN", schema = "BBVATESOR")
public class Orden implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "secOrden", sequenceName = "BBVATESOR.SEQ_ORDEN", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secOrden")
    @Column(name = "CD_IDORDEN", nullable = false)
    private Integer cdIdorden;
    @Column(name = "FH_FEC_EFECTIVIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fhFecEfectividad;
    @Column(name = "TP_TIPMONEDA")
    private Integer tpTipmoneda;
    @Column(name = "IM_TASA")
    private Double imTasa;
    @Column(name = "NU_PLAZO_DIA")
    private Integer nuPlazoDia;
    @Column(name = "FH_FEC_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fhFecInicio;
    @Column(name = "FH_FEC_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fhFecVencimiento;
    @Column(name = "IM_CAPITAL")
    private Double imCapital;
    @Column(name = "IM_INTERES")
    private Double imInteres;
    @Column(name = "IM_TASA_PRECANCEL")
    private Double imTasaPrecancel;
    @Column(name = "IM_MONTO_FINAL")
    private Double imMontoFinal;
    @Column(name = "IM_TIPOCAMBIOSPOT")
    private Double imTipocambiospot;
    @Column(name = "TP_TIPSETTLEMENT")
    private Integer tpTipsettlement;
    @Column(name = "NU_PUNTOFWD")
    private Integer nuPuntofwd;
    @Column(name = "IM_TIPOCAMBIOFWD")
    private Double imTipocambiofwd;
    @Column(name = "ST_ESTADO")
    private String stEstado;
    @Column(name = "TP_TIPODEPOSITO", length = 20)
    private String tpTipodeposito;
    @Column(name = "NB_MNEMONICO", length = 15)
    private String nbMnemonico;
    @Column(name = "IM_PRECIO_LIMPIO")
    private Double imPrecioLimpio;
    @Column(name = "IM_PRECIO_SUCIO")
    private Double imPrecioSucio;
    @Column(name = "IM_PRECIO_REFERENCIA")
    private Double imPrecioReferencia;
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
    @JoinColumn(name = "CD_IDEMISOR", referencedColumnName = "CD_IDEMISOR")
    @ManyToOne(optional = false)
    private Emisor emisor;
    @JoinColumn(name = "CD_IDFONDO", referencedColumnName = "CD_IDFONDO")
    @ManyToOne(optional = false)
    private Fondo fondo;
    @JoinColumn(name = "CD_IDCONTRAPARTE", referencedColumnName = "CD_IDGENERAL")
    @ManyToOne(optional = false)
    private General contraparte;
    @JoinColumn(name = "CD_IDTIPOOPERACION", referencedColumnName = "CD_IDGENERAL")
    @ManyToOne(optional = false)
    private General cdIdTipoOperacion;
    @JoinColumn(name = "CD_IDESPECIE", referencedColumnName = "CD_IDGENERAL")
    @ManyToOne(optional = false)
    private General especie;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orden")
    private List<OrdenEstado> ordenEstadoList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orden")
    private List<DetalleOrden> detalleordenList;
    
    public Orden() {
    }
    
    public Orden(Integer cdIdorden) {
        this.cdIdorden = cdIdorden;
    }
    
	public Integer getCdIdorden() {
		return cdIdorden;
	}
	public void setCdIdorden(Integer cdIdorden) {
		this.cdIdorden = cdIdorden;
	}
	public Date getFhFecEfectividad() {
		return fhFecEfectividad;
	}
	public void setFhFecEfectividad(Date fhFecEfectividad) {
		this.fhFecEfectividad = fhFecEfectividad;
	}
	public Integer getTpTipmoneda() {
		return tpTipmoneda;
	}
	public void setTpTipmoneda(Integer tpTipmoneda) {
		this.tpTipmoneda = tpTipmoneda;
	}
	public Double getImTasa() {
		return imTasa;
	}
	public void setImTasa(Double imTasa) {
		this.imTasa = imTasa;
	}
	public Integer getNuPlazoDia() {
		return nuPlazoDia;
	}
	public void setNuPlazoDia(Integer nuPlazoDia) {
		this.nuPlazoDia = nuPlazoDia;
	}
	public Date getFhFecInicio() {
		return fhFecInicio;
	}
	public void setFhFecInicio(Date fhFecInicio) {
		this.fhFecInicio = fhFecInicio;
	}
	public Date getFhFecVencimiento() {
		return fhFecVencimiento;
	}
	public void setFhFecVencimiento(Date fhFecVencimiento) {
		this.fhFecVencimiento = fhFecVencimiento;
	}
	public Double getImCapital() {
		return imCapital;
	}
	public void setImCapital(Double imCapital) {
		this.imCapital = imCapital;
	}
	public Double getImInteres() {
		return imInteres;
	}
	public void setImInteres(Double imInteres) {
		this.imInteres = imInteres;
	}
	public Double getImTasaPrecancel() {
		return imTasaPrecancel;
	}
	public void setImTasaPrecancel(Double imTasaPrecancel) {
		this.imTasaPrecancel = imTasaPrecancel;
	}
	public Double getImMontoFinal() {
		return imMontoFinal;
	}
	public void setImMontoFinal(Double imMontoFinal) {
		this.imMontoFinal = imMontoFinal;
	}
	public Double getImTipocambiospot() {
		return imTipocambiospot;
	}
	public void setImTipocambiospot(Double imTipocambiospot) {
		this.imTipocambiospot = imTipocambiospot;
	}
	public Integer getTpTipsettlement() {
		return tpTipsettlement;
	}
	public void setTpTipsettlement(Integer tpTipsettlement) {
		this.tpTipsettlement = tpTipsettlement;
	}
	public Integer getNuPuntofwd() {
		return nuPuntofwd;
	}
	public void setNuPuntofwd(Integer nuPuntofwd) {
		this.nuPuntofwd = nuPuntofwd;
	}
	public Double getImTipocambiofwd() {
		return imTipocambiofwd;
	}
	public void setImTipocambiofwd(Double imTipocambiofwd) {
		this.imTipocambiofwd = imTipocambiofwd;
	}
	public String getStEstado() {
		return stEstado;
	}
	public void setStEstado(String stEstado) {
		this.stEstado = stEstado;
	}
	public String getTpTipodeposito() {
		return tpTipodeposito;
	}
	public void setTpTipodeposito(String tpTipodeposito) {
		this.tpTipodeposito = tpTipodeposito;
	}
	public String getNbMnemonico() {
		return nbMnemonico;
	}
	public void setNbMnemonico(String nbMnemonico) {
		this.nbMnemonico = nbMnemonico;
	}
	public Double getImPrecioLimpio() {
		return imPrecioLimpio;
	}
	public void setImPrecioLimpio(Double imPrecioLimpio) {
		this.imPrecioLimpio = imPrecioLimpio;
	}
	public Double getImPrecioSucio() {
		return imPrecioSucio;
	}
	public void setImPrecioSucio(Double imPrecioSucio) {
		this.imPrecioSucio = imPrecioSucio;
	}
	public Double getImPrecioReferencia() {
		return imPrecioReferencia;
	}
	public void setImPrecioReferencia(Double imPrecioReferencia) {
		this.imPrecioReferencia = imPrecioReferencia;
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
	public Emisor getEmisor() {
		return emisor;
	}
	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}
	public Fondo getFondo() {
		return fondo;
	}
	public void setFondo(Fondo fondo) {
		this.fondo = fondo;
	}
	public General getContraparte() {
		return contraparte;
	}
	public void setContraparte(General contraparte) {
		this.contraparte = contraparte;
	}
	public General getCdIdTipoOperacion() {
		return cdIdTipoOperacion;
	}
	public void setCdIdTipoOperacion(General cdIdTipoOperacion) {
		this.cdIdTipoOperacion = cdIdTipoOperacion;
	}
	public List<OrdenEstado> getOrdenEstadoList() {
		return ordenEstadoList;
	}
	public void setOrdenEstadoList(List<OrdenEstado> ordenEstadoList) {
		this.ordenEstadoList = ordenEstadoList;
	}
	public List<DetalleOrden> getDetalleordenList() {
		return detalleordenList;
	}
	public void setDetalleordenList(List<DetalleOrden> detalleordenList) {
		this.detalleordenList = detalleordenList;
	}
    
    
}
