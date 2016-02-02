package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.domain.Orden;
import com.pss.simulador.bs.domain.OrdenEstado;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.bs.service.OrdenManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.util.Utilitarios;
import com.pss.simulador.web.controller.generic.GenericController;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 28/01/2016
* @since 1.0
*/
@Component
@Scope("session")
public class OrdenController extends GenericController{

	private static final long serialVersionUID = 1L;

	private String selectedTipoOperacion = Constante.NO_OPTION_SELECTED;
	private List<General> listaTipoOperacion = new ArrayList<General>();
	
	private String selectedEstado = Constante.NO_OPTION_SELECTED;
	private List<General> listaOrdenEstado = new ArrayList<General>();
	
	private List<Orden> listaOrdenes = new ArrayList<Orden>();
	private Orden selectedOrden;
	private List<Orden> selectedOrdenes = new ArrayList<Orden>();
	
	private Map<Integer, String> mapaMoneda = new HashMap<Integer, String>();
	private Map<String, String> mapaEstado = new HashMap<String, String>();
	
	private List<OrdenEstado> listaEstadoDeOrden = new ArrayList<OrdenEstado>();
	private OrdenEstado selectedOrdenEstado;
	
	@Autowired
    private GeneralManager generalManager;
	
	@Autowired
	private OrdenManager ordenManager;

	public OrdenController(){
		
	}
	
	@PostConstruct
	public void init() {
		selectedTipoOperacion = Constante.NO_OPTION_SELECTED;
		listaTipoOperacion = generalManager.findByDomainAndState(Constante.Dominio.TIPO_OPERACION, Constante.ESTADO_ACTIVO);
		
		selectedEstado = Constante.NO_OPTION_SELECTED;
		listaOrdenEstado = generalManager.findByDomainAndState(Constante.Dominio.ESTADO_ORDEN, Constante.ESTADO_ACTIVO);
		for (General estadoOrden : listaOrdenEstado) {
			mapaEstado.put(estadoOrden.getNbValorGeneral(), estadoOrden.getNbDescGeneral());
		}
		
		List<General> listaMoneda = generalManager.findByDomainAndState(Constante.Dominio.MONEDA, Constante.ESTADO_ACTIVO);
		for (General moneda : listaMoneda) {
			mapaMoneda.put(moneda.getCdIdgeneral(), moneda.getNbDescGeneral());
		}
		selectedOrden = null;
		ejecutarbusqueda();
	}
	
	public void realizarFiltroDeEstado(ValueChangeEvent event) {
        Object objNew = event.getNewValue();
        if (objNew != null) {
        	setSelectedEstado(objNew.toString());
        }
        ejecutarbusqueda();
    }
	
	public void realizarFiltroDeOperacion(ValueChangeEvent event) {
        Object objNew = event.getNewValue();
        if (objNew != null) {
        	setSelectedTipoOperacion(objNew.toString());
        }
        ejecutarbusqueda();
    }
	
	public void ejecutarbusqueda(){
		if(this.isAdmin()){
			listaOrdenes = ordenManager.findByFilter(selectedTipoOperacion, selectedEstado, null);
		}else{
			listaOrdenes = ordenManager.findByFilter(selectedTipoOperacion, selectedEstado, this.getUsuarioSession().getUsuario().getUID().toString());
		}
	}
	
	public void aprobarOrden(){
		if(selectedOrden != null){
			OrdenEstado ordenEstado = new OrdenEstado();
			ordenEstado.setOrden(selectedOrden);
			ordenEstado.setFhFecCreacion(new Date());
			ordenEstado.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
			ordenEstado.setCdIdgeneral(Utilitarios.buscaGeneralPorValorEnLista(listaOrdenEstado, Constante.OrdenEstado.APROBADO));
			selectedOrden.setStEstado(Constante.OrdenEstado.APROBADO);
			ordenManager.save(selectedOrden);
			ordenManager.saveEstado(ordenEstado);
		}
	}

