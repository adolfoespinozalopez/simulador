package com.pss.simulador.web.controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.pss.simulador.bs.domain.Emisor;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.domain.LimFondoEspecie;
import com.pss.simulador.bs.domain.Saldo;
import com.pss.simulador.bs.service.EmisorManager;
import com.pss.simulador.bs.service.FondoManager;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.util.Constante;
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
public class FondoController extends GenericController {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FondoController.class);
	private String fondoNombreBus = "";
	
	private Saldo selectedSaldo;
	private List<Saldo> listaSaldos = new ArrayList<Saldo>();
	
	//Limites por Emisor y Especie
	private List<Emisor> listaEmisor = new ArrayList<Emisor>();
	private Emisor selectedEmisor;
	
	private List<General> listaEspecie = new ArrayList<General>();
	private General selectedEspecie;
	
	private LimFondoEspecie selectedLimFondoEspecie;
	
	private DecimalFormat formato = new DecimalFormat("###,###,###,###,###.00");
	DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(); 
	
	@Autowired
    private GeneralManager generalManager;
	
	@Autowired
    private EmisorManager emisorManager;
	
	@Autowired
    private FondoManager fondoManager;
	
	public FondoController(){
		
	}
	
	@PostConstruct
	public void init() {
		otherSymbols.setGroupingSeparator((char) 44);
		otherSymbols.setDecimalSeparator((char) 46);
		formato = new DecimalFormat("###,###,###.00", otherSymbols);
		selectedSaldo = null;
		this.listarSaldos();
	}

	private void listarSaldos() {
		listaSaldos = fondoManager.findSaldoByName(fondoNombreBus);
	}

	public void buscar() {
		listarSaldos();
	}

	public void crear() {
		selectedSaldo = new Saldo();
	}

	public void verDetalles(Saldo saldo) {
		selectedSaldo = saldo;
	}

	public void verLimites(Saldo saldo) {
		selectedSaldo = saldo;
		listaEmisor = emisorManager.findByFund(selectedSaldo.getNbNomFondo());
		selectedEmisor = new Emisor();
		selectedEspecie = new General();
		selectedLimFondoEspecie = new LimFondoEspecie();
		listaEspecie = new ArrayList<General>();
	}
	
	public void onEmisorRowSelect(SelectEvent event) {
		selectedEmisor = (Emisor) event.getObject();
		listaEspecie = generalManager.findByFundAndTransmitter(selectedSaldo.getNbNomFondo(), selectedEmisor.getNbNomEmisor());
		selectedEspecie = new General();
    }
	
	public void onEspecieRowSelect(SelectEvent event) {
        General cdIdEspecie = ((General) event.getObject());
        LimFondoEspecie limFondoEspecieConsulta = new LimFondoEspecie();
        limFondoEspecieConsulta.setEmisor(selectedEmisor);
        limFondoEspecieConsulta.setGeneral(cdIdEspecie);
        limFondoEspecieConsulta.setFondo(fondoManager.findFondoByName(selectedSaldo.getNbNomFondo()));
        selectedLimFondoEspecie = fondoManager.findLimFondoEspecieByFondoAndEmisorAndEspecie(limFondoEspecieConsulta);
        selectedLimFondoEspecie = (selectedLimFondoEspecie ==null)?new LimFondoEspecie():selectedLimFondoEspecie;
        selectedLimFondoEspecie.setSnuMontoIni((selectedLimFondoEspecie.getNuMontoIni() ==null)?"":formato.format(selectedLimFondoEspecie.getNuMontoIni()));
        selectedLimFondoEspecie.setSnuMontoFin((selectedLimFondoEspecie.getNuMontoFin() ==null)?"":formato.format(selectedLimFondoEspecie.getNuMontoFin()));
    }
	
	public void cancelar() {
		selectedSaldo = null;
	}
	
	public void guardarEmisorEspecieLimite() {
		try {
			if(selectedLimFondoEspecie!=null){
				selectedLimFondoEspecie.setStEstado(Constante.ESTADO_ACTIVO);
				selectedLimFondoEspecie.setEmisor(selectedEmisor);
				selectedLimFondoEspecie.setGeneral(selectedEspecie);
				selectedLimFondoEspecie.setFondo(fondoManager.findFondoByName(selectedSaldo.getNbNomFondo()));
				selectedLimFondoEspecie.setNuMontoIni(formato.parse(selectedLimFondoEspecie.getSnuMontoIni()).doubleValue());
				selectedLimFondoEspecie.setNuMontoFin(formato.parse(selectedLimFondoEspecie.getSnuMontoFin()).doubleValue());
				
				if (selectedLimFondoEspecie.getCdIdconfiguracion()!=null){//Actualizacion
					selectedLimFondoEspecie.setFhFecModifica(new Date());
					selectedLimFondoEspecie.setCdUsuModifica(this.getUsuarioSession().getUsuario().getUID());
				}else{// Registro
					selectedLimFondoEspecie.setFhFecCreacion(new Date());
					selectedLimFondoEspecie.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
				}
				selectedLimFondoEspecie=fondoManager.saveLimFondoEspecie(selectedLimFondoEspecie);
			}
			Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_REGISTRO_OK, null);	
		} catch (Exception e) {
			logger.error(e,e);
			Utilitarios.mostrarMensajeError(null, Constante.Mensajes.MSJ_REGISTRO_FAIL, e.getMessage());
		}
		selectedLimFondoEspecie=null;
		this.listarSaldos();
	}
	
	public String getFondoNombreBus() {
		return fondoNombreBus;
	}

	public void setFondoNombreBus(String fondoNombreBus) {
		this.fondoNombreBus = fondoNombreBus;
	}

	public LimFondoEspecie getSelectedLimFondoEspecie() {
		return selectedLimFondoEspecie;
	}

	public void setSelectedLimFondoEspecie(LimFondoEspecie selectedLimFondoEspecie) {
		this.selectedLimFondoEspecie = selectedLimFondoEspecie;
	}

	public List<Emisor> getListaEmisor() {
		return listaEmisor;
	}

	public void setListaEmisor(List<Emisor> listaEmisor) {
		this.listaEmisor = listaEmisor;
	}

	public Emisor getSelectedEmisor() {
		return selectedEmisor;
	}

	public void setSelectedEmisor(Emisor selectedEmisor) {
		this.selectedEmisor = selectedEmisor;
	}

	public List<General> getListaEspecie() {
		return listaEspecie;
	}

	public void setListaEspecie(List<General> listaEspecie) {
		this.listaEspecie = listaEspecie;
	}

	public General getSelectedEspecie() {
		return selectedEspecie;
	}

	public void setSelectedEspecie(General selectedEspecie) {
		this.selectedEspecie = selectedEspecie;
	}

	public Saldo getSelectedSaldo() {
		return selectedSaldo;
	}

	public void setSelectedSaldo(Saldo selectedSaldo) {
		this.selectedSaldo = selectedSaldo;
	}

	public List<Saldo> getListaSaldos() {
		return listaSaldos;
	}
	
	public void setListaSaldos(List<Saldo> listaSaldos) {
		this.listaSaldos = listaSaldos;
	}
	
}
