package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.Fondo;
import com.pss.simulador.bs.domain.Perfil;
import com.pss.simulador.bs.domain.PerfilFondo;
import com.pss.simulador.bs.repository.data.PerfilFondoRepository;
import com.pss.simulador.bs.service.FondoManager;
import com.pss.simulador.bs.service.PerfilManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.util.Utilitarios;
import com.pss.simulador.web.controller.generic.GenericController;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 30/12/2015
* @since 1.0
*/
@Component
@Scope("session")
public class PerfilController extends GenericController {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(PerfilController.class);

	private String perfilNombreBus = "";
	private Perfil selectedPerfil;
	private List<Perfil> listaPerfiles = new ArrayList<Perfil>();
	private DualListModel<Fondo> fondos;
	
	@Autowired
	PerfilManager perfilManager;
	@Autowired
	FondoManager fondoManager;
	
	public PerfilController() {

	}

	@PostConstruct
	public void init() {
		buscarPerfiles();
		selectedPerfil = null;
		this.resetFormulario();
	}
	
	public void resetFormulario(){
		List<Fondo> fondoOrigen = fondoManager.findFondoAll();
		List<Fondo> fondoDestino = new ArrayList<Fondo>();
		fondos = new DualListModel<Fondo>(fondoOrigen, fondoDestino);
	}

	public void buscarPerfiles() {
		listaPerfiles = perfilManager.findPerfilByName(perfilNombreBus, Constante.ESTADO_ACTIVO);
	}

	public void crear() {
		selectedPerfil = new Perfil();
		selectedPerfil.setTpTipperfil(Constante.Perfil.ID_ADMINISTRADOR_INVERSORES);
		this.resetFormulario();
	}
	
	public void guardarPerfil() {
		try {
			if(selectedPerfil!=null){
				if (selectedPerfil!=null)
				selectedPerfil.setStEstado(Constante.ESTADO_ACTIVO);
				if (selectedPerfil.getCdIdperfil()!=null){//Actualizacion
					selectedPerfil.setFhFecModifica(new Date());
					selectedPerfil.setCdUsuModifica(this.getUsuarioSession().getUsuario().getUID());
				}else{// Registro
					selectedPerfil.setFhFecCreacion(new Date());
					selectedPerfil.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
				}
				selectedPerfil=perfilManager.savePerfilAndDetail(selectedPerfil, fondos, this.getUsuarioSession());
			}
			Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_REGISTRO_OK, null);	
		} catch (Exception e) {
			logger.error(e,e);
			Utilitarios.mostrarMensajeError(null, Constante.Mensajes.MSJ_REGISTRO_FAIL, e.getMessage());
		}
		this.buscarPerfiles();
	}

	public void verDetalles(Perfil perfil) {
		selectedPerfil = perfil;
		List<Fondo> fondoOrigen = new ArrayList<Fondo>();
		List<Fondo> fondoDestino = new ArrayList<Fondo>();
		List<Fondo> fondoAll = fondoManager.findFondoAll();
		for (Fondo fondo : fondoAll) {
			boolean isSelected = false; 
			for (PerfilFondo perfilFondoIter : selectedPerfil.getPerfilFondoList()) {
				if(fondo.getCdIdfondo() == perfilFondoIter.getPerfilFondoPK().getCdIdfondo() &&
						perfilFondoIter.getStEstado().equals(Constante.ESTADO_ACTIVO)){
					fondoDestino.add(fondo);
					isSelected = true;
					break;
				}
			}
			if (!isSelected){
				fondoOrigen.add(fondo);
			}
		}
		fondos = new DualListModel<Fondo>(fondoOrigen, fondoDestino);
	}

	public void eliminar() {
		if (selectedPerfil != null) {
			selectedPerfil.setStEstado(Constante.ESTADO_INACTIVO);
			selectedPerfil.setFhFecElimina(new Date());
			selectedPerfil.setCdUsuElimina(this.getUsuarioSession().getUsuario().getUID());
		}
		selectedPerfil = perfilManager.savePerfil(selectedPerfil);
		this.buscarPerfiles();
		Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_ELIMINACION_OK, null);
	}

	public void cancelar() {
		selectedPerfil = null;
	}

	/*
	 * Modal
	 */
	public void cambiaFechaFiltroInicial(SelectEvent event) {
		Date fecInicio = (Date) event.getObject();
		if (selectedPerfil.getFhFecFin().before(fecInicio)) {
			selectedPerfil.setFhFecFin(fecInicio);
		}
	}

	public void cambiaFechaFiltroFinal(SelectEvent event) {
		Date fecFin = (Date) event.getObject();
		if (selectedPerfil.getFhFecInicio().after(fecFin)) {
			selectedPerfil.setFhFecInicio(fecFin);
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
