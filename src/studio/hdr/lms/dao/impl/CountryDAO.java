package studio.hdr.lms.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.ICountryDAO;
import studio.hdr.lms.model.Country;

/**
 * A data access object (DAO) providing persistence and search support for
 * Country entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see studio.hdr.lms.model.Country
 * @author MyEclipse Persistence Tools
 */

public class CountryDAO extends BaseHibernateDAO implements ICountryDAO {
	private static final Logger log = LoggerFactory.getLogger(CountryDAO.class);
	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICountryDAO#save(studio.hdr.lms.model.Country)
	 */
	public void save(Country transientInstance) {
		log.debug("saving Country instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICountryDAO#delete(studio.hdr.lms.model.Country)
	 */
	public void delete(Country persistentInstance) {
		log.debug("deleting Country instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICountryDAO#findById(java.lang.Long)
	 */
	public Country findById(java.lang.Long id) {
		log.debug("getting Country instance with id: " + id);
		try {
			Country instance = (Country) getSession().get(
					"studio.hdr.lms.model.Country", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICountryDAO#findByExample(studio.hdr.lms.model.Country)
	 */
	public List findByExample(Country instance) {
		log.debug("finding Country instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.Country")
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
	 * @see studio.hdr.lms.dao.impl.ICountryDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Country instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Country as model where model."
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
	 * @see studio.hdr.lms.dao.impl.ICountryDAO#findByCountryName(java.lang.Object)
	 */
	public List findByCountryName(Object countryName) {
		return findByProperty(COUNTRY_NAME, countryName);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICountryDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Country instances");
		try {
			String queryString = "from Country";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICountryDAO#merge(studio.hdr.lms.model.Country)
	 */
	public Country merge(Country detachedInstance) {
		log.debug("merging Country instance");
		try {
			Country result = (Country) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICountryDAO#attachDirty(studio.hdr.lms.model.Country)
	 */
	public void attachDirty(Country instance) {
		log.debug("attaching dirty Country instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ICountryDAO#attachClean(studio.hdr.lms.model.Country)
	 */
	public void attachClean(Country instance) {
		log.debug("attaching clean Country instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}