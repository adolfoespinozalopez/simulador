package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.TipoCambio;
import com.pss.simulador.bs.service.TipoCambioManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.web.controller.generic.GenericController;

/**
 *
 * @author Adolfo Espinoza
 * @version 1.0, 18/01/2016
 * @since 1.0
 */
@Component
@Scope("session")
public class TipoCambioController extends GenericController {

	private static final Logger logger = Logger.getLogger(TipoCambioController.class);
	private TipoCambio selectedTipoCambio;
	private List<TipoCambio> listaTipoCambio = new ArrayList<TipoCambio>();

	@Autowired
	private TipoCambioManager tipoCambioManager;

	public TipoCambioController() {
		
	}

	@PostConstruct
	public void inicializar() {
		listaTipoCambio = tipoCambioManager.findAll();
	}

	public void crear() {
		selectedTipoCambio = new TipoCambio();
		selectedTipoCambio.setFhFecIngreso(new Date());
	}
	public void guardarTipoCambio() {
		if(selectedTipoCambio!=null){
			selectedTipoCambio.setStEstado(Constante.ESTADO_ACTIVO);
			tipoCambioManager.save(selectedTipoCambio);
		};
		selectedTipoCambio.setFhFecIngreso(new Date());
		selectedTipoCambio.setFhFecCreacion(new Date());
		selectedTipoCambio.setCdUsuCreacion("COMPLETARR");
	}

	public void verDetalles(TipoCambio tipoCambio) {
		selectedTipoCambio = tipoCambio;
	}

	public void eliminar() {
		if (selectedTipoCambio != null) {
			selectedTipoCambio.setStEstado("0");
		}
	}

	public void cancelar() {
		selectedTipoCambio = null;
	}

	public TipoCambio getSelectedTipoCambio() {
		return selectedTipoCambio;
	}

	public void setSelectedTipoCambio(TipoCambio selectedTipoCambio) {
		this.selectedTipoCambio = selectedTipoCambio;
	}

	public List<TipoCambio> getListaTipoCambio() {
		return listaTipoCambio;
	}

	public void setListaTipoCambio(List<TipoCambio> listaTipoCambio) {
		this.listaTipoCambio = listaTipoCambio;
	}

}