	public void rechazarOrden(){
		if(selectedOrden != null){
			OrdenEstado ordenEstado = new OrdenEstado();
			ordenEstado.setOrden(selectedOrden);
			ordenEstado.setFhFecCreacion(new Date());
			ordenEstado.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
			ordenEstado.setCdIdgeneral(Utilitarios.buscaGeneralPorValorEnLista(listaOrdenEstado, Constante.OrdenEstado.RECHAZADO));
			selectedOrden.setStEstado(Constante.OrdenEstado.RECHAZADO);
			ordenManager.save(selectedOrden);
			ordenManager.saveEstado(ordenEstado);
		}
	}

	public void enviarOrdenes(){
		
	}
	
	public void verDetallesDeEstado(Orden orden){
		if(orden != null){
			listaEstadoDeOrden = ordenManager.findEstadoByOrden(orden.getCdIdorden());
			selectedOrdenEstado = null;
		}
	}
	
	public boolean isRowSelected(){
		return (!selectedOrdenes.isEmpty());
		
	}
	
	public String getSelectedTipoOperacion() {
		return selectedTipoOperacion;
	}

	public void setSelectedTipoOperacion(String selectedTipoOperacion) {
		this.selectedTipoOperacion = selectedTipoOperacion;
	}

	public List<General> getListaTipoOperacion() {
		return listaTipoOperacion;
	}

	public void setListaTipoOperacion(List<General> listaTipoOperacion) {
		this.listaTipoOperacion = listaTipoOperacion;
	}

	public List<Orden> getListaOrdenes() {
		return listaOrdenes;
	}

	public void setListaOrdenes(List<Orden> listaOrdenes) {
		this.listaOrdenes = listaOrdenes;
	}

	public Orden getSelectedOrden() {
		return selectedOrden;
	}

	public void setSelectedOrden(Orden selectedOrden) {
		this.selectedOrden = selectedOrden;
	}

	public GeneralManager getGeneralManager() {
		return generalManager;
	}

	public void setGeneralManager(GeneralManager generalManager) {
		this.generalManager = generalManager;
	}

	public OrdenManager getOrdenManager() {
		return ordenManager;
	}

	public void setOrdenManager(OrdenManager ordenManager) {
		this.ordenManager = ordenManager;
	}

	public String getSelectedEstado() {
		return selectedEstado;
	}

	public void setSelectedEstado(String selectedEstado) {
		this.selectedEstado = selectedEstado;
	}

	public List<General> getListaOrdenEstado() {
		return listaOrdenEstado;
	}

	public void setListaOrdenEstado(List<General> listaOrdenEstado) {
		this.listaOrdenEstado = listaOrdenEstado;
	}

	public List<Orden> getSelectedOrdenes() {
		return selectedOrdenes;
	}

	public void setSelectedOrdenes(List<Orden> selectedOrdenes) {
		this.selectedOrdenes = selectedOrdenes;
	}

	public Map<Integer, String> getMapaMoneda() {
		return mapaMoneda;
	}

	public void setMapaMoneda(Map<Integer, String> mapaMoneda) {
		this.mapaMoneda = mapaMoneda;
	}

	public Map<String, String> getMapaEstado() {
		return mapaEstado;
	}

	public void setMapaEstado(Map<String, String> mapaEstado) {
		this.mapaEstado = mapaEstado;
	}

	public List<OrdenEstado> getListaEstadoDeOrden() {
		return listaEstadoDeOrden;
	}

	public void setListaEstadoDeOrden(List<OrdenEstado> listaEstadoDeOrden) {
		this.listaEstadoDeOrden = listaEstadoDeOrden;
	}

	public OrdenEstado getSelectedOrdenEstado() {
		return selectedOrdenEstado;
	}

	public void setSelectedOrdenEstado(OrdenEstado selectedOrdenEstado) {
		this.selectedOrdenEstado = selectedOrdenEstado;
	}
	
}
