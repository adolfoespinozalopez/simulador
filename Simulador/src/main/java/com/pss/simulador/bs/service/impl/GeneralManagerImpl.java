package com.pss.simulador.bs.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.pss.simulador.bs.dao.GeneralDao;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.service.GeneralManager;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 13/01/2016
* @since 1.0
*/
@Service("generalManager")
public class GeneralManagerImpl implements GeneralManager {

	private static final Logger LOG = Logger.getLogger(GeneralManagerImpl.class);
	
	@Resource(name = "generalDao")
	private GeneralDao generalDao;
	
	public List<General> findByDomainAndState(String domain, String stEstado) {
		return generalDao.findByDomainAndState(domain, stEstado);
	}

}
