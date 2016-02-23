package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.ExpoFondo;
import com.pss.simulador.bs.domain.Fondo;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.service.ExpoFondoManager;
import com.pss.simulador.bs.service.FondoManager;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.util.Utilitarios;
import com.pss.simulador.web.controller.generic.GenericController;

/**
 *
 * @author Adolfo Espinoza
 * @version 1.0, 08/01/2016
 * @since 1.0
 */
@Component
@Scope("session")
public class SimulacionController extends GenericController{

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(SimulacionController.class);
	
	private String selectedNombreFondo = Constante.NO_OPTION_SELECTED;
	private List<Fondo> listaFondo = new ArrayList<Fondo>();
	private Fondo selectedFondo;
	
	private General selectedTipoMoneda;
	List<General> listaMoneda = new ArrayList<General>();
	
	private List<ExpoFondo> listaExpoFondo = new ArrayList<ExpoFondo>();
	private ExpoFondo selectedExpoFondo;
	
	private List<ExpoFondo> listaLiquidez = new ArrayList<ExpoFondo>();
	
	private List<ExpoFondo> listaEmisores = new ArrayList<ExpoFondo>();
	private ExpoFondo selectedEmisor;
	
	private List<ExpoFondo> listaCaja = new ArrayList<ExpoFondo>();
	private ExpoFondo selectedCaja;
	
	@Autowired
	private ExpoFondoManager expoFondoManager;
	
	@Autowired
    private FondoManager fondoManager;
	
	@Autowired
    private GeneralManager generalManager;
	
	public SimulacionController() {

	}

	@PostConstruct
	public void init() {
		listaFondo = fondoManager.findAll();
		listaMoneda = generalManager.findByDomainAndState(Constante.Dominio.MONEDA, Constante.ESTADO_ACTIVO);
	}

	public void realizarFiltroDeFondo(ValueChangeEvent event) {
        Object objNew = event.getNewValue();
        if (objNew != null) {
        	setSelectedNombreFondo(objNew.toString());
        	selectedFondo = Utilitarios.buscaFondoEnLista(listaFondo, selectedNombreFondo);
        	selectedTipoMoneda = Utilitarios.buscaGeneralPorIDEnLista(listaMoneda, selectedFondo.getTpTipmoneda());
        }
        if(selectedNombreFondo.equals(Constante.NO_OPTION_SELECTED)){
        	limpiarListas();
        }else{
        	ejecutaBusqueda();
        }
    }
	
	public void limpiarListas(){
		listaExpoFondo.clear();
		listaLiquidez.clear();
    	listaEmisores.clear();
    	listaCaja.clear();
	}
	
	public void ejecutaBusqueda(){
		obtieneExposicionFondo();
	}
	
	public void obtieneExposicionFondo(){
		expoFondoManager.executeExposicionDelFondo(selectedNombreFondo, Constante.ESTADO_ACTIVO);
		if(selectedFondo != null){
			limpiarListas();
			List<ExpoFondo> listaTemporal = fondoManager.obtenerExposicionDelFondo(selectedFondo.getCdIdfondo(), Constante.ESTADO_ACTIVO);
			for (ExpoFondo expo : listaTemporal) {
				if(expo.getTpEmisor().equals(Constante.EXPO_FONDO)){
					listaExpoFondo.add(expo);
				}else if(expo.getTpEmisor().equals(Constante.EXPO_EMISOR)){
					listaEmisores.add(expo);
				}else if(expo.getTpEmisor().equals(Constante.EXPO_LIQUIDEZ)){
					listaLiquidez.add(expo);
				}else{
					listaCaja.add(expo);
				}
			}
		}
	}
	
	public String validaValorNegativo(String porcentaje){
		if(porcentaje.contains("-")){
			return "negativo";
		}else{
			return "";
		}
	}
	
	public Fondo getSelectedFondo() {
		return selectedFondo;
	}

	public void setSelectedFondo(Fondo selectedFondo) {
		this.selectedFondo = selectedFondo;
	}

	public General getSelectedTipoMoneda() {
		return selectedTipoMoneda;
	}

	public void setSelectedTipoMoneda(General selectedTipoMoneda) {
		this.selectedTipoMoneda = selectedTipoMoneda;
	}

	public List<Fondo> getListaFondo() {
		return listaFondo;
	}

	public void setListaFondo(List<Fondo> listaFondo) {
		this.listaFondo = listaFondo;
	}

	public String getSelectedNombreFondo() {
		return selectedNombreFondo;
	}

	public void setSelectedNombreFondo(String selectedNombreFondo) {
		this.selectedNombreFondo = selectedNombreFondo;
	}

	public ExpoFondoManager getExpoFondoManager() {
		return expoFondoManager;
	}

	public void setExpoFondoManager(ExpoFondoManager expoFondoManager) {
		this.expoFondoManager = expoFondoManager;
	}

	public FondoManager getFondoManager() {
		return fondoManager;
	}

	public void setFondoManager(FondoManager fondoManager) {
		this.fondoManager = fondoManager;
	}

	public List<ExpoFondo> getListaExpoFondo() {
		return listaExpoFondo;
	}

	public void setListaExpoFondo(List<ExpoFondo> listaExpoFondo) {
		this.listaExpoFondo = listaExpoFondo;
	}

	public ExpoFondo getSelectedExpoFondo() {
		return selectedExpoFondo;
	}

	public void setSelectedExpoFondo(ExpoFondo selectedExpoFondo) {
		this.selectedExpoFondo = selectedExpoFondo;
	}

	public List<ExpoFondo> getListaEmisores() {
		return listaEmisores;
	}

	public void setListaEmisores(List<ExpoFondo> listaEmisores) {
		this.listaEmisores = listaEmisores;
	}

	public ExpoFondo getSelectedEmisor() {
		return selectedEmisor;
	}

	public void setSelectedEmisor(ExpoFondo selectedEmisor) {
		this.selectedEmisor = selectedEmisor;
	}

	public List<ExpoFondo> getListaLiquidez() {
		return listaLiquidez;
	}

	public void setListaLiquidez(List<ExpoFondo> listaLiquidez) {
		this.listaLiquidez = listaLiquidez;
	}

	public List<ExpoFondo> getListaCaja() {
		return listaCaja;
	}

	public void setListaCaja(List<ExpoFondo> listaCaja) {
		this.listaCaja = listaCaja;
	}

	public ExpoFondo getSelectedCaja() {
		return selectedCaja;
	}

	public void setSelectedCaja(ExpoFondo selectedCaja) {
		this.selectedCaja = selectedCaja;
	}

	public GeneralManager getGeneralManager() {
		return generalManager;
	}

	public void setGeneralManager(GeneralManager generalManager) {
		this.generalManager = generalManager;
	}
	
	
}
