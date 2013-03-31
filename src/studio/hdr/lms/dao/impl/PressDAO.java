package studio.hdr.lms.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IPressDAO;
import studio.hdr.lms.model.Press;

/**
 * A data access object (DAO) providing persistence and search support for Press
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see studio.hdr.lms.model.Press
 * @author MyEclipse Persistence Tools
 */

public class PressDAO extends BaseHibernateDAO implements IPressDAO {
	private static final Logger log = LoggerFactory.getLogger(PressDAO.class);
	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IPressDAO#save(studio.hdr.lms.model.Press)
	 */
	public void save(Press transientInstance) {
		log.debug("saving Press instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IPressDAO#delete(studio.hdr.lms.model.Press)
	 */
	public void delete(Press persistentInstance) {
		log.debug("deleting Press instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IPressDAO#findById(java.lang.Long)
	 */
	public Press findById(java.lang.Long id) {
		log.debug("getting Press instance with id: " + id);
		try {
			Press instance = (Press) getSession().get(
					"studio.hdr.lms.model.Press", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IPressDAO#findByExample(studio.hdr.lms.model.Press)
	 */
	public List findByExample(Press instance) {
		log.debug("finding Press instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.Press")
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
	 * @see studio.hdr.lms.dao.impl.IPressDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Press instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Press as model where model."
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
	 * @see studio.hdr.lms.dao.impl.IPressDAO#findByPressName(java.lang.Object)
	 */
	public List findByPressName(Object pressName) {
		return findByProperty(PRESS_NAME, pressName);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IPressDAO#findByPressAddr(java.lang.Object)
	 */
	public List findByPressAddr(Object pressAddr) {
		return findByProperty(PRESS_ADDR, pressAddr);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IPressDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Press instances");
		try {
			String queryString = "from Press";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}