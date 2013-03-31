package studio.hdr.lms.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.ISuperAdminDAO;
import studio.hdr.lms.model.SuperAdmin;

/**
 * A data access object (DAO) providing persistence and search support for
 * SuperAdmin entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see studio.hdr.lms.model.SuperAdmin
 * @author MyEclipse Persistence Tools
 */

public class SuperAdminDAO extends BaseHibernateDAO implements ISuperAdminDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SuperAdminDAO.class);
	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISuperAdminDAO#save(studio.hdr.lms.model.SuperAdmin)
	 */
	public void save(SuperAdmin transientInstance) {
		log.debug("saving SuperAdmin instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISuperAdminDAO#delete(studio.hdr.lms.model.SuperAdmin)
	 */
	public void delete(SuperAdmin persistentInstance) {
		log.debug("deleting SuperAdmin instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISuperAdminDAO#findById(java.lang.Long)
	 */
	public SuperAdmin findById(java.lang.Long id) {
		log.debug("getting SuperAdmin instance with id: " + id);
		try {
			SuperAdmin instance = (SuperAdmin) getSession().get(
					"studio.hdr.lms.model.SuperAdmin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISuperAdminDAO#findByExample(studio.hdr.lms.model.SuperAdmin)
	 */
	public List findByExample(SuperAdmin instance) {
		log.debug("finding SuperAdmin instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.SuperAdmin")
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
	 * @see studio.hdr.lms.dao.impl.ISuperAdminDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SuperAdmin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SuperAdmin as model where model."
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
	 * @see studio.hdr.lms.dao.impl.ISuperAdminDAO#findBySuperAdminName(java.lang.Object)
	 */
	public List findBySuperAdminName(Object superAdminName) {
		return findByProperty(SUPER_ADMIN_NAME, superAdminName);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISuperAdminDAO#findBySuperAdminPassword(java.lang.Object)
	 */
	public List findBySuperAdminPassword(Object superAdminPassword) {
		return findByProperty(SUPER_ADMIN_PASSWORD, superAdminPassword);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISuperAdminDAO#findBySuperAdminQuestion(java.lang.Object)
	 */
	public List findBySuperAdminQuestion(Object superAdminQuestion) {
		return findByProperty(SUPER_ADMIN_QUESTION, superAdminQuestion);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISuperAdminDAO#findBySuperAdminAnswer(java.lang.Object)
	 */
	public List findBySuperAdminAnswer(Object superAdminAnswer) {
		return findByProperty(SUPER_ADMIN_ANSWER, superAdminAnswer);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.ISuperAdminDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all SuperAdmin instances");
		try {
			String queryString = "from SuperAdmin";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}