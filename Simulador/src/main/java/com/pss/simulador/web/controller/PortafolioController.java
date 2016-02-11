package com.pss.simulador.web.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.DetalleOrden;
import com.pss.simulador.bs.domain.Emisor;
import com.pss.simulador.bs.domain.Fondo;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.domain.Infoport;
import com.pss.simulador.bs.domain.Orden;
import com.pss.simulador.bs.domain.OrdenEstado;
import com.pss.simulador.bs.service.EmisorManager;
import com.pss.simulador.bs.service.FondoManager;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.bs.service.InfoportManager;
import com.pss.simulador.bs.service.OrdenManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.util.FechasUtil;
import com.pss.simulador.util.Utilitarios;
import com.pss.simulador.web.controller.generic.GenericController;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 20/01/2016
* @since 1.0
*/
@Component
@Scope("session")
public class PortafolioController extends GenericController{

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(PortafolioController.class);
	
	private List<Fondo> listaFondo = new ArrayList<Fondo>();
	private String selectedFondo = Constante.NO_OPTION_SELECTED;
	
	private List<Emisor> listaEmisor = new ArrayList<Emisor>();
	private String selectedEmisor = Constante.NO_OPTION_SELECTED;
	
	private String selectedCondicion = Constante.NO_OPTION_SELECTED;
	
	private List<General> listaTipoOperacion = new ArrayList<General>();
	private String selectedTipoOperacion = Constante.NO_OPTION_SELECTED;
	
	private List<Infoport> listaPortafolio = new ArrayList<Infoport>();
	private Infoport selectedInfo;
	
	private String mensajeValida;
	private String fechaActual;
	
	private List<General> listaOrdenEstado = new ArrayList<General>();
	
	private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	private DecimalFormat formato = new DecimalFormat("###,###,###.00");
	private DecimalFormat formatoTasa = new DecimalFormat("0.00");
	
	@Autowired
	private NotificacionController notificacionController;
	
	@Autowired
	private FondoManager fondoManager;
	
	@Autowired
    private GeneralManager generalManager;
	
	@Autowired
    private InfoportManager infoportManager;
	
	@Autowired
    private EmisorManager emisorManager;
	
	@Autowired
	private OrdenManager ordenManager;
	
	/*
	 * Modal
	 */
	List<General> listaOperacion = new ArrayList<General>();
	List<General> listaContraparte = new ArrayList<General>();
	List<General> listaMoneda = new ArrayList<General>();
	List<General> listaEspecie = new ArrayList<General>();
	
	List<General> listaIntermediario = new ArrayList<General>();
	private Integer selectedIntermediario = Constante.NO_OPTION_SELECTED_INT;
	
	List<General> listaLugar = new ArrayList<General>();
	private Integer selectedLugar = Constante.NO_OPTION_SELECTED_INT;
	
	List<General> listaPais = new ArrayList<General>();
	private Integer selectedPais = Constante.NO_OPTION_SELECTED_INT;
	
	private String tasaPreCancelacion;
	private String montoPreCancelacion;
	
	private String selectedFondoAper = Constante.NO_OPTION_SELECTED;
	private String selectedContraAper = Constante.NO_OPTION_SELECTED;
	private String selectedMonedaAper = Constante.NO_OPTION_SELECTED;
	private String selectedTipoAper = Constante.NO_OPTION_SELECTED;
	private String importeAper;
	private String tasaAper;
	private String plazoAper;
	private Date fechaVctoAper;
	
	private String importeRenova;
	private String tasaRenova;
	private String plazoRenova;
	private Date fechaVctoRenova;
	
	private String selectedTipoSpot = Constante.NO_OPTION_SELECTED;
	private String selectedContraSpot = Constante.NO_OPTION_SELECTED;
	private String tipoCambioSpot;
	
	private String montoUno;
	private String montoTotal;
	
	private String selectedTipoFwd = Constante.NO_OPTION_SELECTED;
	private String selectedContraFwd = Constante.NO_OPTION_SELECTED;
	private String selectedSettleFwd = Constante.NO_OPTION_SELECTED;
	private String puntosFwd;
	private String tipoCambioFwd;
	private String plazoFwd;
	
	private String selectedFondoAbono = Constante.NO_OPTION_SELECTED;
	private String selectedTipoAbono = Constante.NO_OPTION_SELECTED;
	private String selectedContraAbono = Constante.NO_OPTION_SELECTED;
	private String montoAbono;
	
	private Date fechaInicial;
	private Date fechaFinal;
	
	private List<Orden> listaOrdenes = new ArrayList<Orden>();
	private Orden selectedOrden;
	
