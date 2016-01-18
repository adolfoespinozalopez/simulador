package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.pss.simulador.bs.domain.TipoCambio;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 18/01/2016
* @since 1.0
*/
@Component
@ManagedBean(name = "tipoCambioController")
@RequestScoped
public class TipoCambioController {

	private static final Logger LOG = Logger.getLogger(TipoCambioController.class);
	private TipoCambio selectedTipoCambio;
	private List<TipoCambio> listaTipoCambio = new ArrayList<TipoCambio>();
	
	public TipoCambioController(){
		
	}
	
	@PostConstruct
	public void init() {
		
	}
	
	public void crear() {
		selectedTipoCambio = new TipoCambio();
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
