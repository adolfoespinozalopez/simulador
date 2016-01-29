package com.pss.simulador.web.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.Emisor;
import com.pss.simulador.bs.domain.Fondo;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.domain.Infoport;
import com.pss.simulador.bs.domain.Orden;
import com.pss.simulador.bs.service.EmisorManager;
import com.pss.simulador.bs.service.FondoManager;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.bs.service.InfoportManager;
import com.pss.simulador.bs.service.OrdenManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.util.Utilitarios;
import com.pss.simulador.web.bean.Ordenes;
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
	private String selectedOperacion = Constante.NO_OPTION_SELECTED;
	
	private List<Infoport> listaPortafolio = new ArrayList<Infoport>();
	private Infoport selectedInfo;
	
	private String mensajeValida;
	private String fechaActual;
	private String valorTipoCambio;
	
	private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	private DecimalFormat formato = new DecimalFormat("###,###,###.00");
	private DecimalFormat formatoTasa = new DecimalFormat("0.00");
	
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
	List<General> listaContraparte = new ArrayList<General>();
	List<General> listaMoneda = new ArrayList<General>();
	
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
	
	private List<Ordenes> listaOrdenes = new ArrayList<Ordenes>();
	private Ordenes selectedOrden;
	
	@PostConstruct
	public void init() {
		listaPortafolio = new ArrayList<Infoport>();
		ejecutarbusqueda();
		fechaInicial = Constante.FECHA_ACTUAL;
		fechaActual = formatoFecha.format(fechaInicial);
		//Cambiar por obtenerTipoDeCambio
		valorTipoCambio = "3.40";
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(fechaInicial);
		cal.add(Calendar.DATE, 3);
		fechaFinal = cal.getTime();
		Ordenes orden1 = new Ordenes(1, "BBVA SOLES", "Renta Fija", "PEN", "LUZ DEL SUR", "Bonos corporativos", "PEP70252M226", "PEP70252M226", Constante.FECHA_ACTUAL, "1");
		Ordenes orden2 = new Ordenes(2, "BBVA SOLES", "Renta Fija", "PEN", "CINEPLEX S.A.", "Bonos corporativos", "PEP72840M010", "PEP72840M010", Constante.FECHA_ACTUAL, "1");
		listaOrdenes = new ArrayList<Ordenes>();
		listaOrdenes.add(orden1);
		listaOrdenes.add(orden2);
		
		listaEmisor = emisorManager.findAllActive();
		
		if(this.isInversionista()){
			listaFondo = fondoManager.findAll();
		}else{
			listaFondo = fondoManager.findByIdPerfil(this.getUsuarioSession().getPerfil().getCdIdperfil());
		}
		
		//Modal
		listaContraparte = generalManager.findByDomainAndState(Constante.Dominio.CONTRAPARTE, Constante.ESTADO_ACTIVO);
		listaMoneda = generalManager.findByDomainAndState(Constante.Dominio.MONEDA, Constante.ESTADO_ACTIVO);
		
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
        	setSelectedOperacion(objNew.toString());
        }
        ejecutarbusqueda();
    }
	
	public void ejecutarbusqueda(){
		listaPortafolio = infoportManager.findByFilter(selectedFondo, selectedEmisor, selectedCondicion, selectedOperacion);
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
	
	public String getSelectedOperacion() {
		return selectedOperacion;
	}

	public void setSelectedOperacion(String selectedOperacion) {
		this.selectedOperacion = selectedOperacion;
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

	public String getValorTipoCambio() {
		return valorTipoCambio;
	}

	public void setValorTipoCambio(String valorTipoCambio) {
		this.valorTipoCambio = valorTipoCambio;
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
	
	public List<Ordenes> getListaOrdenes() {
		return listaOrdenes;
	}

	public void setListaOrdenes(List<Ordenes> listaOrdenes) {
		this.listaOrdenes = listaOrdenes;
	}
	
	public Ordenes getSelectedOrden() {
		return selectedOrden;
	}

	public void setSelectedOrden(Ordenes selectedOrden) {
		this.selectedOrden = selectedOrden;
	}

	public void cancelar() {
		selectedInfo = null;
	}
	
	public void validarCancelarDeposito(){
		RequestContext context = RequestContext.getCurrentInstance();
		if (selectedInfo == null) {
            mensajeValida = "Debe seleccionar un registro.";
            context.execute("PF('msjVal').show()");
        }else{
        	selectedInfo.setTipoApertura(Constante.TIPOAPERTURA_NORMAL);
        	if(selectedInfo.getNbIsin().trim().endsWith("C")){
        		selectedInfo.setTipoApertura(Constante.TIPOAPERTURA_COBERTURADO);
        	}
        	verDetallesDeCancelarDeposito();
        	context.execute("PF('manteCancelarDeposito').show()");
        }
	}
	
	public void verDetallesDeCancelarDeposito(){
		try {
			selectedInfo.setPlazo(Utilitarios.diferenciaEnDias(selectedInfo.getFhFecVencimiento(), selectedInfo.getFhFecEmision()));
	    	Double valorDepositoMo = Utilitarios.round(selectedInfo.getImValorSinInter() * Math.pow((1 + selectedInfo.getImCupon() / 100), (selectedInfo.getPlazo().doubleValue() / 360)), 2);
	    	Double intereses = (valorDepositoMo - selectedInfo.getImValorSinInter());
	    	selectedInfo.setMontoCapital(formato.format(selectedInfo.getImValorSinInter()));
	    	selectedInfo.setMontoIntereses(formato.format(intereses));
	    	selectedInfo.setMontoTotal(formato.format(selectedInfo.getImValorSinInter() + intereses));
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
        	verDetallesDePreCancelarDeposito();
        	context.execute("PF('mantePreCancelarDeposito').show()");
        }
	}
	
	public void verDetallesDePreCancelarDeposito(){
		try {
			selectedInfo.setMontoCapital(formato.format(selectedInfo.getImValorSinInter()));
			selectedInfo.setMontoIntereses(formatoTasa.format(selectedInfo.getImCupon()));
			selectedInfo.setPlazo(Utilitarios.diferenciaEnDias(new Date(), selectedInfo.getFhFecEmision()));
			tasaPreCancelacion = formatoTasa.format(selectedInfo.getImCupon());
			calcularMontoPreCancelacion();
		} catch (Exception e) {
			LOG.error("Error obteniendo los calculos de pre cancelar deposito.", e);
		}
	}
	
	public void calcularMontoPreCancelacion(){
		tasaPreCancelacion = tasaPreCancelacion.replace(",", ".");
		if(Utilitarios.isDouble(tasaPreCancelacion)){
			montoPreCancelacion = formato.format(selectedInfo.getImValorSinInter() * Math.pow((1 + Double.parseDouble(tasaPreCancelacion) / 100), (selectedInfo.getPlazo().doubleValue() / 360)));
		}else{
			Utilitarios.mostrarMensajeAdvertencia("txtTasaPre", "Error en tasa", "Error en tasa 2");
		}
	}
	
	public void validarAperturaDeposito(){
		RequestContext context = RequestContext.getCurrentInstance();
		if (selectedInfo == null) {
            mensajeValida = "Debe seleccionar un registro.";
            context.execute("PF('msjVal').show()");
        }else{
        	inicializaDatosDeApertura();
        	context.execute("PF('manteAperturaDeposito').show()");
        }
	}
	
	public void inicializaDatosDeApertura(){
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
		selectedInfo.setTipoApertura(Constante.TIPOAPERTURA_NORMAL);
    	if(selectedInfo.getNbIsin().trim().endsWith("C")){
    		selectedInfo.setTipoApertura(Constante.TIPOAPERTURA_COBERTURADO);
    	}
		importeRenova = formato.format(selectedInfo.getImValorSinInter());
		tasaRenova = "";
		plazoRenova = "";
		fechaVctoRenova = null;
	}
	
	public void validarSpot(){
		RequestContext context = RequestContext.getCurrentInstance();
		if (selectedInfo == null) {
            mensajeValida = "Debe seleccionar un registro.";
            context.execute("PF('msjVal').show()");
        }else{
        	inicializaDatosDeSpot();
        	context.execute("PF('manteSpot').show()");
        }
	}
	
	public void inicializaDatosDeSpot(){
		selectedTipoSpot = Constante.NO_OPTION_SELECTED;
		selectedContraSpot = Constante.NO_OPTION_SELECTED;
		tipoCambioSpot = "";
	}
	
	public void validarFwd(){
		RequestContext context = RequestContext.getCurrentInstance();
		if (selectedInfo == null) {
            mensajeValida = "Debe seleccionar un registro.";
            context.execute("PF('msjVal').show()");
        }else{
        	inicializaDatosDeFwd();
        	context.execute("PF('manteFwd').show()");
        }
	}
	
	public void inicializaDatosDeFwd(){
		selectedTipoFwd = Constante.NO_OPTION_SELECTED;
		selectedContraFwd = Constante.NO_OPTION_SELECTED;
		selectedSettleFwd = Constante.NO_OPTION_SELECTED;
		puntosFwd = "";
		tipoCambioFwd = "";
		plazoFwd = "";
	}
	
	public void validarAbonoCargo(){
		RequestContext context = RequestContext.getCurrentInstance();
		if (selectedInfo == null) {
            mensajeValida = "Debe seleccionar un registro.";
            context.execute("PF('msjVal').show()");
        }else{
        	inicializaDatosDeAbonoCargo();
        	context.execute("PF('manteAbonoCargo').show()");
        }
	}
	
	public void inicializaDatosDeAbonoCargo(){
		selectedFondoAbono = Constante.NO_OPTION_SELECTED;
		selectedTipoAbono = Constante.NO_OPTION_SELECTED;
		selectedContraAbono = Constante.NO_OPTION_SELECTED;
		montoAbono = "";
	}
	
	public void validarRentaFija(){
		RequestContext context = RequestContext.getCurrentInstance();
		if (selectedInfo == null) {
            mensajeValida = "Debe seleccionar un registro.";
            context.execute("PF('msjVal').show()");
        }else{
        	context.execute("PF('manteRentaFija').show()");
        }
	}
	
	public void guardaOpCancelarDeposito(){
		try {
			Orden orden = new Orden();
			orden.setFhFecEfectividad(selectedInfo.getFhFecEfectividad());
			orden.setFondo(Utilitarios.buscaFondoEnLista(listaFondo, selectedInfo.getNbNomFondo()));
			orden.setContraparte(Utilitarios.buscaGeneralEnLista(listaContraparte, selectedInfo.getNbNomEmisor()));
			General tipoMoneda = Utilitarios.buscaGeneralEnLista(listaMoneda, selectedInfo.getTpAbrevMoneda());
			if(tipoMoneda != null){
				orden.setTpTipmoneda(tipoMoneda.getCdIdgeneral());
			}
			orden.setImTasa(selectedInfo.getImCupon());
			orden.setNuPlazoDia(selectedInfo.getPlazo());
			orden.setFhFecInicio(selectedInfo.getFhFecEmision());
			orden.setFhFecVencimiento(selectedInfo.getFhFecVencimiento());
			orden.setNbMnemonico(selectedInfo.getNbMnemonico());
			String monto = selectedInfo.getMontoCapital().replace(".", "").replace(",", ".");
			orden.setImCapital(Double.parseDouble(monto));
			monto = selectedInfo.getMontoIntereses().replace(".", "").replace(",", ".");
			orden.setImInteres(Double.parseDouble(monto));
			monto = selectedInfo.getMontoTotal().replace(".", "").replace(",", ".");
			orden.setImMontoFinal(Double.parseDouble(monto));
			
			orden.setFhFecCreacion(new Date());
			orden.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
			
			ordenManager.save(orden);
			Utilitarios.mostrarMensajeInfo(null, Constante.Mensajes.MSJ_REGISTRO_OK, null);
		} catch (Exception e) {
			Utilitarios.mostrarMensajeError(null, Constante.Mensajes.MSJ_REGISTRO_FAIL, e.getMessage());
		}
	}
	
	
}
