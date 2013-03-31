package studio.hdr.lms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IBookDetailViewDAO;
import studio.hdr.lms.model.view.BookDetailView;

/**
 	* A data access object (DAO) providing persistence and search support for BookDetailView entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see studio.hdr.lms.model.view.BookDetailView
  * @author MyEclipse Persistence Tools 
 */

public class BookDetailViewDAO extends BaseHibernateDAO implements IBookDetailViewDAO  {
	     private static final Logger log = LoggerFactory.getLogger(BookDetailViewDAO.class);
	

    
    /* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookDetailViewDAO#findById(java.lang.Long)
	 */
    public BookDetailView findById( java.lang.Long id) {
        log.debug("getting BookDetailView instance with id: " + id);
        try {
            BookDetailView instance = (BookDetailView) getSession()
                    .get("studio.hdr.lms.model.view.BookDetailView", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookDetailViewDAO#findByExample(studio.hdr.lms.model.view.BookDetailView)
	 */
    public List findByExample(BookDetailView instance) {
        log.debug("finding BookDetailView instance by example");
        try {
            List results = getSession()
                    .createCriteria("studio.hdr.lms.model.view.BookDetailView")
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
	 * @see studio.hdr.lms.dao.impl.IBookDetailViewDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding BookDetailView instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BookDetailView as model where model." 
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
	 * @see studio.hdr.lms.dao.impl.IBookDetailViewDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all BookDetailView instances");
		try {
			String queryString = "from BookDetailView";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}