package studio.hdr.lms.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IOrderInfoViewDAO;
import studio.hdr.lms.model.view.OrderInfoView;
import studio.hdr.lms.model.view.RecordInfoView;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderInfoView entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see studio.hdr.lms.model.view.OrderInfoView
 * @author MyEclipse Persistence Tools
 */

public class OrderInfoViewDAO extends BaseHibernateDAO implements IOrderInfoViewDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrderInfoViewDAO.class);

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IOrderInfoViewDAO#findById(java.lang.Long)
	 */
	public OrderInfoView findById(java.lang.Long id) {
		log.debug("getting OrderInfoView instance with id: " + id);
		try {
			OrderInfoView instance = (OrderInfoView) getSession().get(
					"studio.hdr.lms.model.view.OrderInfoView", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IOrderInfoViewDAO#findByExample(studio.hdr.lms.model.view.OrderInfoView)
	 */
	public List findByExample(OrderInfoView instance) {
		log.debug("finding OrderInfoView instance by example");
		try {
			List results = getSession()
					.createCriteria("studio.hdr.lms.model.view.OrderInfoView")
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
	 * @see studio.hdr.lms.dao.impl.IOrderInfoViewDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding OrderInfoView instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from OrderInfoView as model where model."
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
	 * @see studio.hdr.lms.dao.impl.IOrderInfoViewDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all OrderInfoView instances");
		try {
			String queryString = "from OrderInfoView";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List<OrderInfoView> findByUserId(long userId) {
		try {
			String queryString = "from OrderInfoView as o where o.userId=?";
			Query queryObject = getSession().createQuery(queryString).setLong(0, userId);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}