package studio.hdr.lms.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.ISimpleBookDetailViewDAO;
import studio.hdr.lms.model.view.SimpleBookDetailView;

/**
 * A data access object (DAO) providing persistence and search support for
 * SimpleBookDetailView entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see studio.hdr.lms.model.view.SimpleBookDetailView
 * @author MyEclipse Persistence Tools
 */

public class SimpleBookDetailViewDAO extends BaseHibernateDAO implements ISimpleBookDetailViewDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SimpleBookDetailViewDAO.class);

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISimpleBookDetailViewDAO#findById(java.lang.Long)
	 */
	public SimpleBookDetailView findById(java.lang.Long id) {
		log.debug("getting SimpleBookDetailView instance with id: " + id);
		try {
			SimpleBookDetailView instance = (SimpleBookDetailView) getSession()
					.get("studio.hdr.lms.model.view.SimpleBookDetailView", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISimpleBookDetailViewDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all SimpleBookDetailView instances");
		try {
			String queryString = "from SimpleBookDetailView";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findByBookInfoId(Long bookInfo){
		try {
			String queryString = "from SimpleBookDetailView as s where s.bookInfo=?";
			Query queryObject = getSession().createQuery(queryString).setLong(0, bookInfo);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
}