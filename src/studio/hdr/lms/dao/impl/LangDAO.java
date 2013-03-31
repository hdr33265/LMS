package studio.hdr.lms.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.ILangDAO;
import studio.hdr.lms.model.Lang;

/**
 * A data access object (DAO) providing persistence and search support for Lang
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see studio.hdr.lms.model.Lang
 * @author MyEclipse Persistence Tools
 */

public class LangDAO extends BaseHibernateDAO implements ILangDAO {
	private static final Logger log = LoggerFactory.getLogger(LangDAO.class);
	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ILangDAO#save(studio.hdr.lms.model.Lang)
	 */
	public void save(Lang transientInstance) {
		log.debug("saving Lang instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ILangDAO#delete(studio.hdr.lms.model.Lang)
	 */
	public void delete(Lang persistentInstance) {
		log.debug("deleting Lang instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ILangDAO#findById(java.lang.Long)
	 */
	public Lang findById(java.lang.Long id) {
		log.debug("getting Lang instance with id: " + id);
		try {
			Lang instance = (Lang) getSession().get(
					"studio.hdr.lms.model.Lang", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ILangDAO#findByExample(studio.hdr.lms.model.Lang)
	 */
	public List findByExample(Lang instance) {
		log.debug("finding Lang instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.Lang")
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
	 * @see studio.hdr.lms.dao.impl.ILangDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Lang instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Lang as model where model."
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
	 * @see studio.hdr.lms.dao.impl.ILangDAO#findByLangName(java.lang.Object)
	 */
	public List findByLangName(Object langName) {
		return findByProperty(LANG_NAME, langName);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ILangDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Lang instances");
		try {
			String queryString = "from Lang";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}