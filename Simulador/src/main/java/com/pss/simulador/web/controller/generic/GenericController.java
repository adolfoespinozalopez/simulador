package com.pss.simulador.web.controller.generic;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.pss.simulador.util.Constante;
import com.pss.simulador.web.bean.UsuarioSession;

/**
 * @author pierre.obregon
 * @version 21/1/2016
 */
public class GenericController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	FacesContext facesContext;
	public ApplicationContext ctx = FacesContextUtils
			.getWebApplicationContext(this.getFacesContext());
	HttpServletRequest request = (HttpServletRequest) this.getFacesContext()
			.getExternalContext().getRequest();
	HttpServletResponse response = (HttpServletResponse)this.getFacesContext()
			.getExternalContext().getResponse();
	HttpSession session = (HttpSession) getFacesContext().getExternalContext().getSession(false);

	public FacesContext getFacesContext() {
		return facesContext == null ? FacesContext.getCurrentInstance()
				: facesContext;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}
	
	public HttpSession getSession() {
		return this.getRequest().getSession();
	}
	
	public UsuarioSession getUsuarioSession(){
		return (UsuarioSession) session.getAttribute(Constante.__USUARIO_SESSION__);
	}
	
	public boolean isAdmin(){
		if(getUsuarioSession() != null){
			if(this.getUsuarioSession().getbEsAdmin()){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

}
