/**
 * 
 */
package com.pss.simulador.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.pss.simulador.bs.domain.CobranzaPago;
import com.pss.simulador.bs.domain.Infoport;
import com.pss.simulador.bs.domain.ProcesoCarga;
import com.pss.simulador.bs.domain.ProcesoLog;
import com.pss.simulador.bs.domain.Saldo;
import com.pss.simulador.util.Constante;
import com.pss.simulador.util.Utilitarios;

/**
 * @author pierre.obregon
 * @version 10/2/2016
 */
public class CargaArchivoHelper {

	private final Logger logger = Logger.getLogger(CargaArchivoHelper.class);

	private ProcesoCarga procesoCarga;
	private List<ProcesoLog> lstLog = new ArrayList<ProcesoLog>();
	private Integer nroLinea;
	private String nombreHoja;
	
	public CargaArchivoHelper() {
	}
	
	public CargaArchivoHelper(ProcesoCarga procesoCarga, List<ProcesoLog> lstLog, Integer nroLinea, String nombreHoja) {
		this.setProcesoCarga(procesoCarga);
		this.setLstLog(lstLog);
		this.setNroLinea(nroLinea);
		this.setNombreHoja(nombreHoja);
	}

	public Double parseToDouble(Object obj, Integer nroColumna) {
		try {
			return !Utilitarios.isEmpty(obj) ? (Double) obj : null;
		} catch (Exception e) {
			try {
				return Double.parseDouble(String.valueOf(obj));
			} catch (Exception e2) {
				logger.error(e2, e2);
				this.addLog(Constante.Log.TipoMensaje.ERROR,Constante.Log.Mensaje.MSJ_ERROR_PARSE_DOUBLE,obj,nroColumna);
			}
		}
		return null;
	}

	
	/**
	 * @param lstLog
	 * @param msjErrorParseDouble
	 */
	private void addLog(String strTipoMensaje, String strMensajeLog, Object valorDato, Integer nroColumna) {
		ProcesoLog procesoLog = new ProcesoLog();
		procesoLog.setFhFecreg(new Date());
		procesoLog.setTpTipomensaje(strTipoMensaje);
		procesoLog.setMsMensaje(this.getNombreHoja() + " - Linea("+ this.getNroLinea() +"), Columna ("+nroColumna+") - "+ strMensajeLog);
		procesoLog.setProcesoCarga(new ProcesoCarga(this.getProcesoCarga().getCdIdproceso()));
		this.getLstLog().add(procesoLog);

	}

	public Integer parseToInteger(Object obj, Integer nroColumna) {
		try {
			return !Utilitarios.isEmpty(obj) ? (Integer) obj : null;
		} catch (Exception e) {
			try {
				return Integer.parseInt(String.valueOf(obj));
			} catch (Exception e2) {
				logger.error(e2, e2);
				this.addLog(Constante.Log.TipoMensaje.ERROR,Constante.Log.Mensaje.MSJ_ERROR_PARSE_INTEGER,obj,nroColumna);
			}
		}
		return null;
	}

	public String parseToString(Object obj) {
		return !Utilitarios.isEmpty(obj) ? String.valueOf(obj).trim() : null;
	}

	public String parseDoubleToString(Object obj, Integer nroColumna) {
		try {
			return !Utilitarios.isEmpty(obj) ? String.format("%.0f", obj) : null;
		} catch (Exception e) {
			logger.error(e, e);
			this.addLog(Constante.Log.TipoMensaje.ERROR,Constante.Log.Mensaje.MSJ_ERROR_PARSE_DOUBLE_TO_STRING_ENTERO,obj,nroColumna);
		}
		return null;
	}

	public Date parseToDate(Object obj, Integer nroColumna) {
		try {
			return !Utilitarios.isEmpty(obj) ? (Date) obj : null;
		} catch (Exception e) {
			logger.error(e, e);
			this.addLog(Constante.Log.TipoMensaje.ERROR,Constante.Log.Mensaje.MSJ_ERROR_PARSE_DATE,obj,nroColumna);
		}
		return null;
	}

	public void validarCamposObligatoriosInfoport(Infoport infoport) {
		if(infoport.getNbNomFondo()==null || infoport.getNbNomFondo().trim().isEmpty()){
			this.addLog(Constante.Log.TipoMensaje.ERROR, "Campo Obligatorio", null, Constante.ArchivoCarga.Columnas.INFOPORT_POS_1_NOMBREFONDO);
		}
	}
	
	public void validarCamposObligatoriosSaldos(Saldo saldo) {
		if(saldo.getCdCodFondo()==null || saldo.getCdCodFondo().trim().isEmpty()){
			this.addLog(Constante.Log.TipoMensaje.ERROR, "Campo Obligatorio", null, Constante.ArchivoCarga.Columnas.SALDOS_POS_1_CODIGO);
		}
		if(saldo.getNbNomFondo()==null || saldo.getNbNomFondo().trim().isEmpty()){
			this.addLog(Constante.Log.TipoMensaje.ERROR, "Campo Obligatorio", null, Constante.ArchivoCarga.Columnas.SALDOS_POS_2_FONDO);
		}
	}
	
	public void validarCamposObligatoriosCobPag(CobranzaPago cobranzaPago) {
		if(cobranzaPago.getCdCodFondo()==null || cobranzaPago.getCdCodFondo().trim().isEmpty()){
			this.addLog(Constante.Log.TipoMensaje.ERROR, "Campo Obligatorio", null, Constante.ArchivoCarga.Columnas.INFOPORT_POS_1_NOMBREFONDO);
		}
	}
	
	/**
	 * @return the procesoCarga
	 */
	public ProcesoCarga getProcesoCarga() {
		return procesoCarga;
	}

	/**
	 * @param procesoCarga
	 *            the procesoCarga to set
	 */
	public void setProcesoCarga(ProcesoCarga procesoCarga) {
		this.procesoCarga = procesoCarga;
	}

	/**
	 * @return the lstLog
	 */
	public List<ProcesoLog> getLstLog() {
		return lstLog;
	}

	/**
	 * @param lstLog
	 *            the lstLog to set
	 */
	public void setLstLog(List<ProcesoLog> lstLog) {
		this.lstLog = lstLog;
	}

	/**
	 * @return the nroLinea
	 */
	public Integer getNroLinea() {
		return nroLinea;
	}

	/**
	 * @param nroLinea the nroLinea to set
	 */
	public void setNroLinea(Integer nroLinea) {
		this.nroLinea = nroLinea;
	}

	/**
	 * @return the nombreHoja
	 */
	public String getNombreHoja() {
		return nombreHoja;
	}

	/**
	 * @param nombreHoja the nombreHoja to set
	 */
	public void setNombreHoja(String nombreHoja) {
		this.nombreHoja = nombreHoja;
	}

	

}
