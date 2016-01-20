package com.pss.simulador.bs.dao.impl;

import org.apache.log4j.Logger;

import com.pss.simulador.bs.dao.GeneralDao;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 13/01/2016
* @since 1.0
*/
//Repository("generalDao")
public class GeneralDaoImpl implements GeneralDao {

	private static final Logger LOG = Logger.getLogger(GeneralDaoImpl.class);
	
//	public List<General> findByDomainAndState(String domain, String stEstado) {
//		CriteriaBuilder criterioCiiu = super.getCriteria(General.class);
//		criterioCiiu.add(Restrictions.eq("nbDominio", domain));
//		criterioCiiu.add(Restrictions.eq("stEstado", stEstado));
//		List<General> lista = criterioCiiu.list();
//		return lista;
//	}
//
//	public List<General> findByDomain(String domain) {
//		Criteria criterioCiiu = super.getCriteria(General.class);
//		if(!domain.equals(Constante.NO_OPTION_SELECTED)){
//			criterioCiiu.add(Restrictions.eq("nbDominio", domain));
//		}
//		List<General> lista = criterioCiiu.list();
//		return lista;
//	}
//
//	public List<String> findAllDomainsActive() {
//		Criteria criterioCiiu = super.getCriteria(General.class);
//		criterioCiiu.add(Restrictions.eq("stEstado", Constante.ESTADO_ACTIVO));
//		ProjectionList projectionList = Projections.projectionList();
//		projectionList.add(Projections.distinct(Projections.property("nbDominio")));
//		criterioCiiu.setProjection(projectionList);
//		List<String> lista = criterioCiiu.list();
//		return lista;
//	}

}
