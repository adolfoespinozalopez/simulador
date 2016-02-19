package com.pss.simulador.bs.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.domain.DetalleOrden;
import com.pss.simulador.bs.domain.Orden;
import com.pss.simulador.bs.domain.OrdenEstado;
import com.pss.simulador.bs.repository.data.OrdenDetalleRepository;
import com.pss.simulador.bs.repository.data.OrdenEstadoRepository;
import com.pss.simulador.bs.repository.data.OrdenRepository;
import com.pss.simulador.bs.service.OrdenManager;
import com.pss.simulador.util.Constante;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 28/01/2016
* @since 1.0
*/
@Service
@Transactional(readOnly=true)
public class OrdenManagerImpl implements OrdenManager{

	@Autowired
	OrdenRepository ordenRepository;
	
	@Autowired
	OrdenEstadoRepository ordenEstadoRepository;
	
	@Autowired
	OrdenDetalleRepository ordenDetalleRepository;
	
	public List<Orden> findByFilter(String idOperacion, String strEstado, String strUserName) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(Constante.FECHA_ACTUAL);
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)-1);
		if(idOperacion.equals(Constante.NO_OPTION_SELECTED)){
			idOperacion = null;
		}
		if(strEstado.equals(Constante.NO_OPTION_SELECTED)){
			strEstado = null;
		}
		return ordenRepository.findByFilter(calendar.getTime(), idOperacion, strEstado, strUserName);
	}

	@Transactional
	public Orden save(Orden orden) {
		return ordenRepository.save(orden);
	}

	@Transactional
	public OrdenEstado saveEstado(OrdenEstado ordenEstado) {
		return ordenEstadoRepository.save(ordenEstado);
	}

	@Transactional
	public DetalleOrden saveDetalle(DetalleOrden detalleOrden) {
		return ordenDetalleRepository.save(detalleOrden);
	}
	
	public List<OrdenEstado> findEstadoByOrden(Integer idOrden) {
		return ordenEstadoRepository.findEstadoByOrden(idOrden);
	}

	public List<DetalleOrden> findDetalleByOrden(Integer idOrden) {
		return ordenDetalleRepository.findDetalleByOrden(idOrden);
	}

	
}
