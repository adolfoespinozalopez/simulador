package com.pss.simulador.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.util.Constante;
/**
*
* @author Adolfo Espinoza
* @version 1.0, 29/12/2015
* @since 1.0
*/
@Component
@ManagedBean(name = "loginController")
@RequestScoped
public class LoginController implements Serializable {
	
	//private static final Logger LOG = Logger.getLogger(LoginController.class);
	private static final long serialVersionUID = 1L;
	private String usuario = "";
    private String contrasena = "";
    private String usuarioNombre = "";
    private String perfilNombre = "";
    private boolean logueado = false;
    private boolean BEsAdmin = false;
    private boolean BEsInversion = false;
    private String SNuevaContrasena = "";
    private String SRepitaContrasena = "";
    
    private List<General> listaMoneda = new ArrayList<General>();
    @Resource(name = "generalManager")
    GeneralManager generalManager;
    private static final Logger LOG = Logger.getLogger(LoginController.class);
    
    
    public String login() {
        
    	try {
            LOG.info("generalManager ="+generalManager);
            listaMoneda =  generalManager.findByDomainAndState(Constante.DOMINIO_MONEDA, Constante.ESTADO_ACTIVO);
            for (General general : listaMoneda) {
                LOG.info("general ="+general.getCdIdgeneral());
            }
        } catch (Exception e) {
            LOG.error("ERROR EN load Moneda: " + e.getStackTrace());
            e.printStackTrace();
        }
        
        BEsInversion = false;
        BEsAdmin = false;
        if(usuario != null){
            if(usuario.equals("rjara")){
                BEsAdmin = true;
                usuarioNombre = "Rafael Jara";
                perfilNombre = "Administrador del Sistema";
            }else{
                usuarioNombre = "Pepe Perez del Aguila";
                perfilNombre = "Inversionista";
                BEsInversion = true;
            }
        }
        logueado = true;
        return "/home.jsf";
    }
    
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getUsuarioNombre() {
		return usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public String getPerfilNombre() {
		return perfilNombre;
	}

	public void setPerfilNombre(String perfilNombre) {
		this.perfilNombre = perfilNombre;
	}

	public boolean isLogueado() {
		return logueado;
	}

	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}

	public boolean isBEsAdmin() {
		return BEsAdmin;
	}

	public void setBEsAdmin(boolean bEsAdmin) {
		BEsAdmin = bEsAdmin;
	}

	public boolean isBEsInversion() {
		return BEsInversion;
	}

	public void setBEsInversion(boolean bEsInversion) {
		BEsInversion = bEsInversion;
	}

	public String getSNuevaContrasena() {
		return SNuevaContrasena;
	}

	public void setSNuevaContrasena(String sNuevaContrasena) {
		SNuevaContrasena = sNuevaContrasena;
	}

	public String getSRepitaContrasena() {
		return SRepitaContrasena;
	}

	public void setSRepitaContrasena(String sRepitaContrasena) {
		SRepitaContrasena = sRepitaContrasena;
	}

	public List<General> getListaMoneda() {
		return listaMoneda;
	}

	public void setListaMoneda(List<General> listaMoneda) {
		this.listaMoneda = listaMoneda;
	}
    
}
