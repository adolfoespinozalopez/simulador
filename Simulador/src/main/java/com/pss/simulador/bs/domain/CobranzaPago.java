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
@Table(name = "TSI003_COBRANZAPAGO")
public class CobranzaPago implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CD_IDCOBRANZAPAGO", nullable = false)
	private Integer cdIdcobranzapago;
	@Column(name = "CD_COD_FONDO", length = 4)
	private String cdCodFondo;
	@Column(name = "TIP_OPERACION", length = 6)
	private String tipOperacion;
	@Column(name = "FH_FEC_INGRESO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecIngreso;
	@Column(name = "FH_FEC_LIQ")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecLiq;
	@Column(name = "NB_DESCRIPCION", length = 100)
	private String nbDescripcion;
	@Column(name = "TP_MONEDA")
	private String tpMoneda;
	@Column(name = "IM_MONTO")
	private Double imMonto;
	@Column(name = "IM_MTO_MON_FONDO")
	private Double imMtoMonFondo;
	@Column(name = "CD_SIGLA", length = 3)
	private String cdSigla;

	public CobranzaPago() {
	}

	public CobranzaPago(Integer cdIdcobranzapago) {
		this.cdIdcobranzapago = cdIdcobranzapago;
	}

	public Integer getCdIdcobranzapago() {
		return cdIdcobranzapago;
	}

	public void setCdIdcobranzapago(Integer cdIdcobranzapago) {
		this.cdIdcobranzapago = cdIdcobranzapago;
	}

	public String getCdCodFondo() {
		return cdCodFondo;
	}

	public void setCdCodFondo(String cdCodFondo) {
		this.cdCodFondo = cdCodFondo;
	}

	public String getTipOperacion() {
		return tipOperacion;
	}

	public void setTipOperacion(String tipOperacion) {
		this.tipOperacion = tipOperacion;
	}

	public Date getFhFecIngreso() {
		return fhFecIngreso;
	}

	public void setFhFecIngreso(Date fhFecIngreso) {
		this.fhFecIngreso = fhFecIngreso;
	}

	public Date getFhFecLiq() {
		return fhFecLiq;
	}

	public void setFhFecLiq(Date fhFecLiq) {
		this.fhFecLiq = fhFecLiq;
	}

	public String getNbDescripcion() {
		return nbDescripcion;
	}

	public void setNbDescripcion(String nbDescripcion) {
		this.nbDescripcion = nbDescripcion;
	}

	public String getTpMoneda() {
		return tpMoneda;
	}

	public void setTpMoneda(String tpMoneda) {
		this.tpMoneda = tpMoneda;
	}

	public Double getImMonto() {
		return imMonto;
	}

	public void setImMonto(Double imMonto) {
		this.imMonto = imMonto;
	}

	public Double getImMtoMonFondo() {
		return imMtoMonFondo;
	}

	public void setImMtoMonFondo(Double imMtoMonFondo) {
		this.imMtoMonFondo = imMtoMonFondo;
	}

	public String getCdSigla() {
		return cdSigla;
	}

	public void setCdSigla(String cdSigla) {
		this.cdSigla = cdSigla;
	}

}
