package com.pss.simulador.web.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.TipoCambio;
import com.pss.simulador.bs.service.TipoCambioManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.web.controller.generic.GenericController;

@Component
@Scope("request")
public class NotificacionController extends GenericController implements Serializable {

	private static final long serialVersionUID = 1L;
	private String mensaje;
	private SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

	private TipoCambio tipoCambioActual;
	private List<TipoCambio> listaTipoCambio = new ArrayList<TipoCambio>();
	
	@Autowired
	private TipoCambioManager tipoCambioManager;
	
	@Autowired
	private LoginController loginController;

	@PostConstruct
	public void init() {
		RequestContext context = RequestContext.getCurrentInstance();
		if (loginController.isInversionista()) {
			if (!getRequest().getRequestURI().contains(Constante.ORDENES_PAGE)) {
				Calendar cal = GregorianCalendar.getInstance();
				cal.setTime(new Date());
				if (cal.get(Calendar.HOUR_OF_DAY) == Constante.HORA_MONEY_MARKET && cal.get(Calendar.MINUTE) <= Constante.MINUTO_ALERTA) {
					mensaje = "Son " + formatoHora.format(cal.getTime()) + ", Es hora de ver Money Market!";
					context.execute("PF('notiBar').show()");
				} else if (cal.get(Calendar.HOUR_OF_DAY) == Constante.HORA_RENTA_FIJA && cal.get(Calendar.MINUTE) <= Constante.MINUTO_ALERTA) {
					mensaje = "Son " + formatoHora.format(cal.getTime()) + ", Es hora de ver Renta Fija!";
					context.execute("PF('notiBar').show()");
				} else if (cal.get(Calendar.HOUR_OF_DAY) == Constante.HORA_RENTA_VARIABLE && cal.get(Calendar.MINUTE) <= Constante.MINUTO_ALERTA) {
					mensaje = "Son " + formatoHora.format(cal.getTime()) + ", Es hora de ver Renta Variable!";
					context.execute("PF('notiBar').show()");
				}
			}
		}
		if (getRequest().getRequestURI().contains(Constante.PORTAFOLIO_PAGE)) {
			listarTipoCambio();
		}
	}

	public void listarTipoCambio(){
		listaTipoCambio = tipoCambioManager.findAllActivo();
		if(!listaTipoCambio.isEmpty()){
			setTipoCambioActual(listaTipoCambio.get(0));
		}else{
			setTipoCambioActual(new TipoCambio(Constante.VALOR_CERO));
		}
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public TipoCambio getTipoCambioActual() {
		return tipoCambioActual;
	}

	public void setTipoCambioActual(TipoCambio tipoCambioActual) {
		this.tipoCambioActual = tipoCambioActual;
	}

	public List<TipoCambio> getListaTipoCambio() {
		return listaTipoCambio;
	}

	public void setListaTipoCambio(List<TipoCambio> listaTipoCambio) {
		this.listaTipoCambio = listaTipoCambio;
	}

	public TipoCambioManager getTipoCambioManager() {
		return tipoCambioManager;
	}

	public void setTipoCambioManager(TipoCambioManager tipoCambioManager) {
		this.tipoCambioManager = tipoCambioManager;
	}
	
}
