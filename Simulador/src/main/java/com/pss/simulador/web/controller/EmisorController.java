package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.SocketUtils;

import com.pss.simulador.bs.domain.Emisor;
import com.pss.simulador.bs.domain.Fondo;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.domain.LimitesEmisor;
import com.pss.simulador.bs.service.EmisorManager;
import com.pss.simulador.bs.service.FondoManager;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.util.Utilitarios;
import com.pss.simulador.web.controller.generic.GenericController;

@Component
@Scope("session")
public class EmisorController extends GenericController {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(EmisorController.class);

	private String emisorNombreBus = "";
	private Integer selectedTipoEmisor = Constante.NO_OPTION_SELECTED_INT;
	private List<General> lstGeneralDominio = new ArrayList<General>();
	private Map<Integer, String> mapaTipoEmisor = new HashMap<Integer, String>();
	
	private Emisor selectedEmisor;
	private List<Emisor> listaEmisor = new ArrayList<Emisor>();

	private List<Fondo> listaFondo = new ArrayList<Fondo>();
	private Fondo selectedFondo;

	@Autowired
	private GeneralManager generalManager;

	@Autowired
	private EmisorManager emisorManager;

	@Autowired
	private FondoManager fondoManager;

	// Limites
	private LimitesEmisor selectedlimiteEmisor = new LimitesEmisor();
	public boolean value1;
	public boolean value2;

	public EmisorController() {

	}

	public boolean isValue1() {
		return value1;
	}

	public void setValue1(boolean value1) {
		this.value1 = value1;
	}

	public boolean isValue2() {
		return value2;
	}

	public void setValue2(boolean value2) {
		this.value2 = value2;
	}

	@PostConstruct
	public void init() {
		listaEmisor = new ArrayList<Emisor>();
		selectedEmisor = new Emisor();
		selectedEmisor.setTpTipemisor(Constante.NO_OPTION_SELECTED_INT);
		this.listarEmisor(selectedEmisor);

		listaFondo = fondoManager.findAll();
		lstGeneralDominio = generalManager.findByDomainAndState(Constante.Dominio.TIPO_EMISOR, Constante.ESTADO_ACTIVO);
		for (General tipoEmisor : lstGeneralDominio) {
			mapaTipoEmisor.put(tipoEmisor.getCdIdgeneral(), tipoEmisor.getNbDescGeneral());
		}
	}

	public void buscar() {
		selectedEmisor = new Emisor();
		selectedEmisor.setNbNomEmisor(this.emisorNombreBus);
		selectedEmisor.setTpTipemisor(this.selectedTipoEmisor);
		this.listarEmisor(selectedEmisor);
	}

	public void crear() {
		selectedEmisor = new Emisor();
		value1=false;
		value2=false;
	}

