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
@Table(name = "TSI007_PERFIL", schema="BBVATESOR")
public class Perfil implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "secPerfil", sequenceName = "BBVATESOR.SEQ_PERFIL", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secPerfil")
	@Column(name = "CD_IDPERFIL", nullable = false)
	private Integer cdIdperfil;
	@Column(name = "NB_MON_PERFIL", length = 40)
	private String nbMonPerfil;
	@Column(name = "FH_FEC_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecInicio;
	@Column(name = "FH_FEC_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhFecFin;
	@Column(name = "TP_TIPPERFIL")
	private Integer tpTipperfil;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
	private List<Usuario> usuarioList;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
	private List<PerfilFondo> perfilFondoList;

	public Perfil() {
	}

	public Perfil(Integer cdIdperfil) {
		this.cdIdperfil = cdIdperfil;
	}

	public Integer getCdIdperfil() {
		return cdIdperfil;
	}

	public void setCdIdperfil(Integer cdIdperfil) {
		this.cdIdperfil = cdIdperfil;
	}

	public String getNbMonPerfil() {
		return nbMonPerfil;
	}

	public void setNbMonPerfil(String nbMonPerfil) {
		this.nbMonPerfil = nbMonPerfil;
	}

	public Date getFhFecInicio() {
		return fhFecInicio;
	}

	public void setFhFecInicio(Date fhFecInicio) {
		this.fhFecInicio = fhFecInicio;
	}

	public Date getFhFecFin() {
		return fhFecFin;
	}

	public void setFhFecFin(Date fhFecFin) {
		this.fhFecFin = fhFecFin;
	}

	public Integer getTpTipperfil() {
		return tpTipperfil;
	}

	public void setTpTipperfil(Integer tpTipperfil) {
		this.tpTipperfil = tpTipperfil;
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

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	public List<PerfilFondo> getPerfilFondoList() {
		return perfilFondoList;
	}

	public void setPerfilFondoList(List<PerfilFondo> perfilFondoList) {
		this.perfilFondoList = perfilFondoList;
	}

}
