package com.pss.simulador.bs.dao.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.pss.simulador.bs.dao.GeneralDao;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.core.dao.HibernateDAO;

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
		LOG.info("lista = "+lista.size());
		return lista;
	}

}
