package studio.hdr.lms.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import studio.hdr.lms.dao.IAuthorDAO;
import studio.hdr.lms.model.Author;

/**
 * A data access object (DAO) providing persistence and search support for
 * Author entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see studio.hdr.lms.model.Author
 * @author MyEclipse Persistence Tools
 */

public class AuthorDAO extends BaseHibernateDAO implements IAuthorDAO {
	private static final Logger log = LoggerFactory.getLogger(AuthorDAO.class);
	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IAuthorDAO#save(studio.hdr.lms.model.Author)
	 */
	public void save(Author transientInstance) {
		log.debug("saving Author instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IAuthorDAO#delete(studio.hdr.lms.model.Author)
	 */
	public void delete(Author persistentInstance) {
		log.debug("deleting Author instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IAuthorDAO#findById(java.lang.Long)
	 */
	public Author findById(java.lang.Long id) {
		log.debug("getting Author instance with id: " + id);
		try {
			Author instance = (Author) getSession().get(
					"studio.hdr.lms.model.Author", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IAuthorDAO#findByExample(studio.hdr.lms.model.Author)
	 */
	public List findByExample(Author instance) {
		log.debug("finding Author instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.Author")
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
	 * @see studio.hdr.lms.dao.impl.IAuthorDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Author instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Author as model where model."
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
	 * @see studio.hdr.lms.dao.impl.IAuthorDAO#findByAuthorName(java.lang.Object)
	 */
	public List findByAuthorName(Object authorName) {
		return findByProperty(AUTHOR_NAME, authorName);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IAuthorDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Author instances");
		try {
			String queryString = "from Author";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	
}