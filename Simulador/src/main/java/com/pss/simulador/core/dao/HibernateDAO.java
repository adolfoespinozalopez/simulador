package com.pss.simulador.core.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.pss.simulador.core.dao.impl.IHibernateDAO;
/**
*
* @author Pierre Obregon
* @version 1.0, 16/01/2016
* @since 1.0
*/
public class HibernateDAO<T> extends HibernateDaoSupport implements IHibernateDAO<T> {
	@Autowired
	public void setSessionFactoryHibernate(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public void saveOrUpdateAll(List<T> list) {
		super.getHibernateTemplate().saveOrUpdateAll(list);
		super.getHibernateTemplate().flush();
	}
	
	public void saveOrUpdate(T t) {
		super.getHibernateTemplate().saveOrUpdate(t);
		super.getHibernateTemplate().flush();
	}

	public void save(T t) {
		super.getHibernateTemplate().save(t);
		super.getHibernateTemplate().flush();
	}

	public void update(T t) {
		super.getHibernateTemplate().update(t);
		super.getHibernateTemplate().flush();
	}

	public void delete(T t) {
		super.getHibernateTemplate().delete(t);
		super.getHibernateTemplate().flush();
	}

	public Criteria getCriteria(Class<?> clazz) {
		return super.getSession().createCriteria(clazz);
	}

	public Criteria getCriteria(Class<?> clazz, String alias) {
		return super.getSession().createCriteria(clazz, alias);
	}
}
