package com.pss.simulador.web.controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.DetalleOrden;
import com.pss.simulador.bs.domain.Fondo;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.domain.Infoport;
import com.pss.simulador.bs.domain.Orden;
import com.pss.simulador.bs.domain.OrdenEstado;
import com.pss.simulador.bs.domain.OrdenFondo;
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

	@Autowired
	private PortafolioController portafolioController;
	
	private String mensajeValida;
	
	private DecimalFormat formato = new DecimalFormat("###,###,###.00");
	private DecimalFormat formatoTasa = new DecimalFormat("0.00");
	private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
	
	public OrdenController(){
		
	}
	
	@PostConstruct
	public void init() {
		otherSymbols.setGroupingSeparator((char) 44);
		otherSymbols.setDecimalSeparator((char) 46);
		formatoTasa=new DecimalFormat("0.00", otherSymbols);
		formato = new DecimalFormat("###,###,###.00", otherSymbols);
		
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
		//listaOrdenes = ordenManager.findByFilter(selectedTipoOperacion, selectedEstado, null);
		listaOrdenes = ordenManager.findByFilter(selectedTipoOperacion, selectedEstado, this.getUsuarioSession().getUsuario().getUID().toString());
		selectedOrdenes = new ArrayList<Orden>();
	}
	
	public void editarOrden(Orden orden, boolean bActualiza){
		if(orden != null){
			RequestContext context = RequestContext.getCurrentInstance();
			Infoport selectedInfo = new Infoport();
			portafolioController.setFechaEfectividad(orden.getFhFecEfectividad());
			//Detalle
			for (DetalleOrden detalle : ordenManager.findDetalleByOrden(orden.getCdIdorden())) {
				Utilitarios.copiaPropiedades(selectedInfo, detalle);
			}
			selectedInfo.setFhFecEfectividad(orden.getFhFecEfectividad());
			if(orden.getContraparte()!=null){
				selectedInfo.setNbNomEmisor(orden.getContraparte().getNbDescGeneral());
			}
			if(orden.getTipoMoneda() != null){
				selectedInfo.setTpAbrevMoneda(orden.getTipoMoneda().getNbDescGeneral());
			}
			selectedInfo.setTipoApertura(orden.getTpApertura());
			selectedInfo.setImCupon(orden.getImTasa());
			selectedInfo.setPlazo(orden.getNuPlazoDia());
			selectedInfo.setFhFecEmision(orden.getFhFecInicio());
			selectedInfo.setFhFecVencimiento(orden.getFhFecVencimiento());
			selectedInfo.setIdOperacion(orden.getOperacion().getCdIdgeneral());
			
			setearDatosDeFondo(selectedInfo, orden);
			switch (orden.getOperacion().getCdIdgeneral()) {
			case Constante.ID_OPERA_CANCELACION:
				selectedInfo.setMontoCapital(formato.format(orden.getImCapital()));
				selectedInfo.setMontoIntereses(formatoTasa.format(orden.getImInteres()));
				selectedInfo.setMontoTotal(formato.format(orden.getImMontoFinal()));
				context.execute("PF('manteCancelarDeposito').show()");
				break;
			case Constante.ID_OPERA_PRE_CANCELACION:
				selectedInfo.setMontoCapital(formato.format(orden.getImCapital()));
				selectedInfo.setMontoIntereses(formatoTasa.format(orden.getImTasa()));
				selectedInfo.setMontoTotal(formato.format(orden.getImMontoFinal()));
				portafolioController.setTasaPreCancelacion(formatoTasa.format(orden.getImTasaPrecancel()));
				selectedInfo.setImValorSinInter(orden.getImCapital());
				portafolioController.setMontoPreCancelacion(selectedInfo.getMontoTotal());
				context.execute("PF('mantePreCancelarDeposito').show()");
				break;
			case Constante.ID_OPERA_APERTURA_DPF:
				setearDatosDeOrdenTipoApertura(selectedInfo, orden);
				context.execute("PF('manteAperturaDeposito').show()");
				break;
			case Constante.ID_OPERA_APERTURA_DPF_COB:
				setearDatosDeOrdenTipoApertura(selectedInfo, orden);
				context.execute("PF('manteAperturaDeposito').show()");
				break;
			case Constante.ID_OPERA_RENOVACION:
				portafolioController.setImporteRenova(formato.format(orden.getImMontoFinal()));
				portafolioController.setTasaRenova(formatoTasa.format(orden.getImTasa()));
				portafolioController.setPlazoRenova(selectedInfo.getPlazo().toString());
				portafolioController.setFechaVctoRenova(orden.getFhFecVencimiento());
				context.execute("PF('manteRenuevaDeposito').show()");
				break;
			case Constante.ID_OPERA_COMPRA_SPOT:
				setearDatosDeOrdenTipoSpot(orden);
				context.execute("PF('manteSpot').show()");
				break;
			case Constante.ID_OPERA_VENTA_SPOT:
				setearDatosDeOrdenTipoSpot(orden);
				context.execute("PF('manteSpot').show()");
				break;
			case Constante.ID_OPERA_COMPRA_FWD:
				setearDatosDeOrdenTipoForward(orden);
				context.execute("PF('manteFwd').show()");
				break;
			case Constante.ID_OPERA_VENTA_FWD:
				setearDatosDeOrdenTipoForward(orden);
				context.execute("PF('manteFwd').show()");
				break;
			case Constante.ID_OPERA_ABONO_CTA_AHORRO:
				setearDatosDeOrdenTipoAbonoRetiro(selectedInfo, orden);
				context.execute("PF('manteAbonoCargo').show()");
				break;
			case Constante.ID_OPERA_RETIRO_CTA_AHORRO:
				setearDatosDeOrdenTipoAbonoRetiro(selectedInfo, orden);
				context.execute("PF('manteAbonoCargo').show()");
				break;
			case Constante.ID_OPERA_COMPRA_FIJA:
				setearDatosDeOrdenTipoFija(orden);
				context.execute("PF('manteRentaFija').show()");
				break;
			case Constante.ID_OPERA_VENTA_FIJA:
				setearDatosDeOrdenTipoFija(orden);
				context.execute("PF('manteRentaFija').show()");
				break;
			case Constante.ID_OPERA_COMPRA_VARIABLE:
				setearDatosDeOrdenTipoVariable(orden);
				context.execute("PF('manteRentaVariable').show()");
				break;
			case Constante.ID_OPERA_VENTA_VARIABLE:
				setearDatosDeOrdenTipoVariable(orden);
				context.execute("PF('manteRentaVariable').show()");
				break;
			default:
				break;
			}
			portafolioController.setSelectedLugar(Constante.NO_OPTION_SELECTED);
			portafolioController.setSelectedPais(Constante.NO_OPTION_SELECTED);
			portafolioController.setSelectedIntermediario(Constante.NO_OPTION_SELECTED);
			portafolioController.setObservacion("");
			//Datos Adicionales
			if(orden.getLugar() != null){
				portafolioController.setSelectedLugar(orden.getLugar().getCdIdgeneral().toString());
			}
			if(orden.getPais() != null){
				portafolioController.setSelectedPais(orden.getPais().getCdIdgeneral().toString());
			}
			if(orden.getIntermediario() != null){
				portafolioController.setSelectedIntermediario(orden.getIntermediario().getCdIdgeneral().toString());
			}
			portafolioController.setObservacion("");
			
			portafolioController.setOrdenAnterior(orden);
			portafolioController.setSelectedInfo(selectedInfo);
			if(bActualiza){
				portafolioController.getOrdenAnterior().setStEstado(Constante.OrdenEstado.APROBADO);
			}
		}
	}
	
	public void setearDatosDeOrdenTipoApertura(Infoport selectedInfo, Orden orden){
		portafolioController.setSelectedFondoAper(selectedInfo.getNbNomFondo());
		portafolioController.setSelectedContraAper(orden.getContraparte().getNbDescGeneral());
		portafolioController.setSelectedMonedaAper(orden.getTipoMoneda().getNbDescGeneral());
		portafolioController.setSelectedTipoAper(orden.getTpApertura());
		portafolioController.setImporteAper(formato.format(orden.getImMontoFinal()));
		portafolioController.setTasaAper(formatoTasa.format(orden.getImTasa()));
		portafolioController.setPlazoAper(selectedInfo.getPlazo().toString());
		portafolioController.setFechaVctoAper(orden.getFhFecVencimiento());
	}
	
	public void setearDatosDeOrdenTipoSpot(Orden orden){
		portafolioController.setSelectedTipoSpot(orden.getTpMonedaOperacion());
		portafolioController.setSelectedContraSpot(orden.getContraparte().getNbDescGeneral());
		portafolioController.setTipoCambioSpot(orden.getImTipocambiospot().toString());
		portafolioController.setMontoTotal(orden.getImMontoFinal().toString());
	}
	
	public void setearDatosDeOrdenTipoForward(Orden orden){
		portafolioController.setSelectedTipoFwd(orden.getTpMonedaOperacion());
		portafolioController.setSelectedContraFwd(orden.getContraparte().getNbDescGeneral());
		portafolioController.setSelectedSettleFwd(orden.getTpForward());
		portafolioController.setTipoCambioSpot(orden.getImTipocambiospot().toString());
		portafolioController.setPuntosFwd(orden.getNuPuntofwd().toString());
		portafolioController.setTipoCambioFwd(orden.getImTipocambiofwd().toString());
		portafolioController.setPlazoFwd(orden.getNuPlazoDia().toString());
		portafolioController.setFechaVctoFwd(orden.getFhFecVencimiento());
		portafolioController.setMontoTotal(orden.getImMontoFinal().toString());
	}
	
	public void setearDatosDeOrdenTipoAbonoRetiro(Infoport selectedInfo, Orden orden){
		portafolioController.setSelectedFondoAbono(selectedInfo.getNbNomFondo());
		portafolioController.setSelectedTipoAbono(orden.getTpOperaCuenta());
		portafolioController.setSelectedContraAbono(orden.getContraparte().getNbDescGeneral());
		portafolioController.setMontoAbono(formato.format(orden.getImMontoFinal()));
	}
	
	public void setearDatosDeOrdenTipoFija(Orden orden){
		portafolioController.setSelectedTipo(orden.getTpMonedaOperacion());
		portafolioController.setSelectedEspecie(orden.getEspecie().getNbValorGeneral());
		if(orden.getEmisor() !=null){
			portafolioController.setSelectedEmisorModal(orden.getEmisor().getNbNomEmisor());
		}
		portafolioController.setMonto(orden.getImMontoFinal().toString());
		portafolioController.setMnemonico(orden.getNbMnemonico());
		if(orden.getImPrecioLimpio() != null){
			portafolioController.setPrecioLimpio(orden.getImPrecioLimpio().toString());
		}
		portafolioController.setPrecioSucio(orden.getImPrecioSucio().toString());
		portafolioController.setMontoTotal(orden.getImMontoFinal().toString());
	}
	
	public void setearDatosDeOrdenTipoVariable(Orden orden){
		portafolioController.setSelectedTipo(orden.getTpMonedaOperacion());
		portafolioController.setSelectedEspecie(orden.getEspecie().getNbValorGeneral());
		if(orden.getEmisor() !=null){
			portafolioController.setSelectedEmisorModal(orden.getEmisor().getNbNomEmisor());
		}
		portafolioController.setMonto(orden.getImMontoFinal().toString());
		portafolioController.setMnemonico(orden.getNbMnemonico());
		portafolioController.setPrecioReferencial(orden.getImPrecioReferencia().toString());
	}

	public void setearDatosDeFondo(Infoport selectedInfo, Orden orden){
		orden.getOrdenFondoList().isEmpty();
		if(orden.getOrdenFondoList().size()==1){
			selectedInfo.setNbNomFondo(orden.getOrdenFondoList().get(0).getFondo().getNbNomFondo());
		}else{
			Double montoTo = Constante.VALOR_CERO;
			Double porcentaje = Constante.VALOR_CERO;
			List<Fondo> listaFondoSelected = new ArrayList<Fondo>();
			Fondo fondoAnterior = null;
			for (OrdenFondo ordenFondo : orden.getOrdenFondoList()) {
				fondoAnterior = new Fondo();
				if(ordenFondo.getImMontoFinal() != null){
					montoTo += ordenFondo.getImMontoFinal();
					fondoAnterior.setMonto(ordenFondo.getImMontoFinal().toString());
					fondoAnterior.setMontoNuevo(fondoAnterior.getMonto());
				}
				if(ordenFondo.getPcParticipa() != null){
					porcentaje += ordenFondo.getPcParticipa();
					fondoAnterior.setPorcentaje(ordenFondo.getPcParticipa().toString()+"%");
					fondoAnterior.setPorcentajeNuevo(fondoAnterior.getPorcentaje());
				}
				fondoAnterior.setNbNomFondo(ordenFondo.getFondo().getNbNomFondo());
				listaFondoSelected.add(fondoAnterior);
			}
			portafolioController.setListaFondoSelected(listaFondoSelected);
			portafolioController.setMontoTotal(montoTo.toString());
			portafolioController.setPorcentajeTotal(porcentaje.toString());
			portafolioController.setMontoTotalNuevo(portafolioController.getMontoTotal());
			portafolioController.setPorcentajeTotalNuevo(portafolioController.getPorcentajeTotal());
			for (int i = listaFondoSelected.size(); i < 10; i++) {
				listaFondoSelected.add(new Fondo());
			}
		}
	}
	
	public void validarAprobarOrden(Orden orden){
		RequestContext context = RequestContext.getCurrentInstance();
		selectedOrden = orden;
		if(selectedOrden != null){
			if(formatoFecha.format(selectedOrden.getFhFecEfectividad()).equals(formatoFecha.format(Constante.FECHA_ACTUAL))){
				context.execute("PF('msjConfirmacionAprueba').show()");
			}else{
				mensajeValida = "No se puede aprobar la orden. Verifique la fecha de efectividad.";
				context.execute("PF('msjVal').show()");
			}
		}
	}
	
	public void aprobarOrden(){
		if(selectedOrden != null){
			if(selectedOrden.getOperacion().getCdIdgeneral().equals(Constante.ID_OPERA_CANCELACION)){
				actualizarEstado(Constante.OrdenEstado.APROBADO);
			}else{
				editarOrden(selectedOrden, true);
			}
		}
	}

	public void rechazarOrden(){
		if(selectedOrden != null){
			actualizarEstado(Constante.OrdenEstado.RECHAZADO);
		}
	}

	public void actualizarEstado(String stEstado){
		try {
			OrdenEstado ordenEstado = new OrdenEstado();
			ordenEstado.setOrden(selectedOrden);
			ordenEstado.setFhFecCreacion(new Date());
			ordenEstado.setCdUsuCreacion(this.getUsuarioSession().getUsuario().getUID());
			ordenEstado.setCdIdgeneral(Utilitarios.buscaGeneralPorValorEnLista(listaOrdenEstado, stEstado));
			selectedOrden.setStEstado(stEstado);
			ordenManager.save(selectedOrden);
			ordenManager.saveEstado(ordenEstado);
		} catch (Exception e) {
			
		}
	}
	
	public void enviarOrdenes(){
		if(!selectedOrdenes.isEmpty()){
			
		}
	}
	
	public void verDetallesDeEstado(Orden orden){
		if(orden != null){
			listaEstadoDeOrden = ordenManager.findEstadoByOrden(orden.getCdIdorden());
			selectedOrdenEstado = null;
		}
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

	public PortafolioController getPortafolioController() {
		return portafolioController;
	}

	public void setPortafolioController(PortafolioController portafolioController) {
		this.portafolioController = portafolioController;
	}

	public String getMensajeValida() {
		return mensajeValida;
	}

	public void setMensajeValida(String mensajeValida) {
		this.mensajeValida = mensajeValida;
	}
	
}
