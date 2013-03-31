package studio.hdr.lms.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IDepartmentDAO;
import studio.hdr.lms.model.Department;

/**
 * A data access object (DAO) providing persistence and search support for
 * Department entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see studio.hdr.lms.model.Department
 * @author MyEclipse Persistence Tools
 */

public class DepartmentDAO extends BaseHibernateDAO implements IDepartmentDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DepartmentDAO.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * studio.hdr.lms.dao.impl.IDepartmentDAO#save(studio.hdr.lms.model.Department
	 * )
	 */
	public void save(Department transientInstance) {
		log.debug("saving Department instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * studio.hdr.lms.dao.impl.IDepartmentDAO#delete(studio.hdr.lms.model.Department
	 * )
	 */
	public void delete(Department persistentInstance) {
		log.debug("deleting Department instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studio.hdr.lms.dao.impl.IDepartmentDAO#findById(java.lang.Integer)
	 */
	public Department findById(java.lang.Integer id) {
		log.debug("getting Department instance with id: " + id);
		try {
			Department instance = (Department) getSession().get(
					"studio.hdr.lms.model.Department", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * studio.hdr.lms.dao.impl.IDepartmentDAO#findByDepartmentName(java.lang
	 * .Object)
	 */
	public Department findByDepartmentName(String departmentName) {

		try {
			Query query = super.getSession().createQuery(
					"from Department d where d.departmentName=?");
			query.setString(0, departmentName);

			return (Department) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studio.hdr.lms.dao.impl.IDepartmentDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Department instances");
		try {
			String queryString = "from Department";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}