	@PostConstruct
	public void init() {
		listaPortafolio = new ArrayList<Infoport>();
		ejecutarbusqueda();
		fechaInicial = Constante.FECHA_ACTUAL;
		fechaActual = formatoFecha.format(fechaInicial);
		
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(fechaInicial);
		cal.add(Calendar.DATE, 3);
		fechaFinal = cal.getTime();
		
		//Combos
		listaFondo = fondoManager.findAll();
		listaEmisor = emisorManager.findAllActive();
		listaOperacion = generalManager.findByDomainAndState(Constante.Dominio.OPERACION, Constante.ESTADO_ACTIVO);
		listaTipoOperacion = generalManager.findByDomainAndState(Constante.Dominio.TIPO_OPERACION, Constante.ESTADO_ACTIVO);
		listaOrdenEstado = generalManager.findByDomainAndState(Constante.Dominio.ESTADO_ORDEN, Constante.ESTADO_ACTIVO);
		
		//Modal Combos
		listaContraparte = generalManager.findByDomainAndState(Constante.Dominio.CONTRAPARTE, Constante.ESTADO_ACTIVO);
		listaMoneda = generalManager.findByDomainAndState(Constante.Dominio.MONEDA, Constante.ESTADO_ACTIVO);
		listaEspecie =  generalManager.findByDomainAndState(Constante.Dominio.ESPECIE, Constante.ESTADO_ACTIVO);
		listaIntermediario = generalManager.findByDomainAndState(Constante.Dominio.INTERMEDIARIO, Constante.ESTADO_ACTIVO);
		listaLugar = generalManager.findByDomainAndState(Constante.Dominio.LUGAR, Constante.ESTADO_ACTIVO);
		listaPais = generalManager.findByDomainAndState(Constante.Dominio.PAIS, Constante.ESTADO_ACTIVO);
	}

	public void realizarFiltroDeFondo(ValueChangeEvent event) {
        Object objNew = event.getNewValue();
        if (objNew != null) {
        	setSelectedFondo(objNew.toString());
        }
        ejecutarbusqueda();
    }
	
	public void realizarFiltroDeEmisor(ValueChangeEvent event) {
        Object objNew = event.getNewValue();
        if (objNew != null) {
        	setSelectedEmisor(objNew.toString());
        }
        ejecutarbusqueda();
    }
	
