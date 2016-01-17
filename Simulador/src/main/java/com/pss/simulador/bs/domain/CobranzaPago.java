package com.pss.simulador.bs.domain;

// default package
// Generated 16/01/2016 12:44:26 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tsi003Cobranzapago generated by hbm2java
 */
@Entity
@Table(name = "TSI003_COBRANZAPAGO")
public class CobranzaPago implements java.io.Serializable {

	private BigDecimal cdIdcobranzapago;
	private String cdCodFondo;
	private String tipOperacion;
	private Date fhFecIngreso;
	private Date fhFecLiq;
	private String nbDescripcion;
	private Character tpMoneda;
	private BigDecimal imMonto;
	private BigDecimal imMtoMonFondo;
	private String cdSigla;

	public CobranzaPago() {
	}

	public CobranzaPago(BigDecimal cdIdcobranzapago) {
		this.cdIdcobranzapago = cdIdcobranzapago;
	}

	public CobranzaPago(BigDecimal cdIdcobranzapago, String cdCodFondo,
			String tipOperacion, Date fhFecIngreso, Date fhFecLiq,
			String nbDescripcion, Character tpMoneda, BigDecimal imMonto,
			BigDecimal imMtoMonFondo, String cdSigla) {
		this.cdIdcobranzapago = cdIdcobranzapago;
		this.cdCodFondo = cdCodFondo;
		this.tipOperacion = tipOperacion;
		this.fhFecIngreso = fhFecIngreso;
		this.fhFecLiq = fhFecLiq;
		this.nbDescripcion = nbDescripcion;
		this.tpMoneda = tpMoneda;
		this.imMonto = imMonto;
		this.imMtoMonFondo = imMtoMonFondo;
		this.cdSigla = cdSigla;
	}

	@Id
	@Column(name = "CD_IDCOBRANZAPAGO", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCdIdcobranzapago() {
		return this.cdIdcobranzapago;
	}

	public void setCdIdcobranzapago(BigDecimal cdIdcobranzapago) {
		this.cdIdcobranzapago = cdIdcobranzapago;
	}

	@Column(name = "CD_COD_FONDO", length = 4)
	public String getCdCodFondo() {
		return this.cdCodFondo;
	}

	public void setCdCodFondo(String cdCodFondo) {
		this.cdCodFondo = cdCodFondo;
	}

	@Column(name = "TIP_OPERACION", length = 6)
	public String getTipOperacion() {
		return this.tipOperacion;
	}

	public void setTipOperacion(String tipOperacion) {
		this.tipOperacion = tipOperacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FH_FEC_INGRESO", length = 7)
	public Date getFhFecIngreso() {
		return this.fhFecIngreso;
	}

	public void setFhFecIngreso(Date fhFecIngreso) {
		this.fhFecIngreso = fhFecIngreso;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FH_FEC_LIQ", length = 7)
	public Date getFhFecLiq() {
		return this.fhFecLiq;
	}

	public void setFhFecLiq(Date fhFecLiq) {
		this.fhFecLiq = fhFecLiq;
	}

	@Column(name = "NB_DESCRIPCION", length = 100)
	public String getNbDescripcion() {
		return this.nbDescripcion;
	}

	public void setNbDescripcion(String nbDescripcion) {
		this.nbDescripcion = nbDescripcion;
	}

	@Column(name = "TP_MONEDA", length = 1)
	public Character getTpMoneda() {
		return this.tpMoneda;
	}

	public void setTpMoneda(Character tpMoneda) {
		this.tpMoneda = tpMoneda;
	}

	@Column(name = "IM_MONTO", precision = 22, scale = 0)
	public BigDecimal getImMonto() {
		return this.imMonto;
	}

	public void setImMonto(BigDecimal imMonto) {
		this.imMonto = imMonto;
	}

	@Column(name = "IM_MTO_MON_FONDO", precision = 22, scale = 0)
	public BigDecimal getImMtoMonFondo() {
		return this.imMtoMonFondo;
	}

	public void setImMtoMonFondo(BigDecimal imMtoMonFondo) {
		this.imMtoMonFondo = imMtoMonFondo;
	}

	@Column(name = "CD_SIGLA", length = 3)
	public String getCdSigla() {
		return this.cdSigla;
	}

	public void setCdSigla(String cdSigla) {
		this.cdSigla = cdSigla;
	}

}
