package com.pss.simulador.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
	}
	
	public void setDownload(DefaultStreamedContent download) {
	    this.download = download;
	}
	
	public DefaultStreamedContent getDownload() throws Exception {
	    return download;
	}

	public void prepDownload(Integer idProceso) throws Exception {
		System.out.println("idProceso:"+idProceso);
		List<ProcesoLog> lstProcesoLog = procesoCargaManager.findProcesoLogByIdProceso(idProceso);
	  String date = "G:\\test1.txt";
	  File file = new File(date);
	  InputStream input = new FileInputStream(file);
	  ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	  setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
	  
	  
	  
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
