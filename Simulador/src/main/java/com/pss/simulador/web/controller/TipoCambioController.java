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
import com.pss.simulador.util.FechasUtil;
import com.pss.simulador.util.Utilitarios;
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

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(TipoCambioController.class);
	private TipoCambio selectedTipoCambio;
	private List<TipoCambio> listaTipoCambio = new ArrayList<TipoCambio>();

	@Autowired
	private TipoCambioManager tipoCambioManager;

	public TipoCambioController() {
	}

	@PostConstruct
	public void inicializar() {
		this.listarTipoCambio();
	}
	
	public void listarTipoCambio(){
		listaTipoCambio = tipoCambioManager.findAllActivo();
	}

	public void crear() {
		selectedTipoCambio = new TipoCambio();
		selectedTipoCambio.setFhFecIngreso(FechasUtil.parseFecha(new Date(), FechasUtil.FORMATO_FECHA_YYYMMDD));
	}
	public void guardarTipoCambio() {
		try {
			if(selectedTipoCambio!=null){
				if (selectedTipoCambio!=null)
				selectedTipoCambio.setStEstado(Constante.ESTADO_ACTIVO);
				if (selectedTipoCambio.getCdIdtipocambio()!=null){//Actualizacion
					selectedTipoCambio.setFhFecModifica(new Date());
					selectedTipoCambio.setCdUsuModifica(this.getUsuarioSession().getUsuario().getUID());
				}else{// Registro
					selectedTipoCambio.setFhFecCreacion(new Date());
					selectedTipoCambio.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
				}
				selectedTipoCambio=tipoCambioManager.saveNuevoTipoCambio(selectedTipoCambio, this.getUsuarioSession());
			}
			Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_REGISTRO_OK, null);	
		} catch (Exception e) {
			logger.error(e,e);
			Utilitarios.mostrarMensajeError(null, Constante.Mensajes.MSJ_REGISTRO_FAIL, e.getMessage());
		}
		selectedTipoCambio=null;
		this.listarTipoCambio();
	}

	public void verDetalles(TipoCambio tipoCambio) {
		selectedTipoCambio = tipoCambio;
	}

	public void eliminar() {
		if (selectedTipoCambio != null) {
			selectedTipoCambio.setStEstado(Constante.ESTADO_INACTIVO);
			selectedTipoCambio.setFhFecElimina(new Date());
			selectedTipoCambio.setCdUsuElimina(this.getUsuarioSession().getUsuario().getUID());
		}
		selectedTipoCambio = tipoCambioManager.save(selectedTipoCambio);
		this.listarTipoCambio();
		Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_ELIMINACION_OK, null);
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
