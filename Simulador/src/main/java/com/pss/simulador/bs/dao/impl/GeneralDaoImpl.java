package com.pss.simulador.bs.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import com.pss.simulador.bs.dao.GeneralDao;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.core.dao.HibernateDAO;
import com.pss.simulador.util.Constante;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 13/01/2016
* @since 1.0
*/
@Repository("generalDao")
public class GeneralDaoImpl extends HibernateDAO<General> implements GeneralDao {

	private static final Logger LOG = Logger.getLogger(GeneralDaoImpl.class);
	
	public List<General> findByDomainAndState(String domain, String stEstado) {
		Criteria criterioCiiu = super.getCriteria(General.class);
		criterioCiiu.add(Restrictions.eq("nbDominio", domain));
		criterioCiiu.add(Restrictions.eq("stEstado", stEstado));
		List<General> lista = criterioCiiu.list();
		return lista;
	}

	public List<General> findByDomain(String domain) {
		Criteria criterioCiiu = super.getCriteria(General.class);
		if(!domain.equals(Constante.NO_OPTION_SELECTED)){
			criterioCiiu.add(Restrictions.eq("nbDominio", domain));
		}
		List<General> lista = criterioCiiu.list();
		return lista;
	}

	public List<String> findAllDomainsActive() {
		Criteria criterioCiiu = super.getCriteria(General.class);
		criterioCiiu.add(Restrictions.eq("stEstado", Constante.ESTADO_ACTIVO));
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.distinct(Projections.property("nbDominio")));
		criterioCiiu.setProjection(projectionList);
		List<String> lista = criterioCiiu.list();
		return lista;
	}

}
