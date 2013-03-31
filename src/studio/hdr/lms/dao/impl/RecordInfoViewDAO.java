package studio.hdr.lms.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IRecordInfoViewDAO;
import studio.hdr.lms.model.view.RecordInfoView;

/**
 * A data access object (DAO) providing persistence and search support for
 * RecordInfoView entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see studio.hdr.lms.model.view.RecordInfoView
 * @author MyEclipse Persistence Tools
 */

public class RecordInfoViewDAO extends BaseHibernateDAO implements IRecordInfoViewDAO{
	private static final Logger log = LoggerFactory
			.getLogger(RecordInfoViewDAO.class);

	public void save(RecordInfoView transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(RecordInfoView persistentInstance) {
		log.debug("deleting RecordInfoView instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RecordInfoView findById(java.lang.Long id) {
		log.debug("getting RecordInfoView instance with id: " + id);
		try {
			RecordInfoView instance = (RecordInfoView) getSession().get(
					"studio.hdr.lms.model.view.RecordInfoView", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RecordInfoView instance) {
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.view.RecordInfoView")
					.add(Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RecordInfoView instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RecordInfoView as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all RecordInfoView instances");
		try {
			String queryString = "from RecordInfoView";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<RecordInfoView> findByUserId(long userId) {
		try {
			String queryString = "from RecordInfoView as r where r.userId=?";
			Query queryObject = getSession().createQuery(queryString).setLong(0, userId);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}