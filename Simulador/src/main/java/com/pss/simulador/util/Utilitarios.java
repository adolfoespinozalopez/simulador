package com.pss.simulador.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 22/01/2016
* @since 1.0
*/
public class Utilitarios {

	public static void mostrarMensajeInfo(String objectName, String summary, String details) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(objectName, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, details ));
    }

    public static void mostrarMensajeError(String objectName, String summary, String details) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(objectName, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, details ));
    }
    
    public static void mostrarMensajeAdvertencia(String objectName, String summary, String details) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(objectName, new FacesMessage(FacesMessage.SEVERITY_WARN, summary, details ));
    }
    
    public static void mostrarMensajeUsuario(String objectName, String summary, String details, Severity severity) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(objectName, new FacesMessage(severity, summary, details));
    }
    
    public static boolean tieneLetras(String cadena) {
        Pattern p = Pattern.compile("[A-Za-z]");
        Matcher m = p.matcher(cadena);
        if (m.find()) {
            return true;
        }
        return false;
    }
    
    public static boolean tieneNumeros(String cadena) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(cadena);
        if (m.find()) {
            return true;
        }
        return false;
    }
    
    public static Integer diferenciaEnDias(Date fecMayor, Date fecMenor) {
    	try {
    		long dias = (fecMayor.getTime() - fecMenor.getTime()) / (1000 * 60 * 60 * 24);
        	return (int) dias;
		} catch (Exception e) {
			return 0;
		}
    }
}
