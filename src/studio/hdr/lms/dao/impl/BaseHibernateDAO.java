package studio.hdr.lms.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studio.hdr.lms.dao.IBaseHibernateDAO;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
@Component
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public SessionFactory getSesstionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}