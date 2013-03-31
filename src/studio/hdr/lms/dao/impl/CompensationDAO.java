package studio.hdr.lms.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.ICompensationDAO;
import studio.hdr.lms.model.Compensation;

/**
 * A data access object (DAO) providing persistence and search support for
 * Compensation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see studio.hdr.lms.model.Compensation
 * @author MyEclipse Persistence Tools
 */

public class CompensationDAO extends BaseHibernateDAO implements ICompensationDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompensationDAO.class);
	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICompensationDAO#save(studio.hdr.lms.model.Compensation)
	 */
	public void save(Compensation transientInstance) {
		log.debug("saving Compensation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICompensationDAO#delete(studio.hdr.lms.model.Compensation)
	 */
	public void delete(Compensation persistentInstance) {
		log.debug("deleting Compensation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICompensationDAO#findById(java.lang.Long)
	 */
	public Compensation findById(java.lang.Long id) {
		log.debug("getting Compensation instance with id: " + id);
		try {
			Compensation instance = (Compensation) getSession().get(
					"studio.hdr.lms.model.Compensation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICompensationDAO#findByExample(studio.hdr.lms.model.Compensation)
	 */
	public List findByExample(Compensation instance) {
		log.debug("finding Compensation instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.Compensation")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICompensationDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Compensation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Compensation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICompensationDAO#findByCompensationAmount(java.lang.Object)
	 */
	public List findByCompensationAmount(Object compensationAmount) {
		return findByProperty(COMPENSATION_AMOUNT, compensationAmount);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICompensationDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Compensation instances");
		try {
			String queryString = "from Compensation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}