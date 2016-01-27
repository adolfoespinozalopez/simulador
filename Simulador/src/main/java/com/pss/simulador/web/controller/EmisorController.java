package com.pss.simulador.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.Emisor;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.domain.LimitesEmisor;
import com.pss.simulador.bs.domain.LimitesEmisorPK;
import com.pss.simulador.bs.service.EmisorManager;
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
	
	private Emisor selectedEmisor;
	private List<Emisor> listaEmisor = new ArrayList<Emisor>();
	
	@Autowired
    private GeneralManager generalManager;
	
	@Autowired
    private EmisorManager emisorManager;
	
	//Limites
	private LimitesEmisor selectedlimiteEmisor = new LimitesEmisor();
	
	public EmisorController(){
		
	}
	
	@PostConstruct
	public void init() {
		listaEmisor = new ArrayList<Emisor>();
		selectedEmisor = new Emisor();
		selectedEmisor.setTpTipemisor(Constante.NO_OPTION_SELECTED_INT);
		this.listarEmisor(selectedEmisor);
		
		lstGeneralDominio = generalManager.findByDomainAndState(Constante.Dominio.TIPO_EMISOR, Constante.ESTADO_ACTIVO);
	}
	
	public void buscar() {
		selectedEmisor = new Emisor();
		selectedEmisor.setNbNomEmisor(this.emisorNombreBus);
		selectedEmisor.setTpTipemisor(this.selectedTipoEmisor);
		this.listarEmisor(selectedEmisor);
	}

	public void crear() {
		selectedEmisor = new Emisor();
	}
	
	public void guardarEmisor() {
		try {
			if(selectedEmisor!=null){
				if (selectedEmisor!=null)
				selectedEmisor.setStEstado(Constante.ESTADO_ACTIVO);
				if (selectedEmisor.getCdIdemisor()!=null){//Actualizacion
					selectedEmisor.setFhFecModifica(new Date());
					selectedEmisor.setCdUsuModifica(this.getUsuarioSession().getUsuario().getUID());
				}else{// Registro
					selectedEmisor.setFhFecCreacion(new Date());
					selectedEmisor.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
				}
				selectedEmisor=emisorManager.save(selectedEmisor);
			}
			Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_REGISTRO_OK, null);	
		} catch (Exception e) {
			logger.error(e,e);
			Utilitarios.mostrarMensajeError(null, Constante.Mensajes.MSJ_REGISTRO_FAIL, e.getMessage());
		}
		selectedEmisor=new Emisor();
		selectedEmisor.setNbNomEmisor("");
		selectedEmisor.setTpTipemisor(Constante.NO_OPTION_SELECTED_INT);
		this.listarEmisor(selectedEmisor);
	}
	
	public void guardarEmisorLimite() {
		try {
			if(selectedlimiteEmisor!=null){
				selectedlimiteEmisor.setStEstado(Constante.ESTADO_ACTIVO);
				if (selectedlimiteEmisor.getLimitesEmisorPK()!=null &&
						selectedlimiteEmisor.getLimitesEmisorPK().getCdIdlimite()!=null){//Actualizacion
					selectedlimiteEmisor.setFhFecModifica(new Date());
					selectedlimiteEmisor.setCdUsuModifica(this.getUsuarioSession().getUsuario().getUID());
				}else{// Registro
					selectedlimiteEmisor.setLimitesEmisorPK(new LimitesEmisorPK(null, selectedEmisor.getCdIdemisor()));
					selectedlimiteEmisor.setFhFecCreacion(new Date());
					selectedlimiteEmisor.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
				}
				selectedlimiteEmisor=emisorManager.saveLimiteEmisor(selectedlimiteEmisor);
			}
			Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_REGISTRO_OK, null);	
		} catch (Exception e) {
			logger.error(e,e);
			Utilitarios.mostrarMensajeError(null, Constante.Mensajes.MSJ_REGISTRO_FAIL, e.getMessage());
		}
		selectedEmisor=new Emisor();
		selectedEmisor.setNbNomEmisor("");
		selectedEmisor.setTpTipemisor(Constante.NO_OPTION_SELECTED_INT);
		this.listarEmisor(selectedEmisor);
	}
	
	public void listarEmisor(Emisor emisor){
		listaEmisor = emisorManager.findEmisorByNameAndType(emisor);
	}

	public void verDetalles(Emisor emisor) {
		selectedEmisor = emisor;
	}

	public void eliminar() {
		if (selectedEmisor != null) {
			selectedEmisor.setStEstado(Constante.ESTADO_INACTIVO);
			selectedEmisor.setFhFecElimina(new Date());
			selectedEmisor.setCdUsuElimina(this.getUsuarioSession().getUsuario().getUID());
		}
		selectedEmisor = emisorManager.save(selectedEmisor);
		selectedEmisor=new Emisor();
		selectedEmisor.setNbNomEmisor("");
		selectedEmisor.setTpTipemisor(Constante.NO_OPTION_SELECTED_INT);
		this.listarEmisor(selectedEmisor);
		Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_ELIMINACION_OK, null);
	}

	public void verLimites(Emisor emisor) {
		selectedEmisor = emisor;
		selectedlimiteEmisor = (emisor.getLimitesEmisorList()!=null && emisor.getLimitesEmisorList().size()>0)?emisor.getLimitesEmisorList().get(0):new LimitesEmisor();
	}
	
	public void cancelar() {
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
	
	
}
