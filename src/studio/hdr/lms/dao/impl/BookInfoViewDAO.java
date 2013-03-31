package studio.hdr.lms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.hdr.lms.dao.IBookInfoViewDAO;
import studio.hdr.lms.model.view.BookInfoView;
import studio.hdr.lms.model.view.RecordInfoView;

/**
 	* A data access object (DAO) providing persistence and search support for BookInfoView entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see studio.hdr.lms.model.view.BookInfoView
  * @author MyEclipse Persistence Tools 
 */

public class BookInfoViewDAO extends BaseHibernateDAO implements IBookInfoViewDAO  {
	     private static final Logger log = LoggerFactory.getLogger(BookInfoViewDAO.class);
	

    
    /* (non-Javadoc)
	 * @see studio.hdr.lms.dao.impl.IBookInfoViewDAO#findByExample(studio.hdr.lms.model.view.BookInfoView)
	 */
    public List findByExample(BookInfoView instance) {
        log.debug("finding BookInfoView instance by example");
        try {
            List results = getSession()
                    .createCriteria("studio.hdr.lms.model.view.BookInfoView")
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
	 * @see studio.hdr.lms.dao.impl.IBookInfoViewDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding BookInfoView instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BookInfoView as model where model." 
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
	 * @see studio.hdr.lms.dao.impl.IBookInfoViewDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all BookInfoView instances");
		try {
			String queryString = "from BookInfoView";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List<BookInfoView> findById(List<Long> ids) {
		try {
			String queryString = "from BookInfoView as b where b.id in :list";
	         Query queryObject = getSession().createQuery(queryString).setParameterList("list", ids);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public RecordInfoView findById(Long id) {
		log.debug("getting RecordInfoView instance with id: " + id);
		try {
			RecordInfoView instance = (RecordInfoView) getSession().get(
					"studio.hdr.lms.model.view.RecordInfoView", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public BookInfoView findById(long id) {
		log.debug("getting BookInfoView instance with id: " + id);
		try {
			BookInfoView instance = (BookInfoView) getSession().get(
					"studio.hdr.lms.model.view.BookInfoView", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}