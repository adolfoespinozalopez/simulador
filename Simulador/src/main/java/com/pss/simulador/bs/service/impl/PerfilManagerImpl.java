/**
 * 
 */
package com.pss.simulador.bs.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.fabric.xmlrpc.base.Array;
import com.pss.simulador.bs.domain.Fondo;
import com.pss.simulador.bs.domain.Perfil;
import com.pss.simulador.bs.domain.PerfilFondo;
import com.pss.simulador.bs.domain.PerfilFondoPK;
import com.pss.simulador.bs.repository.data.PerfilFondoRepository;
import com.pss.simulador.bs.repository.data.PerfilRepository;
import com.pss.simulador.bs.service.PerfilManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.web.bean.UsuarioSession;

/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
@Service
@Transactional(readOnly = true)
public class PerfilManagerImpl implements PerfilManager {

	@Autowired
	PerfilRepository perfilRepository;
	
	@Autowired
	PerfilFondoRepository perfilFondoRepository;

	public List<Perfil> findPerfilByName(String strNombre, String stEstado) {
		return perfilRepository.findPerfilByName(strNombre, stEstado);
	}
	
	public List<PerfilFondo> findPerfilFondoByIdPerfil(Integer cdIdperfil) {
		return perfilFondoRepository.findPerfilFondoByIdPerfil(cdIdperfil, Constante.ESTADO_TODOS);
	}
	

	@Transactional
	public Perfil savePerfilAndDetail(Perfil perfil, DualListModel<Fondo> lstFondos,UsuarioSession usuarioSession) {
		perfil = perfilRepository.save(perfil);
		List<PerfilFondo> lstPerfilFondo = new ArrayList<PerfilFondo>();
		if (perfil.getCdIdperfil()!=null){
			lstPerfilFondo = this.findPerfilFondoByIdPerfil(perfil.getCdIdperfil());	
		}
		
		// Inactivos de Datos Existentes
		for (PerfilFondo perfilFondoIter : lstPerfilFondo) {
			for (Fondo fondoIter : lstFondos.getSource()) {
				if (fondoIter.getCdIdfondo().equals(perfilFondoIter.getPerfilFondoPK().getCdIdfondo())){
					perfilFondoIter.setStEstado(Constante.ESTADO_INACTIVO);
					perfilFondoIter.setFhFecElimina(new Date());
					perfilFondoIter.setCdUsuElimina(usuarioSession.getUsuario().getUID());
				}
			}
		}
		perfilFondoRepository.save(lstPerfilFondo);
		
		// Nuevos
		for (Fondo fondoIter : lstFondos.getTarget()) {
			PerfilFondo perfilFondo = new PerfilFondo();
			perfilFondo.setPerfilFondoPK(new PerfilFondoPK(perfil.getCdIdperfil(),fondoIter.getCdIdfondo()));
			perfilFondo.setStEstado(Constante.ESTADO_ACTIVO);
			perfilFondo.setFhFecCreacion(new Date());
			perfilFondo.setCdUsuCreacion(usuarioSession.getUsuario().getUID());
			perfilFondoRepository.save(perfilFondo);	
		}
		
		return perfil;
	}
	public Perfil savePerfil(Perfil perfil) {
		return perfilRepository.save(perfil);
	}


}
