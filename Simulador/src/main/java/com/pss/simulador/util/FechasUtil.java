/**
 * 
 */
package com.pss.simulador.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author pierre.obregon
 * @version 22/1/2016
 */
public class FechasUtil {
	private static final Logger logger = Logger.getLogger(Utilitarios.class);
	public static final String FORMATO_FECHA_YYYMMDD = "yyyyMMdd";
	public static final String FORMATO_FECHA_YYY_MM_DD_HH_mm_ss = "yyyy/MM/dd HH:mm:ss";
	public static final String FORMATO_FECHA_YYYMMDD_HHmmss = "yyyyMMdd_HHmmss";
	public static Date parseFecha(String fecha, String formato) {
		Date result = null;
		SimpleDateFormat format = new SimpleDateFormat(formato.toString());
		try {
			if (fecha != null) {
				if (fecha.length() > 0) {
					result = format.parse(fecha);
				}
			}
		} catch (Exception e) {
			logger.error("FechasUtil.parseFecha", e);
		}

		return result;
	}
	
	public static Date parseFecha(Date fecha, String formato) {
		String strfecha = FechasUtil.formatFecha(fecha, formato);
		Date result = null;
		SimpleDateFormat format = new SimpleDateFormat(formato.toString());
		try {
			if (strfecha != null) {
				if (strfecha.length() > 0) {
					result = format.parse(strfecha);
				}
			}
		} catch (Exception e) {
			logger.error("FechasUtil.parseFecha", e);
		}

		return result;
	}
	
	public static String formatFecha(Date fecha, String formato) {
		String result = "";
		if (fecha != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(formato.toString());
			result = dateFormat.format(fecha);
		}

		return result;
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