	public void guardarEmisor() {
		try {
			if (selectedEmisor != null) {	
				selectedEmisor.setTpMicroFina((value1)?"1":"0");
				selectedEmisor.setTpGrupoBbva((value2)?"1":"0");
				
				if (selectedEmisor.getCdIdemisor() != null) {// Actualizacion
					selectedEmisor.setFhFecModifica(new Date());
					selectedEmisor.setCdUsuModifica(this.getUsuarioSession().getUsuario().getUID());
				} else {// Registro
					selectedEmisor.setFhFecCreacion(new Date());
					selectedEmisor.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
				}
				selectedEmisor = emisorManager.save(selectedEmisor);
			}
			Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_REGISTRO_OK, null);
		} catch (Exception e) {
			logger.error(e, e);
			Utilitarios.mostrarMensajeError(null, Constante.Mensajes.MSJ_REGISTRO_FAIL, e.getMessage());
		}
		selectedEmisor = new Emisor();
		selectedEmisor.setNbNomEmisor("");
		selectedEmisor.setTpTipemisor(Constante.NO_OPTION_SELECTED_INT);
		this.listarEmisor(selectedEmisor);
	}

	public void onFondoRowSelect(SelectEvent event) {
		selectedFondo = (Fondo) event.getObject();
		LimitesEmisor limiteEmisorConsulta = new LimitesEmisor();
		limiteEmisorConsulta.setEmisor(selectedEmisor);
		limiteEmisorConsulta.setFondo(selectedFondo);
		selectedlimiteEmisor = emisorManager.findByFondoAndEmisor(limiteEmisorConsulta);
		selectedlimiteEmisor = (selectedlimiteEmisor == null)?new LimitesEmisor():selectedlimiteEmisor;
	}

	public void guardarEmisorLimite() {
		try {
			if (selectedlimiteEmisor != null) {
				selectedlimiteEmisor.setStEstado(Constante.ESTADO_ACTIVO);
				if (selectedlimiteEmisor.getCdIdlimite() != null) {// Actualizacion
					selectedlimiteEmisor.setFhFecModifica(new Date());
					selectedlimiteEmisor.setCdUsuModifica(this.getUsuarioSession().getUsuario().getUID());
				} else {// Registro
					selectedlimiteEmisor.setFondo(selectedFondo);
					selectedlimiteEmisor.setEmisor(selectedEmisor);
					selectedlimiteEmisor.setCdIdlimite(null);
					selectedlimiteEmisor.setFhFecCreacion(new Date());
					selectedlimiteEmisor.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
				}
				selectedlimiteEmisor = emisorManager.saveLimiteEmisor(selectedlimiteEmisor);
			}
			Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_REGISTRO_OK, null);
		} catch (Exception e) {
			logger.error(e, e);
			Utilitarios.mostrarMensajeError(null, Constante.Mensajes.MSJ_REGISTRO_FAIL, e.getMessage());
		}
		selectedlimiteEmisor = null;
		selectedEmisor = new Emisor();
		selectedEmisor.setNbNomEmisor("");
		selectedEmisor.setTpTipemisor(Constante.NO_OPTION_SELECTED_INT);
		this.listarEmisor(selectedEmisor);
	}

	public void listarEmisor(Emisor emisor) {
		listaEmisor = emisorManager.findEmisorByNameAndType(emisor);
	}

	public void verDetalles(Emisor emisor) {
		selectedEmisor = emisor;
		setValue1((selectedEmisor.getTpMicroFina().equals("1"))?true:false);
		setValue2((selectedEmisor.getTpGrupoBbva().equals("1"))?true:false);
		System.out.println(value1);

		
	}

	public void eliminar() {
		if (selectedEmisor != null) {
			selectedEmisor.setStEstado(Constante.ESTADO_INACTIVO);
			selectedEmisor.setFhFecElimina(new Date());
			selectedEmisor.setCdUsuElimina(this.getUsuarioSession().getUsuario().getUID());
		}
		selectedEmisor = emisorManager.save(selectedEmisor);
		selectedEmisor = new Emisor();
		selectedEmisor.setNbNomEmisor("");
		selectedEmisor.setTpTipemisor(Constante.NO_OPTION_SELECTED_INT);
		this.listarEmisor(selectedEmisor);
		Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_ELIMINACION_OK, null);
	}

	public void verLimites(Emisor emisor) {
		selectedEmisor = emisor;
		selectedFondo = new Fondo();
		selectedlimiteEmisor = new LimitesEmisor();
	}

	public void cancelar() {
		selectedEmisor = null;
	}

	public String getEmisorNombreBus() {
		return emisorNombreBus;
	}

	public void setEmisorNombreBus(String emisorNombreBus) {
		this.emisorNombreBus = emisorNombreBus;
	}

	public Integer getSelectedTipoEmisor() {
		return selectedTipoEmisor;
	}

	public void setSelectedTipoEmisor(Integer selectedTipoEmisor) {
		this.selectedTipoEmisor = selectedTipoEmisor;
	}

	public List<General> getLstGeneralDominio() {
		return lstGeneralDominio;
	}

	public void setLstGeneralDominio(List<General> lstGeneralDominio) {
		this.lstGeneralDominio = lstGeneralDominio;
	}

	public Emisor getSelectedEmisor() {
		return selectedEmisor;
	}

	public void setSelectedEmisor(Emisor selectedEmisor) {
		this.selectedEmisor = selectedEmisor;
	}

	public List<Emisor> getListaEmisor() {
		return listaEmisor;
	}

	public void setListaEmisor(List<Emisor> listaEmisor) {
		this.listaEmisor = listaEmisor;
	}

	public GeneralManager getGeneralManager() {
		return generalManager;
	}

	public void setGeneralManager(GeneralManager generalManager) {
		this.generalManager = generalManager;
	}

	public LimitesEmisor getSelectedlimiteEmisor() {
		return selectedlimiteEmisor;
	}

	public void setSelectedlimiteEmisor(LimitesEmisor selectedlimiteEmisor) {
		this.selectedlimiteEmisor = selectedlimiteEmisor;
	}

	public List<Fondo> getListaFondo() {
		return listaFondo;
	}

	public void setListaFondo(List<Fondo> listaFondo) {
		this.listaFondo = listaFondo;
	}

	public Fondo getSelectedFondo() {
		return selectedFondo;
	}

	public void setSelectedFondo(Fondo selectedFondo) {
		this.selectedFondo = selectedFondo;
	}

	public EmisorManager getEmisorManager() {
		return emisorManager;
	}

	public void setEmisorManager(EmisorManager emisorManager) {
		this.emisorManager = emisorManager;
	}

	public FondoManager getFondoManager() {
		return fondoManager;
	}

	public void setFondoManager(FondoManager fondoManager) {
		this.fondoManager = fondoManager;
	}

	public Map<Integer, String> getMapaTipoEmisor() {
		return mapaTipoEmisor;
	}

	public void setMapaTipoEmisor(Map<Integer, String> mapaTipoEmisor) {
		this.mapaTipoEmisor = mapaTipoEmisor;
	}

}
