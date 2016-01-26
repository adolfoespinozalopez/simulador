package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.Emisor;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.domain.LimFondoEspecie;
import com.pss.simulador.bs.domain.Saldo;
import com.pss.simulador.bs.service.EmisorManager;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.web.bean.Fondo;

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
	
	//Limites por Emisor y Especie
	private List<Emisor> listaEmisor = new ArrayList<Emisor>();
	private Emisor selectedEmisor;
	
	private List<General> listaEspecie = new ArrayList<General>();
	private General selectedEspecie;
	
	private LimFondoEspecie selectedLimFondoEspecie;
	
	@Autowired
    private GeneralManager generalManager;
	
	@Autowired
    private EmisorManager emisorManager;
	
	public FondoController(){
		
	}
	
	@PostConstruct
	public void init() {
		selectedFondo = null;
		Saldo saldoSoles = new Saldo();
		saldoSoles.setNuNumCuenta("00110661650200023115");
		saldoSoles.setToSaldoInicial(5644254.02);
		saldoSoles.setImDifRescate(0.00);
		saldoSoles.setImSuscripcion(108298.00);
		saldoSoles.setImRescate(1088152.40);
		saldoSoles.setImVencimiento(0.00);
		saldoSoles.setImComprasTmasn(0.00);
		saldoSoles.setImVentasTmasn(0.00);
		saldoSoles.setImComision(0.00);
		saldoSoles.setToSaldoFinal(4664399.62);
		saldoSoles.setImCarteTmenosuno(220189921.25);
		saldoSoles.setImPorcLiquidez(4664399.62);
		saldoSoles.setToSaldoInvertir(260601.194999999);
		saldoSoles.setImLiquidezInmedi(11859106.73);
		Fondo fondoSoles = new Fondo(1, "BBVA SOLES", "PEN","0011");
		fondoSoles.setSaldo(saldoSoles);
		
		Saldo saldoDolares = new Saldo();
		saldoDolares.setNuNumCuenta("00110661670200023077");
		saldoDolares.setToSaldoInicial(7562283.01);
		saldoDolares.setImDifRescate(0.00);
		saldoDolares.setImSuscripcion(12905.00);
		saldoDolares.setImRescate(547749.67);
		saldoDolares.setImVencimiento(0.00);
		saldoDolares.setImComprasTmasn(0.00);
		saldoDolares.setImVentasTmasn(0.00);
		saldoDolares.setImComision(0.00);
		saldoDolares.setToSaldoFinal(7027438.34);
		saldoDolares.setImCarteTmenosuno(92872968.12);
		saldoDolares.setImPorcLiquidez(1857459.3624);
		saldoDolares.setToSaldoInvertir(5169978.9776);
		saldoDolares.setImLiquidezInmedi(33657089.04);
		Fondo fondoDolares = new Fondo(2, "BBVA DOLARES","USD","0022");
		fondoDolares.setSaldo(saldoDolares);
		listaFondos = new ArrayList<Fondo>();
		listaFondos.add(fondoSoles);
		listaFondos.add(fondoDolares);
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
		listaEmisor = emisorManager.findByFund(selectedFondo.getNombre());
		selectedEmisor = null;
		listaEspecie = new ArrayList<General>();
		selectedEspecie = null;
	}
	
	public void eliminar() {
		if (selectedFondo != null) {
			selectedFondo.setEstado("0");
		}
	}

	public void onEmisorRowSelect(SelectEvent event) {
		selectedEmisor = (Emisor) event.getObject();
		listaEspecie = generalManager.findByFundAndTransmitter(selectedFondo.getNombre(), selectedEmisor.getNbNomEmisor());
		selectedEspecie = null;
    }
	
	public void onEspecieRowSelect(SelectEvent event) {
        ((General) event.getObject()).getCdIdgeneral();
    }
	
	public void cancelar() {
		selectedFondo = null;
	}
	
	public void guardarEmisorEspecieLimite() {
		
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
	
}
