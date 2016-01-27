/**
 * 
 */
package com.pss.simulador.bs.service;

import java.util.List;

import org.primefaces.model.DualListModel;

import com.pss.simulador.bs.domain.Fondo;
import com.pss.simulador.bs.domain.Perfil;
import com.pss.simulador.bs.domain.PerfilFondo;
import com.pss.simulador.web.bean.UsuarioSession;

/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
public interface PerfilManager {
	public List<Perfil> findPerfilByName(String strNombre, String stEstado);
	public Perfil savePerfilAndDetail(Perfil perfil, DualListModel<Fondo> lstFondos,UsuarioSession usuarioSession);
	public Perfil savePerfil(Perfil perfil);
	public List<PerfilFondo> findPerfilFondoByIdPerfil(Integer cdIdperfil);
}
