package studio.hdr.lms.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IUserDAO;
import studio.hdr.lms.model.User;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see studio.hdr.lms.model.User
 * @author MyEclipse Persistence Tools
 */

public class UserDAO extends BaseHibernateDAO implements IUserDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see studio.hdr.lms.dao.impl.IUserDAO#save(studio.hdr.lms.model.User)
	 */
	public void save(User transientInstance) {
		log.debug("saving User instance");
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
	 * @see studio.hdr.lms.dao.impl.IUserDAO#delete(studio.hdr.lms.model.User)
	 */
	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
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
	 * @see studio.hdr.lms.dao.impl.IUserDAO#findById(java.lang.Long)
	 */
	public User findById(java.lang.Long id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getSession().get(
					"studio.hdr.lms.model.User", id);
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
	 * studio.hdr.lms.dao.impl.IUserDAO#findByExample(studio.hdr.lms.model.User)
	 */
	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.User")
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
	 * @see studio.hdr.lms.dao.impl.IUserDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
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
	 * @see studio.hdr.lms.dao.impl.IUserDAO#findByUserName(java.lang.Object)
	 */
	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * studio.hdr.lms.dao.impl.IUserDAO#findByUserPassword(java.lang.Object)
	 */
	public List findByUserPassword(Object userPassword) {
		return findByProperty(USER_PASSWORD, userPassword);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studio.hdr.lms.dao.impl.IUserDAO#findByUserMail(java.lang.Object)
	 */
	public List findByUserMail(Object userMail) {
		return findByProperty(USER_MAIL, userMail);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * studio.hdr.lms.dao.impl.IUserDAO#findByUserMobilphone(java.lang.Object)
	 */
	public List findByUserMobilphone(Object userMobilphone) {
		return findByProperty(USER_MOBILPHONE, userMobilphone);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studio.hdr.lms.dao.impl.IUserDAO#findByUserGrade(java.lang.Object)
	 */
	public List findByUserGrade(Object userGrade) {
		return findByProperty(USER_GRADE, userGrade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studio.hdr.lms.dao.impl.IUserDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Long getUserIdByUserName(String userName) {

		log.debug("get user id by user'name ,name is" + userName);
		try {
			Query query = getSession()
					.createQuery(
							"select user.userId from User as user where user.userName=?");
			query.setString(0, userName);
			log.debug("get successful");
			return (Long) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}

	}

	public boolean update(User instance) {
		log.debug("attaching dirty User instance");
		try {

			getSession().update(instance);
			log.debug("attach successful");
			return true;
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public String getPasswordByUserName(String userName) {

		try {
			Query query = super
					.getSession()
					.createQuery(
							"select user.userPassword from User as user where user.userName=?");
			query.setString(0, userName);
			return (String) query.uniqueResult();
		} catch (RuntimeException re) {
			throw re;
		}
	}



	public boolean isUserExistsByUserName(String userName) {
		try {
			String queryString = "select count(*) from User as a where a.userName=?";
			Query queryObject = getSession().createQuery(queryString).setString(0, userName);
			Long count=(Long) queryObject.uniqueResult();
			return count>0;
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw re;
		}
	}

}