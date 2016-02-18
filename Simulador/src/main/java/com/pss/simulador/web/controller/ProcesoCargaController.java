package com.pss.simulador.web.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;

import org.apache.log4j.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import com.pss.simulador.bs.domain.ProcesoCarga;
import com.pss.simulador.bs.domain.ProcesoLog;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.bs.service.ProcesoCargaManager;
import com.pss.simulador.bs.thead.ProcesoCargaRunnable;
import com.pss.simulador.util.Constante;
import com.pss.simulador.util.FechasUtil;
import com.pss.simulador.util.Utilitarios;
import com.pss.simulador.web.controller.generic.GenericController;

@Component
@Scope("session")
public class ProcesoCargaController extends GenericController {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ProcesoCargaController.class);
	
	private Date fechaDesdeBus;
	private Date fechaHastaBus;
	private List<ProcesoCarga> lstProcesoCarga = new ArrayList<ProcesoCarga>();
	
	private ProcesoCarga selectedProcesoCarga;
	
	private UploadedFile filePlantilla;
	
	@Autowired
    private ProcesoCargaManager procesoCargaManager;
	
	@Autowired
    private GeneralManager generalManager;
	
	@Autowired
	private ProcesoCargaRunnable procesoCargaThread;
	
	 private DefaultStreamedContent download;
	
	
	public ProcesoCargaController(){
		
	}
	
	
	public void preRenderView() {
		
		fechaDesdeBus = fechaDesdeBus==null?FechasUtil.parseFecha(new Date(), "yyyyMMdd"):fechaDesdeBus;
		fechaHastaBus = fechaHastaBus==null?FechasUtil.parseFecha(new Date(), "yyyyMMdd"):fechaHastaBus;
	}
	public void limpiarFormulario(){
		lstProcesoCarga = new ArrayList<ProcesoCarga>();
		fechaDesdeBus = FechasUtil.parseFecha(new Date(), "yyyyMMdd");
		fechaHastaBus = FechasUtil.parseFecha(new Date(), "yyyyMMdd");
		selectedProcesoCarga = new ProcesoCarga();
	}
	
	public void buscar() {
		lstProcesoCarga = procesoCargaManager.findProcesoCargaByFechas(fechaDesdeBus, fechaHastaBus);
	}

	public void nuevaCarga() {
		
	}
	
	public void ejecutarProcesoCarga() {
		
		logger.info("Inicio proceso Carga");
		ProcesoCarga procesoCarga = new ProcesoCarga();
		Date fhFecImporta = new Date();
		if(filePlantilla.getContentType().equals(Constante.ContentType.EXCEL_MACRO)){
			// Carga Archivo
			try {
					if(procesoCargaManager.copyFileToLocal(filePlantilla.getInputstream())){
						procesoCarga.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
						procesoCarga.setFhFecIni(fhFecImporta);
						procesoCarga.setFhFecImporta(fhFecImporta);
						procesoCarga.setStEstadoProceso(Constante.EstadoProceso.EN_PROCESO);
						procesoCarga.setStEstado(Constante.ESTADO_ACTIVO);
						procesoCarga = procesoCargaManager.saveProcesoCarga(procesoCarga);
					}
				
			} catch (IOException e) {
				logger.error(e,e);
			}
			procesoCargaThread.setProcesoCarga(procesoCarga);
			Thread t1 = new Thread(procesoCargaThread);
			t1.start();
			Utilitarios.mostrarMensajeInfo(null, filePlantilla.getFileName() + ". Se proceso de carga se ejecutó correctaente. ", null);
			this.limpiarFormulario();
			this.buscar();
			
		}else{
			Utilitarios.mostrarMensajeError(null, filePlantilla.getFileName() + ". No cumple con la extensión correcta (.xlsm). ", null);
		}
	
		
	}
	
	public void setDownload(DefaultStreamedContent download) {
	    this.download = download;
	}
	
	public DefaultStreamedContent getDownload() throws Exception {
	    return download;
	}

	public void prepDownload(Integer idProceso, Date fhFecImporta) throws Exception {
		List<ProcesoLog> lstProcesoLog = procesoCargaManager.findProcesoLogByIdProceso(idProceso);
		ByteArrayOutputStream baos = null;
		baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		for (ProcesoLog procesoLog : lstProcesoLog) {
			printStream.println(procesoLog.getTpTipomensaje() + " - " + 
								FechasUtil.formatFecha(procesoLog.getFhFecreg(), FechasUtil.FORMATO_FECHA_YYY_MM_DD_HH_mm_ss) + " - " +
								procesoLog.getMsMensaje());
		}
		printStream.close();
		
		ByteArrayInputStream stream = new ByteArrayInputStream((baos).toByteArray());
		ExternalContext externalContext2 = FacesContext.getCurrentInstance().getExternalContext();
		this.setDownload(new DefaultStreamedContent(stream, externalContext2.getMimeType("text/plain"), "Log_"+FechasUtil.formatFecha(fhFecImporta,FechasUtil.FORMATO_FECHA_YYYMMDD_HHmmss)+".txt"));
		
		
		
//		ServletOutputStream ouputStream = this.getResponse().getOutputStream();
//		ouputStream.write(datos);
//	    ouputStream.flush();
//	    ouputStream.close();
		
		
	}
	
	public void eliminar() {
		if (selectedProcesoCarga != null) {
			selectedProcesoCarga.setStEstado(Constante.ESTADO_INACTIVO);
			selectedProcesoCarga.setFhFecElimina(new Date());
			selectedProcesoCarga.setCdUsuElimina(this.getUsuarioSession().getUsuario().getUID());
		}
		selectedProcesoCarga = procesoCargaManager.saveProcesoCarga(selectedProcesoCarga);
		this.buscar();
		Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_ELIMINACION_OK, null);
	}

	public void cancelar() {
	}

	public Date getFechaDesdeBus() {
		return fechaDesdeBus;
	}

	public void setFechaDesdeBus(Date fechaDesdeBus) {
		this.fechaDesdeBus = fechaDesdeBus;
	}

	public Date getFechaHastaBus() {
		return fechaHastaBus;
	}
	public void setFechaHastaBus(Date fechaHastaBus) {
		this.fechaHastaBus = fechaHastaBus;
	}

	public List<ProcesoCarga> getLstProcesoCarga() {
		return lstProcesoCarga;
	}

	public void setLstProcesoCarga(List<ProcesoCarga> lstProcesoCarga) {
		this.lstProcesoCarga = lstProcesoCarga;
	}

	public ProcesoCarga getSelectedProcesoCarga() {
		return selectedProcesoCarga;
	}

	public void setSelectedProcesoCarga(ProcesoCarga selectedProcesoCarga) {
		this.selectedProcesoCarga = selectedProcesoCarga;
	}

	public ProcesoCargaManager getProcesoCargaManager() {
		return procesoCargaManager;
	}
	public void setProcesoCargaManager(ProcesoCargaManager procesoCargaManager) {
		this.procesoCargaManager = procesoCargaManager;
	}
	public UploadedFile getFilePlantilla() {
		return filePlantilla;
	}
	public void setFilePlantilla(UploadedFile filePlantilla) {
		this.filePlantilla = filePlantilla;
	}

	public GeneralManager getGeneralManager() {
		return generalManager;
	}
	public void setGeneralManager(GeneralManager generalManager) {
		this.generalManager = generalManager;
	}


	
}
