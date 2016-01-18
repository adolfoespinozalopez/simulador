package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.pss.simulador.web.bean.Fondo;
import com.pss.simulador.web.bean.Simulacion;

/**
 *
 * @author Adolfo Espinoza
 * @version 1.0, 08/01/2016
 * @since 1.0
 */
@Component
@ManagedBean(name = "simulacionController")
@RequestScoped
public class SimulacionController {

	private static final Logger LOG = Logger.getLogger(SimulacionController.class);
	private List<Simulacion> lista = new ArrayList<Simulacion>();
	private Fondo selectedFondo;

	public SimulacionController() {

	}

	@PostConstruct
	public void init() {
		lista = new ArrayList<Simulacion>();
		lista.add(new Simulacion("Acciones", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
		lista.add(new Simulacion("Bonos Soberanos", 102737621.00, 30.4, 102737621.00, 30.4, 0.0, 0.0, 5.14, 5.31));
		lista.add(new Simulacion("SB12AGO17", 24157736.00, 7.1, 0.0, 0.0, 0.0, 0.0, 2.95, 4.23));
		lista.add(new Simulacion("SB12AGO20", 52154567.00, 15.4, 0.0, 0.0, 0.0, 0.0, 5.16, 5.60));
		lista.add(new Simulacion("SB12SEP23", 8937319.00, 2.6, 0.0, 0.0, 0.0, 0.0, 7.53, 5.99));
		lista.add(new Simulacion("SB12AGO24", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
		lista.add(new Simulacion("SB12AGO26", 4489669.00, 1.3, 0.0, 0.0, 0.0, 0.0, 8.34, 6.10));
		lista.add(new Simulacion("SB12FEB29", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
		lista.add(new Simulacion("SB12AGO31", 7224132.00, 2.1, 0.0, 0.0, 0.0, 0.0, 10.43, 6.66));
		lista.add(new Simulacion("SB12AGO37", 225527.00, 0.1, 0.0, 0.0, 0.0, 0.0, 11.97, 6.82));
		lista.add(new Simulacion("SB12FEB42", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
		lista.add(new Simulacion("SB12FEB55", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
		lista.add(new Simulacion("Bonos Coorporativos", 69442881.00, 20.5, 69442881.00, 20.5, 0.0, 0.0, 2.38, 5.84));
		lista.add(new Simulacion("Bonos Arrendamiento", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
		lista.add(new Simulacion("Letras del Tesoro", 5367338.00, 1.6, 5367338.00, 1.6, 0.0, 0.0, 0.39, 0.00));
		lista.add(new Simulacion("CD BCRP", 34416512.00, 10.2, 34416512.00, 10.2, 0.0, 0.0, 0.71, 3.55));
		lista.add(new Simulacion("CD Bancos", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
		lista.add(new Simulacion("Papeles Comerciales", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
		lista.add(new Simulacion("Depósitos a Plazo", 120551047.00, 35.6, 100546717.00, 29.7, 20004330.0, 5.9, 0.04, 3.54));
		lista.add(new Simulacion("Depósitos de Ahorro", 6914235.00, 2.0, 6914235.0, 2.0, 1602.0, 0.0, 0.0, 0.30));
		lista.add(new Simulacion("Derivados", -3049.0, 0.0, -3049.0, 0.0, 0.0, 0.0, 0.02, 2.81));
		lista.add(new Simulacion("Suscripción + Vtas.", 108298.0, 0.0, 108298.0, 0.0, 0.0, 0.0, 0.02, 2.81));
		lista.add(new Simulacion("Rescate + Comp.", 1088152.0, -0.3, 1088152.0, 0.3, 0.0, 0.0, 0.0, 0.0));
	}

	public List<Simulacion> getLista() {
		return lista;
	}

	public void setLista(List<Simulacion> lista) {
		this.lista = lista;
	}

	public Fondo getSelectedFondo() {
		return selectedFondo;
	}

	public void setSelectedFondo(Fondo selectedFondo) {
		this.selectedFondo = selectedFondo;
	}
}
