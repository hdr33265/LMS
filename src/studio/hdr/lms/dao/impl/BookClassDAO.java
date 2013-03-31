package studio.hdr.lms.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IBookClassDAO;
import studio.hdr.lms.model.BookClass;

/**
 * A data access object (DAO) providing persistence and search support for
 * BookClass entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see studio.hdr.lms.model.BookClass
 * @author MyEclipse Persistence Tools
 */

public class BookClassDAO extends BaseHibernateDAO implements IBookClassDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BookClassDAO.class);
	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookClassDAO#save(studio.hdr.lms.model.BookClass)
	 */
	public void save(BookClass transientInstance) {
		log.debug("saving BookClass instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookClassDAO#delete(studio.hdr.lms.model.BookClass)
	 */
	public void delete(BookClass persistentInstance) {
		log.debug("deleting BookClass instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookClassDAO#findById(java.lang.Long)
	 */
	public BookClass findById(java.lang.Long id) {
		log.debug("getting BookClass instance with id: " + id);
		try {
			BookClass instance = (BookClass) getSession().get(
					"studio.hdr.lms.model.BookClass", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookClassDAO#findByExample(studio.hdr.lms.model.BookClass)
	 */
	public List findByExample(BookClass instance) {
		log.debug("finding BookClass instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.BookClass")
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
	 * @see studio.hdr.lms.dao.impl.IBookClassDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BookClass instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BookClass as model where model."
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
	 * @see studio.hdr.lms.dao.impl.IBookClassDAO#findByClassName(java.lang.Object)
	 */
	public List findByClassName(Object className) {
		return findByProperty(CLASS_NAME, className);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookClassDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all BookClass instances");
		try {
			String queryString = "from BookClass";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}