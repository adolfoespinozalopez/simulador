package com.pss.simulador.bs.domain;
// default package
// Generated 16/01/2016 12:44:26 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tsi006Usuario generated by hbm2java
 */
@Entity
@Table(name = "TSI006_USUARIO")
public class Usuario implements java.io.Serializable {

	private BigDecimal cdIdusuario;
	private Perfil tsi007Perfil;
	private String nbNomUsu;
	private String nbApePatUsu;
	private String nbApeMatUsu;
	private String cdLogin;
	private String cdClave;
	private BigDecimal tpTipdocumento;
	private String nuDocumento;
	private Date fhFecCreacion;
	private String cdUsuCreacion;
	private Date fhFecModifica;
	private String cdUsuModifica;
	private Date fhFecElimina;
	private String cdUsuElimina;
	private Character stEstado;

	public Usuario() {
	}

	public Usuario(BigDecimal cdIdusuario, Perfil tsi007Perfil) {
		this.cdIdusuario = cdIdusuario;
		this.tsi007Perfil = tsi007Perfil;
	}

	public Usuario(BigDecimal cdIdusuario, Perfil tsi007Perfil,
			String nbNomUsu, String nbApePatUsu, String nbApeMatUsu,
			String cdLogin, String cdClave, BigDecimal tpTipdocumento,
			String nuDocumento, Date fhFecCreacion, String cdUsuCreacion,
			Date fhFecModifica, String cdUsuModifica, Date fhFecElimina,
			String cdUsuElimina, Character stEstado) {
		this.cdIdusuario = cdIdusuario;
		this.tsi007Perfil = tsi007Perfil;
		this.nbNomUsu = nbNomUsu;
		this.nbApePatUsu = nbApePatUsu;
		this.nbApeMatUsu = nbApeMatUsu;
		this.cdLogin = cdLogin;
		this.cdClave = cdClave;
		this.tpTipdocumento = tpTipdocumento;
		this.nuDocumento = nuDocumento;
		this.fhFecCreacion = fhFecCreacion;
		this.cdUsuCreacion = cdUsuCreacion;
		this.fhFecModifica = fhFecModifica;
		this.cdUsuModifica = cdUsuModifica;
		this.fhFecElimina = fhFecElimina;
		this.cdUsuElimina = cdUsuElimina;
		this.stEstado = stEstado;
	}

	@Id
	@Column(name = "CD_IDUSUARIO", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCdIdusuario() {
		return this.cdIdusuario;
	}

	public void setCdIdusuario(BigDecimal cdIdusuario) {
		this.cdIdusuario = cdIdusuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CD_IDPERFIL", nullable = false)
	public Perfil getTsi007Perfil() {
		return this.tsi007Perfil;
	}

	public void setTsi007Perfil(Perfil tsi007Perfil) {
		this.tsi007Perfil = tsi007Perfil;
	}

	@Column(name = "NB_NOM_USU", length = 40)
	public String getNbNomUsu() {
		return this.nbNomUsu;
	}

	public void setNbNomUsu(String nbNomUsu) {
		this.nbNomUsu = nbNomUsu;
	}

	@Column(name = "NB_APE_PAT_USU", length = 40)
	public String getNbApePatUsu() {
		return this.nbApePatUsu;
	}

	public void setNbApePatUsu(String nbApePatUsu) {
		this.nbApePatUsu = nbApePatUsu;
	}

	@Column(name = "NB_APE_MAT_USU", length = 40)
	public String getNbApeMatUsu() {
		return this.nbApeMatUsu;
	}

	public void setNbApeMatUsu(String nbApeMatUsu) {
		this.nbApeMatUsu = nbApeMatUsu;
	}

	@Column(name = "CD_LOGIN", length = 10)
	public String getCdLogin() {
		return this.cdLogin;
	}

	public void setCdLogin(String cdLogin) {
		this.cdLogin = cdLogin;
	}

	@Column(name = "CD_CLAVE", length = 20)
	public String getCdClave() {
		return this.cdClave;
	}

	public void setCdClave(String cdClave) {
		this.cdClave = cdClave;
	}

	@Column(name = "TP_TIPDOCUMENTO", precision = 22, scale = 0)
	public BigDecimal getTpTipdocumento() {
		return this.tpTipdocumento;
	}

	public void setTpTipdocumento(BigDecimal tpTipdocumento) {
		this.tpTipdocumento = tpTipdocumento;
	}

	@Column(name = "NU_DOCUMENTO", length = 14)
	public String getNuDocumento() {
		return this.nuDocumento;
	}

	public void setNuDocumento(String nuDocumento) {
		this.nuDocumento = nuDocumento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FH_FEC_CREACION", length = 7)
	public Date getFhFecCreacion() {
		return this.fhFecCreacion;
	}

	public void setFhFecCreacion(Date fhFecCreacion) {
		this.fhFecCreacion = fhFecCreacion;
	}

	@Column(name = "CD_USU_CREACION", length = 10)
	public String getCdUsuCreacion() {
		return this.cdUsuCreacion;
	}

	public void setCdUsuCreacion(String cdUsuCreacion) {
		this.cdUsuCreacion = cdUsuCreacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FH_FEC_MODIFICA", length = 7)
	public Date getFhFecModifica() {
		return this.fhFecModifica;
	}

	public void setFhFecModifica(Date fhFecModifica) {
		this.fhFecModifica = fhFecModifica;
	}

	@Column(name = "CD_USU_MODIFICA", length = 10)
	public String getCdUsuModifica() {
		return this.cdUsuModifica;
	}

	public void setCdUsuModifica(String cdUsuModifica) {
		this.cdUsuModifica = cdUsuModifica;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FH_FEC_ELIMINA", length = 7)
	public Date getFhFecElimina() {
		return this.fhFecElimina;
	}

	public void setFhFecElimina(Date fhFecElimina) {
		this.fhFecElimina = fhFecElimina;
	}

	@Column(name = "CD_USU_ELIMINA", length = 10)
	public String getCdUsuElimina() {
		return this.cdUsuElimina;
	}

	public void setCdUsuElimina(String cdUsuElimina) {
		this.cdUsuElimina = cdUsuElimina;
	}

	@Column(name = "ST_ESTADO", length = 1)
	public Character getStEstado() {
		return this.stEstado;
	}

	public void setStEstado(Character stEstado) {
		this.stEstado = stEstado;
	}

}
