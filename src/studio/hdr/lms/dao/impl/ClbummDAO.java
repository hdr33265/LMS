package studio.hdr.lms.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IClbummDAO;
import studio.hdr.lms.model.Clbumm;

/**
 * A data access object (DAO) providing persistence and search support for
 * Clbumm entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see studio.hdr.lms.model.Clbumm
 * @author MyEclipse Persistence Tools
 */

public class ClbummDAO extends BaseHibernateDAO implements IClbummDAO {
	private static final Logger log = LoggerFactory.getLogger(ClbummDAO.class);
	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IClbummDAO#save(studio.hdr.lms.model.Clbumm)
	 */
	public void save(Clbumm transientInstance) {
		log.debug("saving Clbumm instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IClbummDAO#delete(studio.hdr.lms.model.Clbumm)
	 */
	public void delete(Clbumm persistentInstance) {
		log.debug("deleting Clbumm instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IClbummDAO#findById(java.lang.Integer)
	 */
	public Clbumm findById(java.lang.Integer id) {
		log.debug("getting Clbumm instance with id: " + id);
		try {
			Clbumm instance = (Clbumm) getSession().get(
					"studio.hdr.lms.model.Clbumm", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IClbummDAO#findByExample(studio.hdr.lms.model.Clbumm)
	 */
	public List findByExample(Clbumm instance) {
		log.debug("finding Clbumm instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.Clbumm")
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
	 * @see studio.hdr.lms.dao.impl.IClbummDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Clbumm instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Clbumm as model where model."
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
	 * @see studio.hdr.lms.dao.impl.IClbummDAO#findByClbummMajor(java.lang.Object)
	 */
	public List findByMajorId(int majorId) {
		try {
			String queryString = "from Clbumm as c where c.clbummMajor=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setInteger(0, majorId);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IClbummDAO#findByClbummNum(java.lang.Object)
	 */
	public List findByClbummNum(Object clbummNum) {
		return findByProperty(CLBUMM_NUM, clbummNum);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IClbummDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Clbumm instances");
		try {
			String queryString = "from Clbumm";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}