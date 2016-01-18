package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.pss.simulador.web.bean.Fondo;
import com.pss.simulador.web.bean.Perfil;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 18/01/2016
* @since 1.0
*/
@Component
@ManagedBean(name = "fondoController")
@RequestScoped
public class FondoController {
	
	private static final Logger LOG = Logger.getLogger(FondoController.class);
	private String fondoNombreBus = "";
	private Fondo selectedFondo;
	private List<Fondo> listaFondos = new ArrayList<Fondo>();
	
	public FondoController(){
		
	}
	
	@PostConstruct
	public void init() {
		
	}

	public void buscar() {

	}

	public void crear() {
		selectedFondo = new Fondo();
	}

	public void verDetalles(Fondo fondo) {
		selectedFondo = fondo;
	}

	public void verLimites(Fondo fondo) {
		selectedFondo = fondo;
	}
	
	public void eliminar() {
		if (selectedFondo != null) {
			selectedFondo.setEstado("0");
		}
	}

	public void cancelar() {
		selectedFondo = null;
	}
	
	public String getFondoNombreBus() {
		return fondoNombreBus;
	}

	public void setFondoNombreBus(String fondoNombreBus) {
		this.fondoNombreBus = fondoNombreBus;
	}

	public Fondo getSelectedFondo() {
		return selectedFondo;
	}

	public void setSelectedFondo(Fondo selectedFondo) {
		this.selectedFondo = selectedFondo;
	}

	public List<Fondo> getListaFondos() {
		return listaFondos;
	}

	public void setListaFondos(List<Fondo> listaFondos) {
		this.listaFondos = listaFondos;
	}
	
}
