package studio.hdr.lms.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.ISexDAO;
import studio.hdr.lms.model.Sex;

/**
 * A data access object (DAO) providing persistence and search support for Sex
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see studio.hdr.lms.model.Sex
 * @author MyEclipse Persistence Tools
 */

public class SexDAO extends BaseHibernateDAO implements ISexDAO {
	private static final Logger log = LoggerFactory.getLogger(SexDAO.class);
	/**(non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISexDAO#save(studio.hdr.lms.model.Sex)
	 */
	public void save(Sex transientInstance) {
		log.debug("saving Sex instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISexDAO#delete(studio.hdr.lms.model.Sex)
	 */
	public void delete(Sex persistentInstance) {
		log.debug("deleting Sex instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISexDAO#findById(java.lang.Integer)
	 */
	public Sex findById(java.lang.Integer id) {
		log.debug("getting Sex instance with sex name: " + id);
		try {
			Sex instance = (Sex) getSession().get("studio.hdr.lms.model.Sex",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISexDAO#findBySexName(java.lang.Object)
	 */
	public Sex findBySexName(String sexName) {
	
		try {
			Query query=super.getSession().createQuery("from Sex as sex where sex.sexName=?");
			query.setString(0, sexName);

			return (Sex) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISexDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Sex instances");
		try {
			String queryString = "from Sex";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}