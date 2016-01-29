package com.pss.simulador.bs.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Adolfo Espinoza
 * @version 1.0, 12/01/2016
 * @since 1.0
 */
@Entity
@Table(name = "TSI001_SALDO", schema="BBVATESOR")
public class Saldo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CD_IDSALDO", nullable = false)
	private Integer cdIdsaldo;
	@Column(name = "CD_COD_FONDO", length = 4)
	private String cdCodFondo;
	@Column(name = "NB_NOM_FONDO", length = 40)
	private String nbNomFondo;
	@Column(name = "TP_TIPMONEDA", length = 3)
	private String tpTipmoneda;
	@Column(name = "NU_NUM_CUENTA", length = 21)
	private String nuNumCuenta;
	@Column(name = "TO_SALDO_INICIAL")
	private Double toSaldoInicial;
	@Column(name = "IM_DIF_RESCATE")
	private Double imDifRescate;
	@Column(name = "IM_SUSCRIPCION")
	private Double imSuscripcion;
	@Column(name = "IM_RESCATE")
	private Double imRescate;
	@Column(name = "IM_VENCIMIENTO")
	private Double imVencimiento;
	@Column(name = "IM_COMPRAS_TMASN")
	private Double imComprasTmasn;
	@Column(name = "IM_VENTAS_TMASN")
	private Double imVentasTmasn;
	@Column(name = "IM_COMPRA")
	private Double imCompra;
	@Column(name = "IM_VENTA")
	private Double imVenta;
	@Column(name = "IM_CXP_ACCIONES")
	private Double imCxpAcciones;
	@Column(name = "IM_CXC_ACCIONES")
	private Double imCxcAcciones;
	@Column(name = "IM_COMISION")
	private Double imComision;
	@Column(name = "TO_SALDO_FINAL")
	private Double toSaldoFinal;
	@Column(name = "IM_RESCATE_TMASN")
	private Double imRescateTmasn;
	@Column(name = "IM_CARTE_TMENOSUNO")
	private Double imCarteTmenosuno;
	@Column(name = "IM_PORC_LIQUIDEZ")
	private Double imPorcLiquidez;
	@Column(name = "TO_SALDO_INVERTIR")
	private Double toSaldoInvertir;
	@Column(name = "NB_OBSERVACION", length = 100)
	private String nbObservacion;
	@Column(name = "PC_PORC_PATRIMONIO")
	private Double pcPorcPatrimonio;
	@Column(name = "IM_PAT_MON_FONDO")
	private Double imPatMonFondo;
	@Column(name = "PC_PORC_PAT_TOT")
	private Double pcPorcPatTot;
	@Column(name = "PC_PORC_CONTINENTA")
	private Double pcPorcContinenta;
	@Column(name = "PC_PORC_TOTAL")
	private Double pcPorcTotal;
	@Column(name = "IM_MTO_EXCESO")
	private Double imMtoExceso;
	@Column(name = "PC_PORC_ACCIONES")
	private Double pcPorcAcciones;
	@Column(name = "IM_VINCULADO")
	private Double imVinculado;
	@Column(name = "IM_LIQUIDEZ_INMEDI")
	private Double imLiquidezInmedi;
	@Column(name = "IM_SOLICITUD_SUSC")
	private Double imSolicitudSusc;
	@Column(name = "IM_SOLICITUD_RESC")
	private Double imSolicitudResc;
	@Column(name = "IM_CXP_PENDIENTE")
	private Double imCxpPendiente;
	@Column(name = "IM_SALDO_TMASN")
	private Double imSaldoTmasn;
	@Column(name = "ST_ESTADO")
    private String stEstado;
    @Column(name = "FH_FEC_IMPORTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fhFecImporta;
    
	public Saldo() {
	}

	public Saldo(Integer cdIdsaldo) {
		this.cdIdsaldo = cdIdsaldo;
	}

	public Integer getCdIdsaldo() {
		return cdIdsaldo;
	}

	public void setCdIdsaldo(Integer cdIdsaldo) {
		this.cdIdsaldo = cdIdsaldo;
	}

	public String getCdCodFondo() {
		return cdCodFondo;
	}

	public void setCdCodFondo(String cdCodFondo) {
		this.cdCodFondo = cdCodFondo;
	}

	public String getNbNomFondo() {
		return nbNomFondo;
	}

	public void setNbNomFondo(String nbNomFondo) {
		this.nbNomFondo = nbNomFondo;
	}

	public String getTpTipmoneda() {
		return tpTipmoneda;
	}

	public void setTpTipmoneda(String tpTipmoneda) {
		this.tpTipmoneda = tpTipmoneda;
	}

	public String getNuNumCuenta() {
		return nuNumCuenta;
	}

	public void setNuNumCuenta(String nuNumCuenta) {
		this.nuNumCuenta = nuNumCuenta;
	}

	public Double getToSaldoInicial() {
		return toSaldoInicial;
	}

	public void setToSaldoInicial(Double toSaldoInicial) {
		this.toSaldoInicial = toSaldoInicial;
	}

	public Double getImDifRescate() {
		return imDifRescate;
	}

	public void setImDifRescate(Double imDifRescate) {
		this.imDifRescate = imDifRescate;
	}

	public Double getImSuscripcion() {
		return imSuscripcion;
	}

	public void setImSuscripcion(Double imSuscripcion) {
		this.imSuscripcion = imSuscripcion;
	}

	public Double getImRescate() {
		return imRescate;
	}

	public void setImRescate(Double imRescate) {
		this.imRescate = imRescate;
	}

	public Double getImVencimiento() {
		return imVencimiento;
	}

	public void setImVencimiento(Double imVencimiento) {
		this.imVencimiento = imVencimiento;
	}

	public Double getImComprasTmasn() {
		return imComprasTmasn;
	}

	public void setImComprasTmasn(Double imComprasTmasn) {
		this.imComprasTmasn = imComprasTmasn;
	}

	public Double getImVentasTmasn() {
		return imVentasTmasn;
	}

	public void setImVentasTmasn(Double imVentasTmasn) {
		this.imVentasTmasn = imVentasTmasn;
	}

	public Double getImCompra() {
		return imCompra;
	}

	public void setImCompra(Double imCompra) {
		this.imCompra = imCompra;
	}

	public Double getImVenta() {
		return imVenta;
	}

	public void setImVenta(Double imVenta) {
		this.imVenta = imVenta;
	}

	public Double getImCxpAcciones() {
		return imCxpAcciones;
	}

	public void setImCxpAcciones(Double imCxpAcciones) {
		this.imCxpAcciones = imCxpAcciones;
	}

	public Double getImCxcAcciones() {
		return imCxcAcciones;
	}

	public void setImCxcAcciones(Double imCxcAcciones) {
		this.imCxcAcciones = imCxcAcciones;
	}

	public Double getImComision() {
		return imComision;
	}

	public void setImComision(Double imComision) {
		this.imComision = imComision;
	}

	public Double getToSaldoFinal() {
		return toSaldoFinal;
	}

	public void setToSaldoFinal(Double toSaldoFinal) {
		this.toSaldoFinal = toSaldoFinal;
	}

	public Double getImRescateTmasn() {
		return imRescateTmasn;
	}

	public void setImRescateTmasn(Double imRescateTmasn) {
		this.imRescateTmasn = imRescateTmasn;
	}

	public Double getImCarteTmenosuno() {
		return imCarteTmenosuno;
	}

	public void setImCarteTmenosuno(Double imCarteTmenosuno) {
		this.imCarteTmenosuno = imCarteTmenosuno;
	}

	public Double getImPorcLiquidez() {
		return imPorcLiquidez;
	}

	public void setImPorcLiquidez(Double imPorcLiquidez) {
		this.imPorcLiquidez = imPorcLiquidez;
	}

	public Double getToSaldoInvertir() {
		return toSaldoInvertir;
	}

	public void setToSaldoInvertir(Double toSaldoInvertir) {
		this.toSaldoInvertir = toSaldoInvertir;
	}

	public String getNbObservacion() {
		return nbObservacion;
	}

	public void setNbObservacion(String nbObservacion) {
		this.nbObservacion = nbObservacion;
	}

	public Double getPcPorcPatrimonio() {
		return pcPorcPatrimonio;
	}

	public void setPcPorcPatrimonio(Double pcPorcPatrimonio) {
		this.pcPorcPatrimonio = pcPorcPatrimonio;
	}

	public Double getImPatMonFondo() {
		return imPatMonFondo;
	}

	public void setImPatMonFondo(Double imPatMonFondo) {
		this.imPatMonFondo = imPatMonFondo;
	}

	public Double getPcPorcPatTot() {
		return pcPorcPatTot;
	}

	public void setPcPorcPatTot(Double pcPorcPatTot) {
		this.pcPorcPatTot = pcPorcPatTot;
	}

	public Double getPcPorcContinenta() {
		return pcPorcContinenta;
	}

	public void setPcPorcContinenta(Double pcPorcContinenta) {
		this.pcPorcContinenta = pcPorcContinenta;
	}

	public Double getPcPorcTotal() {
		return pcPorcTotal;
	}

	public void setPcPorcTotal(Double pcPorcTotal) {
		this.pcPorcTotal = pcPorcTotal;
	}

	public Double getImMtoExceso() {
		return imMtoExceso;
	}

	public void setImMtoExceso(Double imMtoExceso) {
		this.imMtoExceso = imMtoExceso;
	}

	public Double getPcPorcAcciones() {
		return pcPorcAcciones;
	}

	public void setPcPorcAcciones(Double pcPorcAcciones) {
		this.pcPorcAcciones = pcPorcAcciones;
	}

	public Double getImVinculado() {
		return imVinculado;
	}

	public void setImVinculado(Double imVinculado) {
		this.imVinculado = imVinculado;
	}

	public Double getImLiquidezInmedi() {
		return imLiquidezInmedi;
	}

	public void setImLiquidezInmedi(Double imLiquidezInmedi) {
		this.imLiquidezInmedi = imLiquidezInmedi;
	}

	public Double getImSolicitudSusc() {
		return imSolicitudSusc;
	}

	public void setImSolicitudSusc(Double imSolicitudSusc) {
		this.imSolicitudSusc = imSolicitudSusc;
	}

	public Double getImSolicitudResc() {
		return imSolicitudResc;
	}

	public void setImSolicitudResc(Double imSolicitudResc) {
		this.imSolicitudResc = imSolicitudResc;
	}

	public Double getImCxpPendiente() {
		return imCxpPendiente;
	}

	public void setImCxpPendiente(Double imCxpPendiente) {
		this.imCxpPendiente = imCxpPendiente;
	}

	public Double getImSaldoTmasn() {
		return imSaldoTmasn;
	}

	public void setImSaldoTmasn(Double imSaldoTmasn) {
		this.imSaldoTmasn = imSaldoTmasn;
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

}
