package com.pss.simulador.bs.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "TSI010_EMISOR", schema="BBVATESOR")
public class Emisor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "secEmisor", sequenceName = "BBVATESOR.SEQ_EMISOR", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secEmisor")
	@Column(name = "CD_IDEMISOR", nullable = false)
	private Integer cdIdemisor;
	@Column(name = "NB_NOM_EMISOR", length = 60)
	private String nbNomEmisor;
	@Column(name = "TP_RATING", length = 3)
	private String tpRating;
	@Column(name = "IM_PASIVO")
	private Double imPasivo;
	@Column(name = "TP_TIPEMISOR")
	private Integer tpTipemisor;
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
	@Column(name = "ST_ESTADO")
	private String stEstado;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cdIdemisor")
	private List<LimFondoEspecie> limFondoEspecieList;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "emisor")
	private List<LimitesEmisor> limitesEmisorList;

	public Emisor() {
	}

	public Emisor(Integer cdIdemisor) {
		this.cdIdemisor = cdIdemisor;
	}

	public Integer getCdIdemisor() {
		return cdIdemisor;
	}

	public void setCdIdemisor(Integer cdIdemisor) {
		this.cdIdemisor = cdIdemisor;
	}

	public String getNbNomEmisor() {
		return nbNomEmisor;
	}

	public void setNbNomEmisor(String nbNomEmisor) {
		this.nbNomEmisor = nbNomEmisor;
	}

	public String getTpRating() {
		return tpRating;
	}

	public void setTpRating(String tpRating) {
		this.tpRating = tpRating;
	}

	public Double getImPasivo() {
		return imPasivo;
	}

	public void setImPasivo(Double imPasivo) {
		this.imPasivo = imPasivo;
	}

	public Integer getTpTipemisor() {
		return tpTipemisor;
	}

	public void setTpTipemisor(Integer tpTipemisor) {
		this.tpTipemisor = tpTipemisor;
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

	public String getStEstado() {
		return stEstado;
	}

	public void setStEstado(String stEstado) {
		this.stEstado = stEstado;
	}

	public List<LimFondoEspecie> getLimFondoEspecieList() {
		return limFondoEspecieList;
	}

	public void setLimFondoEspecieList(List<LimFondoEspecie> limFondoEspecieList) {
		this.limFondoEspecieList = limFondoEspecieList;
	}

	public List<LimitesEmisor> getLimitesEmisorList() {
		return limitesEmisorList;
	}

	public void setLimitesEmisorList(List<LimitesEmisor> limitesEmisorList) {
		this.limitesEmisorList = limitesEmisorList;
	}

}
