package studio.hdr.lms.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IBookDAO;
import studio.hdr.lms.model.Book;

/**
 * A data access object (DAO) providing persistence and search support for Book
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see studio.hdr.lms.model.Book
 * @author MyEclipse Persistence Tools
 */

public class BookDAO extends BaseHibernateDAO implements IBookDAO {
	private static final Logger log = LoggerFactory.getLogger(BookDAO.class);
	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookDAO#save(studio.hdr.lms.model.Book)
	 */
	public void save(Book transientInstance) {
		log.debug("saving Book instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookDAO#delete(studio.hdr.lms.model.Book)
	 */
	public void delete(Book persistentInstance) {
		log.debug("deleting Book instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookDAO#findById(java.lang.Long)
	 */
	public Book findById(java.lang.Long id) {
		log.debug("getting Book instance with id: " + id);
		try {
			Book instance = (Book) getSession().get(
					"studio.hdr.lms.model.Book", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookDAO#findByExample(studio.hdr.lms.model.Book)
	 */
	public List findByExample(Book instance) {
		log.debug("finding Book instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.Book")
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
	 * @see studio.hdr.lms.dao.impl.IBookDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Book instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Book as model where model."
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
	 * @see studio.hdr.lms.dao.impl.IBookDAO#findByBookBorrowCount(java.lang.Object)
	 */
	public List findByBookBorrowCount(Object bookBorrowCount) {
		return findByProperty(BOOK_BORROW_COUNT, bookBorrowCount);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Book instances");
		try {
			String queryString = "from Book";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public void update(Book transientInstance) {
		try {
			getSession().update(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
		
	}
}