package com.pss.simulador.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.pss.simulador.bs.domain.Fondo;
import com.pss.simulador.bs.domain.General;
/**
*
* @author Adolfo Espinoza
* @version 1.0, 22/01/2016
* @since 1.0
*/
public class Utilitarios {
	private static final Logger logger = Logger.getLogger(Utilitarios.class);

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
    
    public static boolean isDouble(String cadena) {
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
   
    public static Fondo buscaFondoEnLista(List<Fondo> lista, String item){
    	for (Fondo f : lista) {
			if(f.getNbNomFondo().toUpperCase().equals(item.toUpperCase())){
				return f;
			}
		}
    	return null;
    }
    
    public static General buscaGeneralEnLista(List<General> lista, String item){
    	for (General g : lista) {
			if(g.getNbDescGeneral().toUpperCase().equals(item.toUpperCase())){
				return g;
			}
		}
    	return null;
    }
    
    public static General buscaGeneralPorValorEnLista(List<General> lista, String valor){
    	for (General g : lista) {
			if(g.getNbValorGeneral().toUpperCase().equals(valor.toUpperCase())){
				return g;
			}
		}
    	return null;
    }
    
    
    public static Double parseToDouble(Object obj){
    	try {
			return obj!=null?(Double)obj:null;
		} catch (Exception e) {
			try {
				return Double.parseDouble(String.valueOf(obj));
			} catch (Exception e2) {
				logger.error(e2,e2);
			}
		}
    	return null;
    }
    
    public static Integer parseToInteger(Object obj){
    	try {
    		return obj!=null?(Integer)obj:null;
		} catch (Exception e) {
			try {
				return Integer.parseInt(String.valueOf(obj));
			} catch (Exception e2) {
				logger.error(e2,e2);
			}
		}
    	return null;
    }
    
    public static String parseToString(Object obj){
    	return (obj!=null)?String.valueOf(obj).trim():null;
    }
    
    public static String parseDoubleToString(Object obj){
    	try {
    		return (obj!=null)?String.format("%.0f", obj):null;
		} catch (Exception e) {
			logger.error(e,e);
		}
    	return null;
    }
    
    public static Date parseToDate(Object obj){
    	try {
    		return (obj!=null)?(Date)obj:null;
		} catch (Exception e) {
			logger.error(e,e);
		}
    	return null;
    }
}