	public void realizarFiltroDeCondicion(ValueChangeEvent event) {
        Object objNew = event.getNewValue();
        if (objNew != null) {
        	setSelectedCondicion(objNew.toString());
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
		listaPortafolio = infoportManager.findByFilter(selectedFondo, selectedEmisor, selectedCondicion, selectedTipoOperacion);
	}
	
	public List<Infoport> getListaPortafolio() {
		return listaPortafolio;
	}

	public void setListaPortafolio(List<Infoport> listaPortafolio) {
		this.listaPortafolio = listaPortafolio;
	}

	public Infoport getSelectedInfo() {
		return selectedInfo;
	}

	public void setSelectedInfo(Infoport selectedInfo) {
		this.selectedInfo = selectedInfo;
	}

	public List<Fondo> getListaFondo() {
		return listaFondo;
	}

	public void setListaFondo(List<Fondo> listaFondo) {
		this.listaFondo = listaFondo;
	}

	public String getSelectedFondo() {
		return selectedFondo;
	}

	public void setSelectedFondo(String selectedFondo) {
		this.selectedFondo = selectedFondo;
	}

	public List<Emisor> getListaEmisor() {
		return listaEmisor;
	}

	public void setListaEmisor(List<Emisor> listaEmisor) {
		this.listaEmisor = listaEmisor;
	}

	public String getSelectedEmisor() {
		return selectedEmisor;
	}

	public void setSelectedEmisor(String selectedEmisor) {
		this.selectedEmisor = selectedEmisor;
	}

	public String getSelectedCondicion() {
		return selectedCondicion;
	}

	public void setSelectedCondicion(String selectedCondicion) {
		this.selectedCondicion = selectedCondicion;
	}

	public String getSelectedTipoOperacion() {
		return selectedTipoOperacion;
	}

	public void setSelectedTipoOperacion(String selectedTipoOperacion) {
		this.selectedTipoOperacion = selectedTipoOperacion;
	}

	public String getMensajeValida() {
		return mensajeValida;
	}

	public void setMensajeValida(String mensajeValida) {
		this.mensajeValida = mensajeValida;
	}
	
	public String getTasaPreCancelacion() {
		return tasaPreCancelacion;
	}

	public void setTasaPreCancelacion(String tasaPreCancelacion) {
		this.tasaPreCancelacion = tasaPreCancelacion;
	}

	public String getMontoPreCancelacion() {
		return montoPreCancelacion;
	}

	public void setMontoPreCancelacion(String montoPreCancelacion) {
		this.montoPreCancelacion = montoPreCancelacion;
	}

	public String getSelectedFondoAper() {
		return selectedFondoAper;
	}

	public void setSelectedFondoAper(String selectedFondoAper) {
		this.selectedFondoAper = selectedFondoAper;
	}

	public String getSelectedContraAper() {
		return selectedContraAper;
	}

	public void setSelectedContraAper(String selectedContraAper) {
		this.selectedContraAper = selectedContraAper;
	}

	public String getSelectedMonedaAper() {
		return selectedMonedaAper;
	}

	public void setSelectedMonedaAper(String selectedMonedaAper) {
		this.selectedMonedaAper = selectedMonedaAper;
	}

	public String getSelectedTipoAper() {
		return selectedTipoAper;
	}

	public void setSelectedTipoAper(String selectedTipoAper) {
		this.selectedTipoAper = selectedTipoAper;
	}

	public String getImporteAper() {
		return importeAper;
	}

	public void setImporteAper(String importeAper) {
		this.importeAper = importeAper;
	}

	public String getTasaAper() {
		return tasaAper;
	}

	public void setTasaAper(String tasaAper) {
		this.tasaAper = tasaAper;
	}

	public String getPlazoAper() {
		return plazoAper;
	}

	public void setPlazoAper(String plazoAper) {
		this.plazoAper = plazoAper;
	}

	public Date getFechaVctoAper() {
		return fechaVctoAper;
	}

	public void setFechaVctoAper(Date fechaVctoAper) {
		this.fechaVctoAper = fechaVctoAper;
	}
	
	public String getImporteRenova() {
		return importeRenova;
	}

	public void setImporteRenova(String importeRenova) {
		this.importeRenova = importeRenova;
	}

	public String getTasaRenova() {
		return tasaRenova;
	}

	public void setTasaRenova(String tasaRenova) {
		this.tasaRenova = tasaRenova;
	}

	public String getPlazoRenova() {
		return plazoRenova;
	}

	public void setPlazoRenova(String plazoRenova) {
		this.plazoRenova = plazoRenova;
	}

	public Date getFechaVctoRenova() {
		return fechaVctoRenova;
	}

	public void setFechaVctoRenova(Date fechaVctoRenova) {
		this.fechaVctoRenova = fechaVctoRenova;
	}

	public String getSelectedTipoSpot() {
		return selectedTipoSpot;
	}

	public void setSelectedTipoSpot(String selectedTipoSpot) {
		this.selectedTipoSpot = selectedTipoSpot;
	}

	public String getSelectedContraSpot() {
		return selectedContraSpot;
	}

	public void setSelectedContraSpot(String selectedContraSpot) {
		this.selectedContraSpot = selectedContraSpot;
	}

	public String getTipoCambioSpot() {
		return tipoCambioSpot;
	}

	public void setTipoCambioSpot(String tipoCambioSpot) {
		this.tipoCambioSpot = tipoCambioSpot;
	}

	public String getMontoUno() {
		return montoUno;
	}

	public void setMontoUno(String montoUno) {
		this.montoUno = montoUno;
	}

	public String getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(String montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getSelectedTipoFwd() {
		return selectedTipoFwd;
	}

	public void setSelectedTipoFwd(String selectedTipoFwd) {
		this.selectedTipoFwd = selectedTipoFwd;
	}

	public String getSelectedContraFwd() {
		return selectedContraFwd;
	}

	public void setSelectedContraFwd(String selectedContraFwd) {
		this.selectedContraFwd = selectedContraFwd;
	}

	public String getSelectedSettleFwd() {
		return selectedSettleFwd;
	}

	public void setSelectedSettleFwd(String selectedSettleFwd) {
		this.selectedSettleFwd = selectedSettleFwd;
	}

	public String getTipoCambioFwd() {
		return tipoCambioFwd;
	}

	public void setTipoCambioFwd(String tipoCambioFwd) {
		this.tipoCambioFwd = tipoCambioFwd;
	}

	public String getPuntosFwd() {
		return puntosFwd;
	}

	public void setPuntosFwd(String puntosFwd) {
		this.puntosFwd = puntosFwd;
	}

	public String getPlazoFwd() {
		return plazoFwd;
	}

	public void setPlazoFwd(String plazoFwd) {
		this.plazoFwd = plazoFwd;
	}

	public String getSelectedFondoAbono() {
		return selectedFondoAbono;
	}

	public void setSelectedFondoAbono(String selectedFondoAbono) {
		this.selectedFondoAbono = selectedFondoAbono;
	}

	public String getSelectedTipoAbono() {
		return selectedTipoAbono;
	}

	public void setSelectedTipoAbono(String selectedTipoAbono) {
		this.selectedTipoAbono = selectedTipoAbono;
	}

	public String getSelectedContraAbono() {
		return selectedContraAbono;
	}

	public void setSelectedContraAbono(String selectedContraAbono) {
		this.selectedContraAbono = selectedContraAbono;
	}

	public String getMontoAbono() {
		return montoAbono;
	}

	public void setMontoAbono(String montoAbono) {
		this.montoAbono = montoAbono;
	}
	
	public String getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}
	
	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
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

	public List<General> getListaTipoOperacion() {
		return listaTipoOperacion;
	}

	public void setListaTipoOperacion(List<General> listaTipoOperacion) {
		this.listaTipoOperacion = listaTipoOperacion;
	}

	public List<General> getListaOrdenEstado() {
		return listaOrdenEstado;
	}

	public void setListaOrdenEstado(List<General> listaOrdenEstado) {
		this.listaOrdenEstado = listaOrdenEstado;
	}

	public FondoManager getFondoManager() {
		return fondoManager;
	}

	public void setFondoManager(FondoManager fondoManager) {
		this.fondoManager = fondoManager;
	}

	public GeneralManager getGeneralManager() {
		return generalManager;
	}

	public void setGeneralManager(GeneralManager generalManager) {
		this.generalManager = generalManager;
	}

	public InfoportManager getInfoportManager() {
		return infoportManager;
	}

	public void setInfoportManager(InfoportManager infoportManager) {
		this.infoportManager = infoportManager;
	}

	public EmisorManager getEmisorManager() {
		return emisorManager;
	}

	public void setEmisorManager(EmisorManager emisorManager) {
		this.emisorManager = emisorManager;
	}

	public OrdenManager getOrdenManager() {
		return ordenManager;
	}

	public void setOrdenManager(OrdenManager ordenManager) {
		this.ordenManager = ordenManager;
	}

	public List<General> getListaOperacion() {
		return listaOperacion;
	}

	public void setListaOperacion(List<General> listaOperacion) {
		this.listaOperacion = listaOperacion;
	}

	public List<General> getListaContraparte() {
		return listaContraparte;
	}

	public void setListaContraparte(List<General> listaContraparte) {
		this.listaContraparte = listaContraparte;
	}

	public List<General> getListaMoneda() {
		return listaMoneda;
	}

	public void setListaMoneda(List<General> listaMoneda) {
		this.listaMoneda = listaMoneda;
	}

	public List<General> getListaEspecie() {
		return listaEspecie;
	}
	
	public List<General> getListaIntermediario() {
		return listaIntermediario;
	}

	public void setListaIntermediario(List<General> listaIntermediario) {
		this.listaIntermediario = listaIntermediario;
	}

	public List<General> getListaLugar() {
		return listaLugar;
	}

	public void setListaLugar(List<General> listaLugar) {
		this.listaLugar = listaLugar;
	}

	public List<General> getListaPais() {
		return listaPais;
	}

	public void setListaPais(List<General> listaPais) {
		this.listaPais = listaPais;
	}

	public Integer getSelectedIntermediario() {
		return selectedIntermediario;
	}

	public void setSelectedIntermediario(Integer selectedIntermediario) {
		this.selectedIntermediario = selectedIntermediario;
	}

	public Integer getSelectedLugar() {
		return selectedLugar;
	}

	public void setSelectedLugar(Integer selectedLugar) {
		this.selectedLugar = selectedLugar;
	}

	public Integer getSelectedPais() {
		return selectedPais;
	}

	public void setSelectedPais(Integer selectedPais) {
		this.selectedPais = selectedPais;
	}

	public void setListaEspecie(List<General> listaEspecie) {
		this.listaEspecie = listaEspecie;
	}

	public NotificacionController getNotificacionController() {
		return notificacionController;
	}

	public void setNotificacionController(NotificacionController notificacionController) {
		this.notificacionController = notificacionController;
	}

	public void cancelar() {
		selectedInfo = null;
	}
	
	public void verOrdenes(){
		listaOrdenes = ordenManager.findByFilter(Constante.NO_OPTION_SELECTED, Constante.NO_OPTION_SELECTED, this.getUsuarioSession().getUsuario().getUID().toString());
	}
	
	public void validarCancelarDeposito(){
		RequestContext context = RequestContext.getCurrentInstance();
		if (selectedInfo == null) {
            mensajeValida = "Debe seleccionar un registro.";
            context.execute("PF('msjVal').show()");
        }else{
        	if(selectedInfo.getFhFecVencimiento().compareTo(Constante.FECHA_ACTUAL)==0){
            	verDetallesDeCancelarDeposito();
            	context.execute("PF('manteCancelarDeposito').show()");
        	}else{
        		mensajeValida = "La fecha de vencimiento no es igual a la actual.";
        		context.execute("PF('msjVal').show()");
        	}
        }
	}
	
	public void verDetallesDeCancelarDeposito(){
		try {
			selectedInfo.setFhFecEfectividad(null);
			selectedInfo.setTipoApertura(Constante.TIPOAPERTURA_NORMAL);
        	if(selectedInfo.getNbIsin().trim().endsWith("C")){
        		selectedInfo.setTipoApertura(Constante.TIPOAPERTURA_COBERTURADO);
        	}
			selectedInfo.setPlazo(FechasUtil.diferenciaEnDias(selectedInfo.getFhFecVencimiento(), selectedInfo.getFhFecEmision()));
	    	Double valorDepositoMo = Utilitarios.round(selectedInfo.getImValorSinInter() * Math.pow((1 + selectedInfo.getImCupon() / 100), (selectedInfo.getPlazo().doubleValue() / 360)), 2);
	    	Double intereses = (valorDepositoMo - selectedInfo.getImValorSinInter());
	    	selectedInfo.setMontoCapital(formato.format(selectedInfo.getImValorSinInter()));
	    	selectedInfo.setMontoIntereses(formato.format(intereses));
	    	selectedInfo.setMontoTotal(formato.format(selectedInfo.getImValorSinInter() + intereses));
	    	selectedInfo.setIdOperacion(Constante.ID_OPERA_CANCELACION);
		} catch (Exception e) {
			LOG.error("Error obteniendo los calculos de cancelar deposito.", e);
		}
		
	}
	
	public void validarPreCancelarDeposito(){
		RequestContext context = RequestContext.getCurrentInstance();
		if (selectedInfo == null) {
            mensajeValida = "Debe seleccionar un registro.";
            context.execute("PF('msjVal').show()");
        }else{
        	if(selectedInfo.getFhFecVencimiento().compareTo(Constante.FECHA_ACTUAL) == 0){
        		mensajeValida = "La fecha de vencimiento es igual a la actual.";
        		context.execute("PF('msjVal').show()");
        	}else{
        		verDetallesDePreCancelarDeposito();
            	context.execute("PF('mantePreCancelarDeposito').show()");
        	}
        }
	}
	
	public void verDetallesDePreCancelarDeposito(){
		try {
			selectedInfo.setFhFecEfectividad(null);
			selectedInfo.setMontoCapital(formato.format(selectedInfo.getImValorSinInter()));
			selectedInfo.setMontoIntereses(formatoTasa.format(selectedInfo.getImCupon()));
			selectedInfo.setPlazo(FechasUtil.diferenciaEnDias(new Date(), selectedInfo.getFhFecEmision()));
			tasaPreCancelacion = formatoTasa.format(selectedInfo.getImCupon());
			calcularMontoPreCancelacion();
			selectedInfo.setIdOperacion(Constante.ID_OPERA_PRE_CANCELACION);
		} catch (Exception e) {
			LOG.error("Error obteniendo los calculos de pre cancelar deposito.", e);
		}
	}
	
	public void calcularMontoPreCancelacion(){
		tasaPreCancelacion = tasaPreCancelacion.replace(",", ".");
		if(Utilitarios.isDouble(tasaPreCancelacion)){
			montoPreCancelacion = formato.format(selectedInfo.getImValorSinInter() * Math.pow((1 + Double.parseDouble(tasaPreCancelacion) / 100), (selectedInfo.getPlazo().doubleValue() / 360)));
		}else{
			Utilitarios.mostrarMensajeAdvertencia("msgPreCancelar", "Verifique el valor en el campo Tasa. Ejm: "+selectedInfo.getMontoIntereses(), "Error en tasa");
		}
	}
	
	public void validarAperturaDeposito(){
		RequestContext context = RequestContext.getCurrentInstance();
        inicializaDatosDeApertura();
        context.execute("PF('manteAperturaDeposito').show()");
	}
	
	public void inicializaDatosDeApertura(){
		selectedInfo.setFhFecEfectividad(null);
		selectedFondoAper = Constante.NO_OPTION_SELECTED;
    	selectedContraAper = Constante.NO_OPTION_SELECTED;
    	selectedMonedaAper = Constante.NO_OPTION_SELECTED;
    	selectedTipoAper = Constante.NO_OPTION_SELECTED;
    	importeAper = "";
    	tasaAper = "";
    	plazoAper = "";
    	fechaVctoAper = null;
	}
	
	public void validarRenovarDeposito(){
		RequestContext context = RequestContext.getCurrentInstance();
		if (selectedInfo == null) {
            mensajeValida = "Debe seleccionar un registro.";
            context.execute("PF('msjVal').show()");
        }else{
        	inicializaDatosDeRenovacion();
        	context.execute("PF('manteRenuevaDeposito').show()");
        }
	}
	
	public void inicializaDatosDeRenovacion(){
		selectedInfo.setFhFecEfectividad(null);
		selectedInfo.setTipoApertura(Constante.TIPOAPERTURA_NORMAL);
    	if(selectedInfo.getNbIsin().trim().endsWith("C")){
    		selectedInfo.setTipoApertura(Constante.TIPOAPERTURA_COBERTURADO);
    	}
    	selectedInfo.setIdOperacion(Constante.ID_OPERA_RENOVACION);
		importeRenova = formato.format(selectedInfo.getImValorSinInter());
		tasaRenova = "";
		plazoRenova = "";
		fechaVctoRenova = null;
	}
	
	public void validarSpot(){
		RequestContext context = RequestContext.getCurrentInstance();
        inicializaDatosDeSpot();
        context.execute("PF('manteSpot').show()");
	}
	
	public void inicializaDatosDeSpot(){
		selectedInfo.setFhFecEfectividad(null);
		selectedTipoSpot = Constante.NO_OPTION_SELECTED;
		selectedContraSpot = Constante.NO_OPTION_SELECTED;
		tipoCambioSpot = "";
	}
	
	public void validarFwd(){
		RequestContext context = RequestContext.getCurrentInstance();
        inicializaDatosDeFwd();
        context.execute("PF('manteFwd').show()");
	}
	
	public void inicializaDatosDeFwd(){
		selectedInfo.setFhFecEfectividad(null);
		selectedTipoFwd = Constante.NO_OPTION_SELECTED;
		selectedContraFwd = Constante.NO_OPTION_SELECTED;
		selectedSettleFwd = Constante.NO_OPTION_SELECTED;
		puntosFwd = "";
		tipoCambioFwd = "";
		plazoFwd = "";
	}
	
	public void validarAbonoCargo(){
		RequestContext context = RequestContext.getCurrentInstance();
        inicializaDatosDeAbonoCargo();
        context.execute("PF('manteAbonoCargo').show()");
	}
	
	public void inicializaDatosDeAbonoCargo(){
		selectedInfo.setFhFecEfectividad(null);
		selectedFondoAbono = Constante.NO_OPTION_SELECTED;
		selectedTipoAbono = Constante.NO_OPTION_SELECTED;
		selectedContraAbono = Constante.NO_OPTION_SELECTED;
		montoAbono = "";
	}
	
	public void validarRentaFija(){
		RequestContext context = RequestContext.getCurrentInstance();
		selectedInfo.setFhFecEfectividad(null);
		context.execute("PF('manteRentaFija').show()");
	}
	
	public void validarRentaVariable(){
		RequestContext context = RequestContext.getCurrentInstance();
		selectedInfo.setFhFecEfectividad(null);
		context.execute("PF('manteRentaVariable').show()");
	}
	
	public void guardaOpCancelarDeposito(){
		RequestContext context = RequestContext.getCurrentInstance();
		try {
			Orden orden = generaOrden();
			orden.setTpApertura(selectedInfo.getTipoApertura());
			String monto = selectedInfo.getMontoCapital().replace(".", "").replace(",", ".");
			orden.setImCapital(Utilitarios.parseToDouble(monto));
			monto = selectedInfo.getMontoIntereses().replace(".", "").replace(",", ".");
			orden.setImInteres(Utilitarios.parseToDouble(monto));
			monto = selectedInfo.getMontoTotal().replace(".", "").replace(",", ".");
			orden.setImMontoFinal(Utilitarios.parseToDouble(monto));
			
			if(selectedInfo.getFhFecEfectividad().compareTo(Constante.FECHA_ACTUAL)==0){
				selectedInfo.setImValorMonLocal(Constante.VALOR_CERO);
				selectedInfo.setImValorMonRef(Constante.VALOR_CERO);
				selectedInfo.setNbObservacion(Constante.CANCELAR_OBS);
				selectedInfo.setStEstado(Constante.ESTADO_INACTIVO);
				infoportManager.save(selectedInfo);
			}
			guardaOrden(orden);
			
			context.execute("PF('manteCancelarDeposito').hide()");
			Utilitarios.mostrarMensajeInfo("growl", Constante.Mensajes.MSJ_REGISTRO_OK, null);
		} catch (Exception e) {
			Utilitarios.mostrarMensajeError("msgCancelar", Constante.Mensajes.MSJ_REGISTRO_FAIL, e.getMessage());
		}
	}
	
	public void guardaOpPreCancelarDeposito(){
		RequestContext context = RequestContext.getCurrentInstance();
		try {
			tasaPreCancelacion = tasaPreCancelacion.replace(",", ".");
			if(!Utilitarios.isDouble(tasaPreCancelacion)){
				Utilitarios.mostrarMensajeAdvertencia("msgPreCancelar", "Verifique el valor en el campo Tasa. Ejm: "+selectedInfo.getMontoIntereses(), "Error en tasa");
				return;
			}
			Orden orden = generaOrden();
			orden.setImTasaPrecancel(Utilitarios.parseToDouble(tasaPreCancelacion));
			String monto = selectedInfo.getMontoCapital().replace(".", "").replace(",", ".");
			orden.setImCapital(Utilitarios.parseToDouble(monto));
			montoPreCancelacion = montoPreCancelacion.replace(".", "").replace(",", ".");
			orden.setImMontoFinal(Utilitarios.parseToDouble(montoPreCancelacion));
			guardaOrden(orden);
			
			context.execute("PF('mantePreCancelarDeposito').hide()");
			Utilitarios.mostrarMensajeInfo("growl", Constante.Mensajes.MSJ_REGISTRO_OK, null);
		} catch (Exception e) {
			Utilitarios.mostrarMensajeError("msgPreCancelar", Constante.Mensajes.MSJ_REGISTRO_FAIL, e.getMessage());
		}
	}
	
	public void guardaOpAperturaDeposito(){
		RequestContext context = RequestContext.getCurrentInstance();
		try {
			if(validaFormularioDeApertura()){
				if(selectedTipoAper.equals(Constante.TIPOAPERTURA_NORMAL)){
					selectedInfo.setIdOperacion(Constante.ID_OPERA_APERTURA_DPF);
				}else{
					selectedInfo.setIdOperacion(Constante.ID_OPERA_APERTURA_DPF_COB);
				}
				Orden orden = generaOrden();
				orden.setTpApertura(selectedTipoAper);
				orden.setImTasa(Utilitarios.parseToDouble(tasaAper));
				orden.setNuPlazoDia(Utilitarios.parseToInteger(plazoAper));
				orden.setImMontoFinal(Utilitarios.parseToDouble(importeAper));
				orden.setFhFecVencimiento(fechaVctoAper);
				guardaOrden(orden);
				
				context.execute("PF('manteAperturaDeposito').hide()");
				Utilitarios.mostrarMensajeInfo("growl", Constante.Mensajes.MSJ_REGISTRO_OK, null);
			}
		} catch (Exception e) {
			Utilitarios.mostrarMensajeError("msgAperturar", Constante.Mensajes.MSJ_REGISTRO_FAIL, e.getMessage());
		}
	}
	
	public void calcularFechaVcto(){
		if(!Utilitarios.isInteger(plazoAper)){
			plazoAper = "";
			Utilitarios.mostrarMensajeAdvertencia("msgAperturar", "Ingrese un número en el campo Plazo.", "Error en Plazo");
			fechaVctoAper = null;
		}else{
			Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(Constante.FECHA_ACTUAL);
			cal.add(Calendar.DATE, Utilitarios.parseToInteger(plazoAper));
			fechaVctoAper = cal.getTime(); 
		}		 
	}
	
	public boolean validaFormularioDeApertura(){
		if(selectedFondoAper.equals(Constante.NO_OPTION_SELECTED)){
			Utilitarios.mostrarMensajeAdvertencia("msgAperturar", "Seleccione un valor en el campo Fondo.", "Error en Fondo");
			return false;
		}
		if(selectedContraAper.equals(Constante.NO_OPTION_SELECTED)){
			Utilitarios.mostrarMensajeAdvertencia("msgAperturar", "Seleccione un valor en el campo Contraparte.", "Error en Contraparte");
			return false;
		}
		if(selectedMonedaAper.equals(Constante.NO_OPTION_SELECTED)){
			Utilitarios.mostrarMensajeAdvertencia("msgAperturar", "Seleccione un valor en el campo Moneda.", "Error en Moneda");
			return false;
		}
		if(selectedTipoAper.equals(Constante.NO_OPTION_SELECTED)){
			Utilitarios.mostrarMensajeAdvertencia("msgAperturar", "Seleccione un valor en el campo Tipo.", "Error en Tipo");
			return false;
		}
		if(!Utilitarios.isDouble(importeAper)){
			Utilitarios.mostrarMensajeAdvertencia("msgAperturar", "Verifique el valor en el campo Importe.", "Error en Importe");
			return false;
		}
		if(!Utilitarios.isDouble(tasaAper)){
			Utilitarios.mostrarMensajeAdvertencia("msgAperturar", "Verifique el valor en el campo Tasa.", "Error en Tasa");
			return false;
		}
		if(!Utilitarios.isInteger(plazoAper)){
			Utilitarios.mostrarMensajeAdvertencia("msgAperturar", "Ingrese un número en el campo Plazo.", "Error en Plazo");
			return false;
		}
		return true;
	}
	
	public void guardaOpRenuevaDeposito(){
		RequestContext context = RequestContext.getCurrentInstance();
		try {
			if(validaFormularioDeRenovacion()){
				Orden orden = generaOrden();
				orden.setTpApertura(selectedInfo.getTipoApertura());
				orden.setImTasa(Utilitarios.parseToDouble(tasaRenova));
				orden.setNuPlazoDia(Utilitarios.parseToInteger(plazoRenova));
				orden.setImMontoFinal(Utilitarios.parseToDouble(importeRenova));
				orden.setFhFecVencimiento(fechaVctoRenova);
				guardaOrden(orden);
				
				context.execute("PF('manteRenuevaDeposito').hide()");
				Utilitarios.mostrarMensajeInfo("growl", Constante.Mensajes.MSJ_REGISTRO_OK, null);
			}
		} catch (Exception e) {
			Utilitarios.mostrarMensajeError("msgRenovar", Constante.Mensajes.MSJ_REGISTRO_FAIL, e.getMessage());
		}
	}
	
	public void guardaOpCompraVentaSpot(){
		
	}
	
	public void guardaOpCompraVentaForward(){
		
	}

	public void calcularFechaVctoRenueva(){
		if(!Utilitarios.isInteger(plazoRenova)){
			plazoRenova = "";
			Utilitarios.mostrarMensajeAdvertencia("msgRenovar", "Ingrese un número en el campo Plazo.", "Error en Plazo");
			fechaVctoRenova = null;
		}else{
			Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(Constante.FECHA_ACTUAL);
			cal.add(Calendar.DATE, Utilitarios.parseToInteger(plazoRenova));
			fechaVctoRenova = cal.getTime(); 
		}
	}
	
	public boolean validaFormularioDeRenovacion(){
		if(!Utilitarios.isDouble(importeRenova)){
			Utilitarios.mostrarMensajeAdvertencia("msgRenovar", "Verifique el valor en el campo Importe.", "Error en Importe");
			return false;
		}
		if(!Utilitarios.isDouble(tasaRenova)){
			Utilitarios.mostrarMensajeAdvertencia("msgRenovar", "Verifique el valor en el campo Tasa.", "Error en Tasa");
			return false;
		}
		if(!Utilitarios.isInteger(plazoRenova)){
			Utilitarios.mostrarMensajeAdvertencia("msgRenovar", "Ingrese un número en el campo Plazo.", "Error en Plazo");
			return false;
		}
		return true;
	}
	
	
	public Orden generaOrden(){
		Orden orden = new Orden();
		orden.setFhFecEfectividad(selectedInfo.getFhFecEfectividad());
		orden.setTpTipoOperacion(Utilitarios.buscaGeneralPorValorEnLista(listaTipoOperacion, selectedInfo.getTpOperacion()).getNbValorGeneral());
		orden.setImTasa(selectedInfo.getImCupon());
		orden.setNuPlazoDia(selectedInfo.getPlazo());
		orden.setFhFecInicio(selectedInfo.getFhFecEmision());
		orden.setFhFecVencimiento(selectedInfo.getFhFecVencimiento());
		orden.setNbMnemonico(selectedInfo.getNbMnemonico());
		orden.setFondo(Utilitarios.buscaFondoEnLista(listaFondo, selectedInfo.getNbNomFondo()));
		orden.setContraparte(Utilitarios.buscaGeneralEnLista(listaContraparte, selectedInfo.getNbNomEmisor()));
		orden.setOperacion(Utilitarios.buscaGeneralPorIDEnLista(listaOperacion, selectedInfo.getIdOperacion()));
		orden.setTipoMoneda(Utilitarios.buscaGeneralEnLista(listaMoneda, selectedInfo.getTpAbrevMoneda()));
		orden.setEspecie(Utilitarios.buscaGeneralEnLista(listaEspecie, selectedInfo.getNbEspecie()));
		orden.setIntermediario(Utilitarios.buscaGeneralPorIDEnLista(listaOperacion, selectedIntermediario));
		orden.setLugar(Utilitarios.buscaGeneralPorIDEnLista(listaOperacion, selectedLugar));
		orden.setPais(Utilitarios.buscaGeneralPorIDEnLista(listaOperacion, selectedPais));
		orden.setStEstado(Constante.OrdenEstado.GENERADO);
		orden.setFhFecCreacion(new Date());
		orden.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
		return orden;
	}
	
	public boolean guardaOrden(Orden orden){
		try {
			ordenManager.save(orden);
			OrdenEstado ordenEstado = new OrdenEstado();
			
			ordenEstado.setOrden(orden);
			ordenEstado.setFhFecCreacion(new Date());
			ordenEstado.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
			ordenEstado.setCdIdgeneral(Utilitarios.buscaGeneralPorValorEnLista(listaOrdenEstado, Constante.OrdenEstado.GENERADO));
			ordenManager.saveEstado(ordenEstado);
			
			DetalleOrden detalle = new DetalleOrden();
			Utilitarios.copiaPropiedades(detalle, selectedInfo);
			detalle.setCdIddetalle(null);
			detalle.setOrden(orden);
			
			ordenManager.saveDetalle(detalle);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
