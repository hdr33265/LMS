package studio.hdr.lms.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IAdminDAO;
import studio.hdr.lms.model.Admin;

/**
 * A data access object (DAO) providing persistence and search support for Admin
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see studio.hdr.lms.model.Admin
 * @author MyEclipse Persistence Tools
 */

public class AdminDAO extends BaseHibernateDAO implements IAdminDAO {
	private static final Logger log = LoggerFactory.getLogger(AdminDAO.class);
	/** (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IAdminDAO#save(studio.hdr.lms.model.Admin)
	 */
	public void save(Admin transientInstance) {
		log.debug("saving Admin instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/** (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IAdminDAO#delete(studio.hdr.lms.model.Admin)
	 */
	public void delete(Admin persistentInstance) {
		log.debug("deleting Admin instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IAdminDAO#findById(java.lang.Long)
	 */
	public Admin findById(java.lang.Long id) {
		log.debug("getting Admin instance with id: " + id);
		try {
			Admin instance = (Admin) getSession().get(
					"studio.hdr.lms.model.Admin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IAdminDAO#findByExample(studio.hdr.lms.model.Admin)
	 */
	public List findByExample(Admin instance) {
		log.debug("finding Admin instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.Admin")
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
	 * @see studio.hdr.lms.dao.impl.IAdminDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Admin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Admin as model where model."
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
	 * @see studio.hdr.lms.dao.impl.IAdminDAO#findByAdminName(java.lang.Object)
	 */
	public List findByAdminName(Object adminName) {
		return findByProperty(ADMIN_NAME, adminName);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IAdminDAO#findByAdminNum(java.lang.Object)
	 */
	public List findByAdminNum(Object adminNum) {
		return findByProperty(ADMIN_NUM, adminNum);
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IAdminDAO#findAll()
	 */
	public List findAll() {
		try {
			String queryString = "from Admin";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public boolean isUserExistsByAdminName(String adminName) {
		try {
			String queryString = "select count(*) from Admin as a where a.adminName=?";
			Query queryObject = getSession().createQuery(queryString).setString(0, adminName);
			Long count=(Long) queryObject.uniqueResult();
			return count>0;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public String getPasswordByAdminName(String adminName) {
		try {
			String queryString = "select a.adminPassword from Admin as a where a.adminName=?";
			Query queryObject = getSession().createQuery(queryString).setString(0, adminName);
			
			return (String) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public Long getAdminIdByAdminName(String adminName) {
		try {
			String queryString = "select a.adminId from Admin as a where a.adminName=?";
			Query queryObject = getSession().createQuery(queryString).setString(0, adminName);
			
			return (Long) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}