package studio.hdr.lms.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IRecordDAO;
import studio.hdr.lms.model.Record;

/**
 * A data access object (DAO) providing persistence and search support for
 * Record entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see studio.hdr.lms.model.Record
 * @author MyEclipse Persistence Tools
 */

public class RecordDAO extends BaseHibernateDAO implements IRecordDAO {
	private static final Logger log = LoggerFactory.getLogger(RecordDAO.class);

	// property constants

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IRecordDAO#save(studio.hdr.lms.model.Record)
	 */
	public void save(Record transientInstance) {
		log.debug("saving Record instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IRecordDAO#delete(studio.hdr.lms.model.Record)
	 */
	public void delete(Record persistentInstance) {
		log.debug("deleting Record instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IRecordDAO#findById(java.lang.Long)
	 */
	public Record findById(java.lang.Long id) {
		log.debug("getting Record instance with id: " + id);
		try {
			Record instance = (Record) getSession().get(
					"studio.hdr.lms.model.Record", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IRecordDAO#findByExample(studio.hdr.lms.model.Record)
	 */
	public List findByExample(Record instance) {
		log.debug("finding Record instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.Record")
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
	 * @see studio.hdr.lms.dao.impl.IRecordDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Record instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Record as model where model."
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
	 * @see studio.hdr.lms.dao.impl.IRecordDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Record instances");
		try {
			String queryString = "from Record";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}