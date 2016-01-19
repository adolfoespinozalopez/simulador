package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;
import org.springframework.stereotype.Component;

import com.pss.simulador.web.bean.Fondo;
import com.pss.simulador.web.bean.Perfil;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 30/12/2015
* @since 1.0
*/
@Component
@ManagedBean(name = "perfilController")
@RequestScoped
public class PerfilController {

	private static final Logger LOG = Logger.getLogger(PerfilController.class);

	private String perfilNombreBus = "";
	private Perfil selectedPerfil;
	private List<Perfil> listaPerfiles = new ArrayList<Perfil>();
	private DualListModel<Fondo> fondos;

	public PerfilController() {

	}

	@PostConstruct
	public void init() {
		listaPerfiles = new ArrayList<Perfil>();
		listaPerfiles.add(new Perfil(1, "Administrador del Sistema", 1));
		listaPerfiles.add(new Perfil(2, "Administrador de Inversiones", 2));
		listaPerfiles.add(new Perfil(3, "Inversionista EUR", 2));
		listaPerfiles.add(new Perfil(4, "Inversionista BBVA Soles", 2));
		selectedPerfil = null;

		List<Fondo> fondoOrigen = new ArrayList<Fondo>();
		fondoOrigen.add(new Fondo(1, "CASH SOLES"));
		fondoOrigen.add(new Fondo(2, "BBVA S.MONETAR."));
		fondoOrigen.add(new Fondo(3, "BBVA PERU SOLES"));
		fondoOrigen.add(new Fondo(4, "BBVA SOLES"));
		fondoOrigen.add(new Fondo(5, "BBVA MODERADO-S"));
		fondoOrigen.add(new Fondo(6, "BBVA BALANC-S"));
		fondoOrigen.add(new Fondo(7, "BBVA CREC.SOLES"));
		fondoOrigen.add(new Fondo(8, "BBVA AGRESIVO-S"));
		fondoOrigen.add(new Fondo(9, "CASH DOLARES"));
		fondoOrigen.add(new Fondo(10, "BBVA D.MONETAR."));

		List<Fondo> fondoDestino = new ArrayList<Fondo>();
		fondos = new DualListModel<Fondo>(fondoOrigen, fondoDestino);
	}

	public void buscar() {

	}

	public void crear() {
		selectedPerfil = new Perfil(5, "", 2);
	}

	public void verDetalles(Perfil perfil) {
		selectedPerfil = perfil;
	}

	public void eliminar() {
		if (selectedPerfil != null) {
			selectedPerfil.setEstado("0");
		}
	}

	public void cancelar() {
		selectedPerfil = null;
	}

	/*
	 * Modal
	 */
	public void cambiaFechaFiltroInicial(SelectEvent event) {
		Date fecInicio = (Date) event.getObject();
		if (selectedPerfil.getFecFin().before(fecInicio)) {
			selectedPerfil.setFecFin(fecInicio);
		}
	}

	public void cambiaFechaFiltroFinal(SelectEvent event) {
		Date fecFin = (Date) event.getObject();
		if (selectedPerfil.getFecInicio().after(fecFin)) {
			selectedPerfil.setFecInicio(fecFin);
		}
	}

	public String getPerfilNombreBus() {
		return perfilNombreBus;
	}

	public void setPerfilNombreBus(String perfilNombreBus) {
		this.perfilNombreBus = perfilNombreBus;
	}

	public Perfil getSelectedPerfil() {
		return selectedPerfil;
	}

	public void setSelectedPerfil(Perfil selectedPerfil) {
		this.selectedPerfil = selectedPerfil;
	}

	public List<Perfil> getListaPerfiles() {
		return listaPerfiles;
	}

	public void setListaPerfiles(List<Perfil> listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}

	public DualListModel<Fondo> getFondos() {
		return fondos;
	}

	public void setFondos(DualListModel<Fondo> fondos) {
		this.fondos = fondos;
	}
}
