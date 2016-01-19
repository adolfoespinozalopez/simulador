package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.util.Constante;
/**
*
* @author Adolfo Espinoza
* @version 1.0, 19/01/2016
* @since 1.0
*/
@Component
@ManagedBean(name = "generalController")
@RequestScoped
public class GeneralController {

	private static final Logger LOG = Logger.getLogger(GeneralController.class);
	private String selectedGeneralDominio = Constante.NO_OPTION_SELECTED;
	private List<String> lstGeneralDominio = new ArrayList<String>();
	
	private General selectedGeneral;
	private List<General> listaGeneral = new ArrayList<General>();
	
	@Autowired
    private GeneralManager generalManager;
	
	public GeneralController() {

	}

	@PostConstruct
	public void init() {
		lstGeneralDominio = new ArrayList<String>();
		lstGeneralDominio = generalManager.findAllDomainsActive();
		
		listaGeneral = new ArrayList<General>();		
		selectedGeneral = null;
	}
	
	public void buscar() {
		listaGeneral = generalManager.findByDomain(Constante.NO_OPTION_SELECTED);
	}

	public void crear() {
		selectedGeneral = new General();
	}

	public void verDetalles(General general) {
		selectedGeneral = general;
	}

	public void eliminar() {
		if (selectedGeneral != null) {
			selectedGeneral.setStEstado("0");
		}
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
	
}
