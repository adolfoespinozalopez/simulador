package com.pss.simulador.bs.filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.pss.simulador.util.Constante;
import com.pss.simulador.util.FechasUtil;
import com.pss.simulador.web.bean.UsuarioSession;

public class FilterSession implements Filter {
	public static Logger logger = Logger.getLogger(FilterSession.class);
	private static final String LOGIN_PAGE_URI_OK = "/index.jsp";
	private static final String LOGIN_PAGE_URI = "/faces/login.xhtml";
	private static final String PAGE_URI_PERM_001 = "/faces/configuracion.xhtml";
	private static final String PAGE_URI_PERM_002 = "/faces/descargarLog.xhtml";
	private Set<String> modulesWithSecurity;
	private Set<String> resourcesOfModulesExceptionSecurity;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.modulesWithSecurity = new HashSet();
		this.modulesWithSecurity.add("/Simulador/seguridad/");
		this.modulesWithSecurity.add("/Simulador/simulacion/");
		this.modulesWithSecurity.add("/Simulador/administracion/");
		
		this.resourcesOfModulesExceptionSecurity = new HashSet();
		this.resourcesOfModulesExceptionSecurity.add("/Simulador/seguridad/frmLogin.jsf");
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpSession session = null;
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		session = httpRequest.getSession();
		String contextPath = ((HttpServletRequest) req).getContextPath();
		String requestUri = ((HttpServletRequest) req).getRequestURI();
		logger.debug(FechasUtil.formatFecha(new Date(),"yyyy-MM-dd HH:mm:ss") + " - " + requestUri);
		boolean isURLWithSecurity = containsURLforSecurity(requestUri,contextPath,modulesWithSecurity);
		boolean isURLExption = containsURLforSecurity(requestUri,contextPath,resourcesOfModulesExceptionSecurity);
		boolean isSessionActive = authorize(session, httpRequest);
		
		if ( isURLWithSecurity && !isSessionActive && !isURLExption ) {
			logger.debug("Finalizo session");
			session.setAttribute("strMensaje","Finalizó su Sessión. Ingrese nuevamente.");
			((HttpServletRequest) req).getRequestDispatcher("/sinAcceso.xhtml").forward(req, res);
		} else {
//			logger.debug("authorization succeeded");
			chain.doFilter(req, res);
		}
	}

	public void destroy() {
	
	}

	private boolean containsURLforSecurity(String value, String contextPath, Set<String> listaStrings) {
		Iterator ite = listaStrings.iterator();
		while (ite.hasNext()) {
			String restrictedResource = (String) ite.next();
			if (value != null && (value).contains(restrictedResource)) {
				return true;
			}
		}

		return false;
	}
	
	

	private boolean compararIndex(String contextPath) {
		Iterator ite = this.modulesWithSecurity.iterator();
		while (ite.hasNext()) {
			String restrictedResource = (String) ite.next();
			if ((contextPath + restrictedResource).equalsIgnoreCase("/index.jsp")) {
				return true;
			}
		}
		return false;
	}

	private boolean authorize(HttpSession session,
			HttpServletRequest httpServlet) {
		if (session.getAttribute(Constante.__USUARIO_SESSION__) != null) {
			UsuarioSession user = (UsuarioSession) session.getAttribute(Constante.__USUARIO_SESSION__);
			return (user != null);
		}
		return false;
	}
}