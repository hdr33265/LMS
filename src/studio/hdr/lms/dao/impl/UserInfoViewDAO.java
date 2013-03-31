package studio.hdr.lms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IUserInfoViewDAO;
import studio.hdr.lms.model.view.UserInfoView;

/**
 	* A data access object (DAO) providing persistence and search support for UserInfoView entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see studio.hdr.lms.model.view.UserInfoView
  * @author MyEclipse Persistence Tools 
 */

public class UserInfoViewDAO extends BaseHibernateDAO implements IUserInfoViewDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserInfoViewDAO.class);
	

    
    /* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IUserInfoViewDAO#findById(java.lang.Long)
	 */
    public UserInfoView findById( java.lang.Long id) {
        log.debug("getting UserInfoView instance with id: " + id);
        try {
            UserInfoView instance = (UserInfoView) getSession()
                    .get("studio.hdr.lms.model.view.UserInfoView", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IUserInfoViewDAO#findByExample(studio.hdr.lms.model.view.UserInfoView)
	 */
    public List findByExample(UserInfoView instance) {
        log.debug("finding UserInfoView instance by example");
        try {
            List results = getSession()
                    .createCriteria("studio.hdr.lms.model.view.UserInfoView")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    /* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IUserInfoViewDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding UserInfoView instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserInfoView as model where model." 
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
	 * @see studio.hdr.lms.dao.impl.IUserInfoViewDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all UserInfoView instances");
		try {
			String queryString = "from UserInfoView";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}