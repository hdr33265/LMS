package studio.hdr.lms.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IOrderDAO;
import studio.hdr.lms.model.Order;

/**
 * A data access object (DAO) providing persistence and search support for Order
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see studio.hdr.lms.model.Order
 * @author MyEclipse Persistence Tools
 */

public class OrderDAO extends BaseHibernateDAO implements IOrderDAO {
	private static final Logger log = LoggerFactory.getLogger(OrderDAO.class);

	// property constants

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IOrderDAO#save(studio.hdr.lms.model.Order)
	 */
	public void save(Order transientInstance) {
		log.debug("saving Order instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IOrderDAO#delete(studio.hdr.lms.model.Order)
	 */
	public void delete(Order persistentInstance) {
		log.debug("deleting Order instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IOrderDAO#findById(java.lang.Long)
	 */
	public Order findById(java.lang.Long id) {
		log.debug("getting Order instance with id: " + id);
		try {
			Order instance = (Order) getSession().get(
					"studio.hdr.lms.model.Order", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IOrderDAO#findByExample(studio.hdr.lms.model.Order)
	 */
	public List findByExample(Order instance) {
		log.debug("finding Order instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.Order")
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
	 * @see studio.hdr.lms.dao.impl.IOrderDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Order instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Order as model where model."
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
	 * @see studio.hdr.lms.dao.impl.IOrderDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Order instances");
		try {
			String queryString = "from Order";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List<Order> findById(List<Long> ids) {
		try {
			String queryString = "from Order as o where o.orderId in :ids";
			Query queryObject = getSession().createQuery(queryString).setParameterList("ids", ids);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public void delete(List<Long> ids) {
		try {
			String queryString = "delete from Order as o where o.orderId in :ids";
			Query queryObject = getSession().createQuery(queryString).setParameterList("ids", ids);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		
	}


}