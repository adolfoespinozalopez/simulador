package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.ExpoFondo;
import com.pss.simulador.bs.domain.Fondo;
import com.pss.simulador.bs.service.ExpoFondoManager;
import com.pss.simulador.bs.service.FondoManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.util.Utilitarios;
import com.pss.simulador.web.bean.FlujoCaja;
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
	
	private List<FlujoCaja> listaCaja = new ArrayList<FlujoCaja>();
	
	private Fondo selectedFondo;
	private List<Fondo> listaFondo = new ArrayList<Fondo>();
	private String selectedNombreFondo = Constante.NO_OPTION_SELECTED;
	
	private List<ExpoFondo> listaExpoFondo = new ArrayList<ExpoFondo>();
	private ExpoFondo selectedExpoFondo;
	
	private List<ExpoFondo> listaEmisores = new ArrayList<ExpoFondo>();
	private ExpoFondo selectedEmisor;
	
	@Autowired
	private ExpoFondoManager expoFondoManager;
	
	@Autowired
    private FondoManager fondoManager;
	
	public SimulacionController() {

	}

	@PostConstruct
	public void init() {
		listaFondo = fondoManager.findAll();
		//listaFondo = fondoManager.findByIdPerfil(this.getUsuarioSession().getPerfil().getCdIdperfil());
	}

	public void realizarFiltroDeFondo(ValueChangeEvent event) {
        Object objNew = event.getNewValue();
        if (objNew != null) {
        	setSelectedNombreFondo(objNew.toString());
        	selectedFondo = Utilitarios.buscaFondoEnLista(listaFondo, selectedNombreFondo);
        }
        if(selectedNombreFondo.equals(Constante.NO_OPTION_SELECTED)){
        	listaExpoFondo = new ArrayList<ExpoFondo>();
        	listaCaja = new ArrayList<FlujoCaja>();
        	listaEmisores = new ArrayList<ExpoFondo>();
        }else{
        	ejecutaBusqueda();
        }
    }
	
	public void ejecutaBusqueda(){
		obtieneExposicionFondo();
		obtieneFlujoDeCaja();
	}
	
	public void obtieneExposicionFondo(){
		expoFondoManager.executeExposicionDelFondo(selectedNombreFondo);
		if(selectedFondo != null){
			listaExpoFondo = fondoManager.obtenerExposicionDelFondo(selectedFondo.getCdIdfondo());
			listaEmisores = fondoManager.obtenerEmisoresDeExposicionDelFondo(selectedFondo.getCdIdfondo());
		}
	}

	public void obtieneFlujoDeCaja(){
		Calendar cal = Calendar.getInstance();
		listaCaja = new ArrayList<FlujoCaja>();
		listaCaja.add(new FlujoCaja(cal.getTime(), 6912633.00, 0.00, 6912633.00, 570.00, 0.00, 570.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 10032799.00, 0.00, 16945432.00, 0.00, 0.00, 570.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 10063903.00, 0.00, 27009336.00, 0.00, 0.00, 570.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 10031740.00, 0.00, 65394155.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 65394155.00, 0.00, 0.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 65394155.00, 0.00, 0.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 65394155.00, 0.00, 0.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 65394155.00, 0.00, 0.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 65394155.00, 0.00, 0.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 65394155.00, 0.00, 0.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 65394155.00, 0.00, 0.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 16291673.00, 0.00, 81685828.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 0.00, 0.00, 81685828.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 0.00, 0.00, 81685828.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 0.00, 0.00, 81685828.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 5080448.00, 0.00, 86766276.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 0.00, 0.00, 86766276.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 0.00, 0.00, 86766276.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
		listaCaja.add(new FlujoCaja(cal.getTime(), 0.00, 0.00, 86766276.00, 0.00, 0.00, 7125127.00));
		cal.add(Calendar.DATE, 1);
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

	public List<FlujoCaja> getListaCaja() {
		return listaCaja;
	}

	public void setListaCaja(List<FlujoCaja> listaCaja) {
		this.listaCaja = listaCaja;
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

	
	
}
