package com.pss.simulador.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.grupobbva.bc.per.tele.ldap.comunes.IILDPeExcepcion;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.grupobbva.bc.per.tele.seguridad.ServiciosSeguridadBbva;
import com.pss.simulador.bs.domain.General;
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
   
    private List<General> listaMoneda = new ArrayList<General>();
    
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
		try {
			usuarioLdap = IILDPeUsuario.recuperarUsuario(codigoUsuario);
		} catch (IILDPeExcepcion e) {
			logger.error(e);
		}
		
		if(usuarioLdap!=null){
			Usuario usuario = accesoManager.findByRegUser(usuarioLdap.getUID());
			if (usuario!=null){
				this.asignarValoresUsuario(usuarioLdap,usuario);	
			}
			
		}
    }
    public String loginToHome(){
    	if (this.getSession().getAttribute(Constante.__USUARIO_SESSION__)!=null){
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
		usuarioSession.setPerfil(usuarioPerf.getCdIdperfil());
		usuarioSession.setbEsAdmin(true);
		usuarioSession.setbEsInversion(true);
		this.getSession().setAttribute(Constante.__USUARIO_SESSION__, usuarioSession);
	}


	public List<General> getListaMoneda() {
		return listaMoneda;
	}

	public void setListaMoneda(List<General> listaMoneda) {
		this.listaMoneda = listaMoneda;
	}
    
}
