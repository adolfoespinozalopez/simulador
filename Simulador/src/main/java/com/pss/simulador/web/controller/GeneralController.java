package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.util.Utilitarios;
import com.pss.simulador.web.controller.generic.GenericController;
/**
*
* @author Adolfo Espinoza
* @version 1.0, 19/01/2016
* @since 1.0
*/
@Component
@Scope("session")
public class GeneralController extends GenericController {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GeneralController.class);
	private String selectedGeneralDominio = Constante.NO_OPTION_SELECTED;
	private List<String> lstGeneralDominio = new ArrayList<String>();
	
	private General selectedGeneral;
	private List<General> listaGeneral = new ArrayList<General>();
	
	@Autowired
    private GeneralManager generalManager;
	
	/*
	 * Modal
	 */
	private List<String> lstGeneralDominioActivos = new ArrayList<String>();
	
	public GeneralController() {

	}

	@PostConstruct
	public void init() {
		lstGeneralDominio = new ArrayList<String>();
		lstGeneralDominio = generalManager.findAllDomains();
		lstGeneralDominioActivos = generalManager.findAllDomainsActive();
		listaGeneral = new ArrayList<General>();
		selectedGeneral = null;
	}
	
	public void buscar() {
		listaGeneral = generalManager.findByDomain(selectedGeneralDominio);
	}

	public void crear() {
		selectedGeneral = new General();
	}
	
	public void guardarGeneral() {
		try {
			if(selectedGeneral!=null){
				if (selectedGeneral!=null)
				selectedGeneral.setStEstado(Constante.ESTADO_ACTIVO);
				selectedGeneral.setFgEditable(Constante.ESTADO_ACTIVO);
				if (selectedGeneral.getCdIdgeneral()!=null){//Actualizacion
					selectedGeneral.setFhFecModifica(new Date());
					selectedGeneral.setCdUsuModifica(this.getUsuarioSession().getUsuario().getUID());
				}else{// Registro
					selectedGeneral.setFhFecCreacion(new Date());
					selectedGeneral.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
				}
				selectedGeneral=generalManager.save(selectedGeneral);
			}
			Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_REGISTRO_OK, null);	
		} catch (Exception e) {
			logger.error(e,e);
			Utilitarios.mostrarMensajeError(null, Constante.Mensajes.MSJ_REGISTRO_FAIL, e.getMessage());
		}
		this.buscar();
	}

	public void verDetalles(General general) {
		selectedGeneral = general;
	}

	public void eliminar() {
		if (selectedGeneral != null) {
			selectedGeneral.setStEstado(Constante.ESTADO_INACTIVO);
			selectedGeneral.setFhFecElimina(new Date());
			selectedGeneral.setCdUsuElimina(this.getUsuarioSession().getUsuario().getUID());
		}
		selectedGeneral = generalManager.save(selectedGeneral);
		this.buscar();
		Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_ELIMINACION_OK, null);
	}

	public void cancelar() {
		selectedGeneral = null;
	}

	public String getSelectedGeneralDominio() {
		return selectedGeneralDominio;
	}

	public void setSelectedGeneralDominio(String selectedGeneralDominio) {
		this.selectedGeneralDominio = selectedGeneralDominio;
	}

	public List<String> getLstGeneralDominio() {
		return lstGeneralDominio;
	}

	public void setLstGeneralDominio(List<String> lstGeneralDominio) {
		this.lstGeneralDominio = lstGeneralDominio;
	}

	public General getSelectedGeneral() {
		return selectedGeneral;
	}

	public void setSelectedGeneral(General selectedGeneral) {
		this.selectedGeneral = selectedGeneral;
	}

	public List<General> getListaGeneral() {
		return listaGeneral;
	}

	public void setListaGeneral(List<General> listaGeneral) {
		this.listaGeneral = listaGeneral;
	}

	public List<String> getLstGeneralDominioActivos() {
		return lstGeneralDominioActivos;
	}

	public void setLstGeneralDominioActivos(List<String> lstGeneralDominioActivos) {
		this.lstGeneralDominioActivos = lstGeneralDominioActivos;
	}
	
}
