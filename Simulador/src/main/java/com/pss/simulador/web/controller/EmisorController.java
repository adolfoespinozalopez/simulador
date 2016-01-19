package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.Emisor;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.domain.LimitesEmisor;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.util.Constante;

@Component
@ManagedBean(name = "emisorController")
@RequestScoped
public class EmisorController {

	private static final Logger LOG = Logger.getLogger(EmisorController.class);
	
	private String emisorNombreBus = "";
	private String selectedTipoEmisor = Constante.NO_OPTION_SELECTED;
	private List<General> lstGeneralDominio = new ArrayList<General>();
	
	private Emisor selectedEmisor;
	private List<Emisor> listaEmisor = new ArrayList<Emisor>();
	
	@Autowired
    private GeneralManager generalManager;
	
	//Limites
	private LimitesEmisor selectedlimiteEmisor = new LimitesEmisor();
	
	public EmisorController(){
		
	}
	
	@PostConstruct
	public void init() {
		listaEmisor = new ArrayList<Emisor>();
		Emisor emisorDemo = new Emisor(1);
		emisorDemo.setNbNomEmisor("BANCO CONTINENTAL");
		emisorDemo.setStEstado("1");
		emisorDemo.setTpRating("S.C.");
		emisorDemo.setImPasivo(1000000000.00);
		emisorDemo.setTpTipemisor(1);
		listaEmisor.add(emisorDemo);
	}
	
	public void buscar() {
		
	}

	public void crear() {
		selectedEmisor = new Emisor();
	}

	public void verDetalles(Emisor emisor) {
		selectedEmisor = emisor;
	}

	public void eliminar() {
		if (selectedEmisor != null) {
			selectedEmisor.setStEstado("0");
		}
	}

	public void verLimites(Emisor emisor) {
		selectedEmisor = emisor;
	}
	
	public void cancelar() {
		selectedEmisor = null;
	}

	public String getEmisorNombreBus() {
		return emisorNombreBus;
	}

	public void setEmisorNombreBus(String emisorNombreBus) {
		this.emisorNombreBus = emisorNombreBus;
	}

	public String getSelectedTipoEmisor() {
		return selectedTipoEmisor;
	}

	public void setSelectedTipoEmisor(String selectedTipoEmisor) {
		this.selectedTipoEmisor = selectedTipoEmisor;
	}

	public List<General> getLstGeneralDominio() {
		return lstGeneralDominio;
	}

	public void setLstGeneralDominio(List<General> lstGeneralDominio) {
		this.lstGeneralDominio = lstGeneralDominio;
	}

	public Emisor getSelectedEmisor() {
		return selectedEmisor;
	}

	public void setSelectedEmisor(Emisor selectedEmisor) {
		this.selectedEmisor = selectedEmisor;
	}

	public List<Emisor> getListaEmisor() {
		return listaEmisor;
	}

	public void setListaEmisor(List<Emisor> listaEmisor) {
		this.listaEmisor = listaEmisor;
	}

	public GeneralManager getGeneralManager() {
		return generalManager;
	}

	public void setGeneralManager(GeneralManager generalManager) {
		this.generalManager = generalManager;
	}

	public LimitesEmisor getSelectedlimiteEmisor() {
		return selectedlimiteEmisor;
	}

	public void setSelectedlimiteEmisor(LimitesEmisor selectedlimiteEmisor) {
		this.selectedlimiteEmisor = selectedlimiteEmisor;
	}
	
	
}
