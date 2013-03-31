package studio.hdr.lms.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IMajorDAO;
import studio.hdr.lms.model.Department;
import studio.hdr.lms.model.Major;

/**
 * A data access object (DAO) providing persistence and search support for Major
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see studio.hdr.lms.model.Major
 * @author MyEclipse Persistence Tools
 */

public class MajorDAO extends BaseHibernateDAO implements IMajorDAO {
	private static final Logger log = LoggerFactory.getLogger(MajorDAO.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see studio.hdr.lms.dao.impl.IMajorDAO#save(studio.hdr.lms.model.Major)
	 */
	public void save(Major transientInstance) {
		log.debug("saving Major instance");
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
	 * @see studio.hdr.lms.dao.impl.IMajorDAO#delete(studio.hdr.lms.model.Major)
	 */
	public void delete(Major persistentInstance) {
		log.debug("deleting Major instance");
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
	 * @see studio.hdr.lms.dao.impl.IMajorDAO#findById(java.lang.Integer)
	 */
	public Major findById(java.lang.Integer id) {
		log.debug("getting Major instance with id: " + id);
		try {
			Major instance = (Major) getSession().get(
					"studio.hdr.lms.model.Major", id);
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
	 * studio.hdr.lms.dao.impl.IMajorDAO#findByExample(studio.hdr.lms.model.
	 * Major)
	 */
	public List findByExample(Major instance) {
		log.debug("finding Major instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.Major")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studio.hdr.lms.dao.impl.IMajorDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Major instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Major as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studio.hdr.lms.dao.impl.IMajorDAO#findByMajorName(java.lang.Object)
	 */
	public Major findByDepartmentAndMajorName(Department department,
			String majorName)

	{
		try {
			Query query = super.getSession().createQuery(
					"from Major m where m.department=? and m.majorName=?");
			query.setEntity(0, department);
			query.setString(1, majorName);
			return (Major) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studio.hdr.lms.dao.impl.IMajorDAO#findByMajorNum(java.lang.Object)
	 */
	public List findByMajorNum(Object majorNum) {
		return findByProperty(MAJOR_NUM, majorNum);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studio.hdr.lms.dao.impl.IMajorDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Major instances");
		try {
			String queryString = "from Major";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findByDepartmentId(int departmentId) {
		try {
			String queryString = "from Major as m where m.department.departmentId=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setInteger(0, departmentId);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}