package com.pss.simulador.bs.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TSI006_USUARIO")
public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CD_IDUSUARIO", nullable = false)
	private Integer cdIdusuario;
	@Column(name = "NB_NOM_USU", length = 40)
	private String nbNomUsu;
	@Column(name = "NB_APE_PAT_USU", length = 40)
	private String nbApePatUsu;
	@Column(name = "NB_APE_MAT_USU", length = 40)
	private String nbApeMatUsu;
	@Column(name = "CD_LOGIN", length = 10)
	private String cdLogin;
	@Column(name = "CD_CLAVE", length = 20)
	private String cdClave;
	@Column(name = "TP_TIPDOCUMENTO")
	private Integer tpTipdocumento;
	@Column(name = "NU_DOCUMENTO", length = 14)
	private String nuDocumento;
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
	@JoinColumn(name = "CD_IDPERFIL", referencedColumnName = "CD_IDPERFIL", nullable = false)
	@ManyToOne(optional = false)
	private Perfil cdIdperfil;

	public Usuario() {
	}

	public Usuario(Integer cdIdusuario) {
		this.cdIdusuario = cdIdusuario;
	}

	public Integer getCdIdusuario() {
		return cdIdusuario;
	}

	public void setCdIdusuario(Integer cdIdusuario) {
		this.cdIdusuario = cdIdusuario;
	}

	public String getNbNomUsu() {
		return nbNomUsu;
	}

	public void setNbNomUsu(String nbNomUsu) {
		this.nbNomUsu = nbNomUsu;
	}

	public String getNbApePatUsu() {
		return nbApePatUsu;
	}

	public void setNbApePatUsu(String nbApePatUsu) {
		this.nbApePatUsu = nbApePatUsu;
	}

	public String getNbApeMatUsu() {
		return nbApeMatUsu;
	}

	public void setNbApeMatUsu(String nbApeMatUsu) {
		this.nbApeMatUsu = nbApeMatUsu;
	}

	public String getCdLogin() {
		return cdLogin;
	}

	public void setCdLogin(String cdLogin) {
		this.cdLogin = cdLogin;
	}

	public String getCdClave() {
		return cdClave;
	}

	public void setCdClave(String cdClave) {
		this.cdClave = cdClave;
	}

	public Integer getTpTipdocumento() {
		return tpTipdocumento;
	}

	public void setTpTipdocumento(Integer tpTipdocumento) {
		this.tpTipdocumento = tpTipdocumento;
	}

	public String getNuDocumento() {
		return nuDocumento;
	}

	public void setNuDocumento(String nuDocumento) {
		this.nuDocumento = nuDocumento;
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

	public Perfil getCdIdperfil() {
		return cdIdperfil;
	}

	public void setCdIdperfil(Perfil cdIdperfil) {
		this.cdIdperfil = cdIdperfil;
	}
}
