package com.pss.simulador.web.controller;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.grupobbva.bc.per.tele.ldap.comunes.IILDPeExcepcion;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.grupobbva.bc.per.tele.seguridad.ServiciosSeguridadBbva;
import com.pss.simulador.bs.domain.Usuario;
import com.pss.simulador.bs.service.AccesoManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.web.bean.UsuarioSession;
import com.pss.simulador.web.controller.generic.GenericController;
/**
*
* @author Adolfo Espinoza
* @version 1.0, 29/12/2015
* @since 1.0
*/
@Component
@Scope("session")
public class LoginController extends GenericController implements Serializable  {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AccesoManager accesoManager;
    private boolean logueado;
    
    public void login() {
    	String codigoUsuario = "";
    	try {

	    	ServiciosSeguridadBbva ssBbva = new ServiciosSeguridadBbva(this.getRequest());
			if (ssBbva != null) {
				ssBbva.obtener_ID();
				codigoUsuario = (ssBbva!=null && ssBbva.getUsuario()!=null)? ssBbva.getUsuario().toUpperCase():"";
			}
			
    	} catch (Exception e) {
			logger.error(e, e);
		}
    	if (codigoUsuario == null || codigoUsuario.isEmpty() || codigoUsuario.equals("No Autenticado")){
			codigoUsuario = this.getRequest().getParameter("frmLoginCuadro:codUsuarioLocal");	
		}
		IILDPeUsuario usuarioLdap = null;
//		pe.com.bbva.ws.ldap.cliente.wsmodel.Usuario usuarioWsLdap;
		try {
    		// Validación por BD - IIWX
			usuarioLdap = IILDPeUsuario.recuperarUsuario(codigoUsuario);
			// Validación por IDM
//			WsLdapClient client = new WsLdapClientImpl(Constante.WSLDAP_ENDPOINT);
//			usuarioWsLdap = client.obtenerUsuarioPorCodigoUsuario(codigoUsuario);
		} catch (IILDPeExcepcion e) {
			logger.error(e,e);
		} 
//		catch (WSLdapException_Exception e) {
//			logger.error(e,e);
//		}
		
		if(usuarioLdap!=null){
			Usuario usuario = accesoManager.findByRegUser(usuarioLdap.getUID());
			if (usuario!=null){
				this.asignarValoresUsuario(usuarioLdap,usuario);	
			}
			
		}
		logueado = true;
    }
    
    public String loginToHome(){
    	if (this.getUsuarioSession()!=null){
    		return "to_home";	
    	}else{
    		return "to_sinacceso";
    	}
    	
    }
	/**
	 * 
	 * @param usuarioLdap
	 */
	private void asignarValoresUsuario(IILDPeUsuario usuarioLdap,Usuario usuarioPerf) {
		UsuarioSession usuarioSession = new UsuarioSession();
		usuarioSession.setUsuario(usuarioLdap);
		usuarioSession.setPerfil(usuarioPerf.getPerfil());
		if(usuarioPerf.getPerfil().getTpTipperfil().equals(Constante.Perfil.TIPO_ADMINISTRADOR)){
			usuarioSession.setbEsAdmin(true);
			usuarioSession.setbEsInversion(false);
		}else{
			usuarioSession.setbEsAdmin(false);
			usuarioSession.setbEsInversion(true);
		}
		this.getSession().setAttribute(Constante.__USUARIO_SESSION__, usuarioSession);
	}

	public boolean isLogueado() {
		return logueado;
	}

	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}
    
}
