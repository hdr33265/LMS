package studio.hdr.lms.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IStateDAO;
import studio.hdr.lms.model.State;

/**
 * A data access object (DAO) providing persistence and search support for State
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see studio.hdr.lms.model.State
 * @author MyEclipse Persistence Tools
 */

public class StateDAO extends BaseHibernateDAO implements IStateDAO {
	private static final Logger log = LoggerFactory.getLogger(StateDAO.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see studio.hdr.lms.dao.impl.IStateDAO#save(studio.hdr.lms.model.State)
	 */
	public void save(State transientInstance) {
		log.debug("saving State instance");
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
	 * @see studio.hdr.lms.dao.impl.IStateDAO#delete(studio.hdr.lms.model.State)
	 */
	public void delete(State persistentInstance) {
		log.debug("deleting State instance");
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
	 * @see studio.hdr.lms.dao.impl.IStateDAO#findById(java.lang.Integer)
	 */
	public State findById(java.lang.Integer id) {
		log.debug("getting State instance with id: " + id);
		try {
			State instance = (State) getSession().get(
					"studio.hdr.lms.model.State", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studio.hdr.lms.dao.impl.IStateDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all State instances");
		try {
			String queryString = "from State";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public State findByStateName(String stateName) {
		try {
			String queryString = "from State s where s.stateName=?";
			Query queryObject = getSession().createQuery(queryString)
					.setString(0, stateName);
			return (State) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}