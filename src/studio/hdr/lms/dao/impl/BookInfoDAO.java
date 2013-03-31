package studio.hdr.lms.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IBookInfoDAO;
import studio.hdr.lms.model.BookInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * BookInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see studio.hdr.lms.model.BookInfo
 * @author MyEclipse Persistence Tools
 */

public class BookInfoDAO extends BaseHibernateDAO implements IBookInfoDAO{
	private static final Logger log = LoggerFactory
			.getLogger(BookInfoDAO.class);
	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookInfoDAO#save(studio.hdr.lms.model.BookInfo)
	 */
	public void save(BookInfo transientInstance) {
		log.debug("saving BookInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookInfoDAO#delete(studio.hdr.lms.model.BookInfo)
	 */
	public void delete(BookInfo persistentInstance) {
		log.debug("deleting BookInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookInfoDAO#findById(java.lang.Long)
	 */
	public BookInfo findById(java.lang.Long id) {
		log.debug("getting BookInfo instance with id: " + id);
		try {
			BookInfo instance = (BookInfo) getSession().get(
					"studio.hdr.lms.model.BookInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookInfoDAO#findByExample(studio.hdr.lms.model.BookInfo)
	 */
	public List findByExample(BookInfo instance) {
		log.debug("finding BookInfo instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.BookInfo")
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
	 * @see studio.hdr.lms.dao.impl.IBookInfoDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BookInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BookInfo as model where model."
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
	 * @see studio.hdr.lms.dao.impl.IBookInfoDAO#findByBookInfoName(java.lang.Object)
	 */
	public List findByBookInfoName(Object bookInfoName) {
		return findByProperty(BOOK_INFO_NAME, bookInfoName);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookInfoDAO#findByBookInfoDescription(java.lang.Object)
	 */
	public List findByBookInfoDescription(Object bookInfoDescription) {
		return findByProperty(BOOK_INFO_DESCRIPTION, bookInfoDescription);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookInfoDAO#findByBookInfoPrice(java.lang.Object)
	 */
	public List findByBookInfoPrice(Object bookInfoPrice) {
		return findByProperty(BOOK_INFO_PRICE, bookInfoPrice);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookInfoDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all BookInfo instances");
		try {
			String queryString = "from BookInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookInfoDAO#merge(studio.hdr.lms.model.BookInfo)
	 */
	public BookInfo merge(BookInfo detachedInstance) {
		log.debug("merging BookInfo instance");
		try {
			BookInfo result = (BookInfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookInfoDAO#attachDirty(studio.hdr.lms.model.BookInfo)
	 */
	public void attachDirty(BookInfo instance) {
		log.debug("attaching dirty BookInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookInfoDAO#attachClean(studio.hdr.lms.model.BookInfo)
	 */
	public void attachClean(BookInfo instance) {
		log.debug("attaching clean BookInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}