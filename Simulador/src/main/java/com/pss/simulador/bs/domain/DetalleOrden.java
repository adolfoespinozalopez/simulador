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
@Table(name="TSI015_DETALLEORDEN", schema="BBVATESOR")
public class DetalleOrden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "secDetalleOrden", sequenceName = "BBVATESOR.SEQ_DETALLEORDEN", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secDetalleOrden")
	@Column(name="CD_IDDETALLE")
	private Integer cdIddetalle;
	@Column(name="CD_IDINFOPORT")
	private Integer cdIdinfoport;
	@Column(name = "NB_NOM_FONDO", length = 40)
	private String nbNomFondo;
	@Column(name = "TP_TIPFONDO")
	private String tpTipfondo;
	@Column(name = "NB_NOM_EMISOR", length = 60)
	private String nbNomEmisor;
	@Column(name = "TP_RATING_EMISOR", length = 4)
	private String tpRatingEmisor;
	@Column(name = "NB_ESPECIE", length = 40)
	private String nbEspecie;
	@Column(name = "FH_FEC_EMISION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecEmision;
	@Column(name = "FH_FEC_VENCIMIENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecVencimiento;
	@Column(name = "IM_NOMINAL_EN_MIL")
	private Double imNominalEnMil;
	@Column(name = "IM_CUPON")
	private Double imCupon;
	@Column(name = "FH_FEC_ULT_CUPON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecUltCupon;
	@Column(name = "TP_MODALIDAD")
	private String tpModalidad;
	@Column(name = "IM_PRECIO_LIMPIO")
	private Double imPrecioLimpio;
	@Column(name = "IM_PRECIO_SUCIO")
	private Double imPrecioSucio;
	@Column(name = "IM_VALOR_SIN_INTER")
	private Double imValorSinInter;
	@Column(name = "IM_INTERES_CORRID")
	private Double imInteresCorrid;
	@Column(name = "IM_VALOR_MON_REF")
	private Double imValorMonRef;
	@Column(name = "TP_ABREV_MONEDA", length = 3)
	private String tpAbrevMoneda;
	@Column(name = "IM_VALOR_MON_LOCAL")
	private Double imValorMonLocal;
	@Column(name = "IM_TOT_CTAS_COBRAR")
	private Double imTotCtasCobrar;
	@Column(name = "IM_TOT_CTAS_PAGAR")
	private Double imTotCtasPagar;
	@Column(name = "NU_PERIODO")
	private Integer nuPeriodo;
	@Column(name = "IM_YTM")
	private Double imYtm;
	@Column(name = "IM_DURAC_NORM")
	private Double imDuracNorm;
	@Column(name = "IM_DURAC_MODIF")
	private Double imDuracModif;
	@Column(name = "TP_CLASIFICA", length = 6)
	private String tpClasifica;
	@Column(name = "IM_PRECIO_ACT")
	private Double imPrecioAct;
	@Column(name = "IM_PREC_COM")
	private Double imPrecCom;
	@Column(name = "NB_ISIN", length = 15)
	private String nbIsin;
	@Column(name = "NB_MNEMONICO", length = 15)
	private String nbMnemonico;
	@Column(name = "NU_NUM_DIAS_VCTO")
	private Integer nuNumDiasVcto;
	@Column(name = "FH_FECVCTO_SGT_CUP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecvctoSgtCup;
	@Column(name = "FH_FEC_ULT_OPERAC")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecUltOperac;
	@Column(name = "IM_DURAC_NOR_LIBOR")
	private Double imDuracNorLibor;
	@Column(name = "IM_COMPRA_T_MAS_N")
	private Double imCompraTMasN;
	@Column(name = "NB_OBSERVACION", length = 100)
	private String nbObservacion;
	@Column(name = "IM_VALOR_POR_DURAC")
	private Double imValorPorDurac;
	@Column(name = "IM_VALOR_POR_YTM")
	private Double imValorPorYtm;
	@Column(name = "NU_DIA_PARA_VENC")
	private Integer nuDiaParaVenc;
	@Column(name = "ST_ESTADO_PORT", length = 9)
	private String stEstadoPort;
	@Column(name = "ST_CONDICION")
	private String stCondicion;
	@Column(name = "ST_ESTADO")
	private String stEstado;
	@Column(name = "FH_FEC_IMPORTA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecImporta;
	@Column(name = "TP_OPERACION")
	private String tpOperacion;
	@JoinColumn(name = "CD_IDORDEN", referencedColumnName = "CD_IDORDEN")
    @ManyToOne(optional = false)
	private Orden orden;

	public DetalleOrden() {
	}

	public Integer getCdIddetalle() {
		return cdIddetalle;
	}

	public void setCdIddetalle(Integer cdIddetalle) {
		this.cdIddetalle = cdIddetalle;
	}

	public Integer getCdIdinfoport() {
		return cdIdinfoport;
	}

	public void setCdIdinfoport(Integer cdIdinfoport) {
		this.cdIdinfoport = cdIdinfoport;
	}

	public String getNbNomFondo() {
		return nbNomFondo;
	}

	public void setNbNomFondo(String nbNomFondo) {
		this.nbNomFondo = nbNomFondo;
	}

	public String getTpTipfondo() {
		return tpTipfondo;
	}

	public void setTpTipfondo(String tpTipfondo) {
		this.tpTipfondo = tpTipfondo;
	}

	public String getNbNomEmisor() {
		return nbNomEmisor;
	}

	public void setNbNomEmisor(String nbNomEmisor) {
		this.nbNomEmisor = nbNomEmisor;
	}

	public String getTpRatingEmisor() {
		return tpRatingEmisor;
	}

	public void setTpRatingEmisor(String tpRatingEmisor) {
		this.tpRatingEmisor = tpRatingEmisor;
	}

	public String getNbEspecie() {
		return nbEspecie;
	}

	public void setNbEspecie(String nbEspecie) {
		this.nbEspecie = nbEspecie;
	}

	public Date getFhFecEmision() {
		return fhFecEmision;
	}

	public void setFhFecEmision(Date fhFecEmision) {
		this.fhFecEmision = fhFecEmision;
	}

	public Date getFhFecVencimiento() {
		return fhFecVencimiento;
	}

	public void setFhFecVencimiento(Date fhFecVencimiento) {
		this.fhFecVencimiento = fhFecVencimiento;
	}

	public Double getImNominalEnMil() {
		return imNominalEnMil;
	}

	public void setImNominalEnMil(Double imNominalEnMil) {
		this.imNominalEnMil = imNominalEnMil;
	}

	public Double getImCupon() {
		return imCupon;
	}

	public void setImCupon(Double imCupon) {
		this.imCupon = imCupon;
	}

	public Date getFhFecUltCupon() {
		return fhFecUltCupon;
	}

	public void setFhFecUltCupon(Date fhFecUltCupon) {
		this.fhFecUltCupon = fhFecUltCupon;
	}

	public String getTpModalidad() {
		return tpModalidad;
	}

	public void setTpModalidad(String tpModalidad) {
		this.tpModalidad = tpModalidad;
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

	public Double getImValorSinInter() {
		return imValorSinInter;
	}

	public void setImValorSinInter(Double imValorSinInter) {
		this.imValorSinInter = imValorSinInter;
	}

	public Double getImInteresCorrid() {
		return imInteresCorrid;
	}

	public void setImInteresCorrid(Double imInteresCorrid) {
		this.imInteresCorrid = imInteresCorrid;
	}

	public Double getImValorMonRef() {
		return imValorMonRef;
	}

	public void setImValorMonRef(Double imValorMonRef) {
		this.imValorMonRef = imValorMonRef;
	}

	public String getTpAbrevMoneda() {
		return tpAbrevMoneda;
	}

	public void setTpAbrevMoneda(String tpAbrevMoneda) {
		this.tpAbrevMoneda = tpAbrevMoneda;
	}

	public Double getImValorMonLocal() {
		return imValorMonLocal;
	}

	public void setImValorMonLocal(Double imValorMonLocal) {
		this.imValorMonLocal = imValorMonLocal;
	}

	public Double getImTotCtasCobrar() {
		return imTotCtasCobrar;
	}

	public void setImTotCtasCobrar(Double imTotCtasCobrar) {
		this.imTotCtasCobrar = imTotCtasCobrar;
	}

	public Double getImTotCtasPagar() {
		return imTotCtasPagar;
	}

	public void setImTotCtasPagar(Double imTotCtasPagar) {
		this.imTotCtasPagar = imTotCtasPagar;
	}

	public Integer getNuPeriodo() {
		return nuPeriodo;
	}

	public void setNuPeriodo(Integer nuPeriodo) {
		this.nuPeriodo = nuPeriodo;
	}

	public Double getImYtm() {
		return imYtm;
	}

	public void setImYtm(Double imYtm) {
		this.imYtm = imYtm;
	}

	public Double getImDuracNorm() {
		return imDuracNorm;
	}

	public void setImDuracNorm(Double imDuracNorm) {
		this.imDuracNorm = imDuracNorm;
	}

	public Double getImDuracModif() {
		return imDuracModif;
	}

	public void setImDuracModif(Double imDuracModif) {
		this.imDuracModif = imDuracModif;
	}

	public String getTpClasifica() {
		return tpClasifica;
	}

	public void setTpClasifica(String tpClasifica) {
		this.tpClasifica = tpClasifica;
	}

	public Double getImPrecioAct() {
		return imPrecioAct;
	}

	public void setImPrecioAct(Double imPrecioAct) {
		this.imPrecioAct = imPrecioAct;
	}

	public Double getImPrecCom() {
		return imPrecCom;
	}

	public void setImPrecCom(Double imPrecCom) {
		this.imPrecCom = imPrecCom;
	}

	public String getNbIsin() {
		return nbIsin;
	}

	public void setNbIsin(String nbIsin) {
		this.nbIsin = nbIsin;
	}

	public String getNbMnemonico() {
		return nbMnemonico;
	}

	public void setNbMnemonico(String nbMnemonico) {
		this.nbMnemonico = nbMnemonico;
	}

	public Integer getNuNumDiasVcto() {
		return nuNumDiasVcto;
	}

	public void setNuNumDiasVcto(Integer nuNumDiasVcto) {
		this.nuNumDiasVcto = nuNumDiasVcto;
	}

	public Date getFhFecvctoSgtCup() {
		return fhFecvctoSgtCup;
	}

	public void setFhFecvctoSgtCup(Date fhFecvctoSgtCup) {
		this.fhFecvctoSgtCup = fhFecvctoSgtCup;
	}

	public Date getFhFecUltOperac() {
		return fhFecUltOperac;
	}

	public void setFhFecUltOperac(Date fhFecUltOperac) {
		this.fhFecUltOperac = fhFecUltOperac;
	}

	public Double getImDuracNorLibor() {
		return imDuracNorLibor;
	}

	public void setImDuracNorLibor(Double imDuracNorLibor) {
		this.imDuracNorLibor = imDuracNorLibor;
	}

	public Double getImCompraTMasN() {
		return imCompraTMasN;
	}

	public void setImCompraTMasN(Double imCompraTMasN) {
		this.imCompraTMasN = imCompraTMasN;
	}

	public String getNbObservacion() {
		return nbObservacion;
	}

	public void setNbObservacion(String nbObservacion) {
		this.nbObservacion = nbObservacion;
	}

	public Double getImValorPorDurac() {
		return imValorPorDurac;
	}

	public void setImValorPorDurac(Double imValorPorDurac) {
		this.imValorPorDurac = imValorPorDurac;
	}

	public Double getImValorPorYtm() {
		return imValorPorYtm;
	}

	public void setImValorPorYtm(Double imValorPorYtm) {
		this.imValorPorYtm = imValorPorYtm;
	}

	public Integer getNuDiaParaVenc() {
		return nuDiaParaVenc;
	}

	public void setNuDiaParaVenc(Integer nuDiaParaVenc) {
		this.nuDiaParaVenc = nuDiaParaVenc;
	}

	public String getStEstadoPort() {
		return stEstadoPort;
	}

	public void setStEstadoPort(String stEstadoPort) {
		this.stEstadoPort = stEstadoPort;
	}

	public String getStCondicion() {
		return stCondicion;
	}

	public void setStCondicion(String stCondicion) {
		this.stCondicion = stCondicion;
	}

	public String getStEstado() {
		return stEstado;
	}

	public void setStEstado(String stEstado) {
		this.stEstado = stEstado;
	}

	public Date getFhFecImporta() {
		return fhFecImporta;
	}

	public void setFhFecImporta(Date fhFecImporta) {
		this.fhFecImporta = fhFecImporta;
	}

	public String getTpOperacion() {
		return tpOperacion;
	}

	public void setTpOperacion(String tpOperacion) {
		this.tpOperacion = tpOperacion;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	
}