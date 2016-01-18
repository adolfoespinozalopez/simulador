package com.pss.simulador.bs.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "TSI005_GENERAL")
public class General implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CD_IDGENERAL", nullable = false)
	private Integer cdIdgeneral;
	@Column(name = "NB_DOMINIO", length = 30)
	private String nbDominio;
	@Column(name = "NB_DESC_GENERAL", length = 60)
	private String nbDescGeneral;
	@Column(name = "NB_VALOR_GENERAL", length = 40)
	private String nbValorGeneral;
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cdIdgeneral")
	private List<LimFondoEspecie> limFondoEspecieList;

	public General() {
	}

	public General(Integer cdIdgeneral) {
		this.cdIdgeneral = cdIdgeneral;
	}

	public Integer getCdIdgeneral() {
		return cdIdgeneral;
	}

	public void setCdIdgeneral(Integer cdIdgeneral) {
		this.cdIdgeneral = cdIdgeneral;
	}

	public String getNbDominio() {
		return nbDominio;
	}

	public void setNbDominio(String nbDominio) {
		this.nbDominio = nbDominio;
	}

	public String getNbDescGeneral() {
		return nbDescGeneral;
	}

	public void setNbDescGeneral(String nbDescGeneral) {
		this.nbDescGeneral = nbDescGeneral;
	}

	public String getNbValorGeneral() {
		return nbValorGeneral;
	}

	public void setNbValorGeneral(String nbValorGeneral) {
		this.nbValorGeneral = nbValorGeneral;
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

	public List<LimFondoEspecie> getLimFondoEspecieList() {
		return limFondoEspecieList;
	}

	public void setLimFondoEspecieList(List<LimFondoEspecie> limFondoEspecieList) {
		this.limFondoEspecieList = limFondoEspecieList;
	}

}
