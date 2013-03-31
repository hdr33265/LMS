package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.Order;

public interface IOrderDAO {

	public abstract void save(Order transientInstance);

	public abstract void delete(Order persistentInstance);
	public abstract void delete(List<Long> ids);

	public abstract Order findById(java.lang.Long id);

	public abstract List<Order> findById(List<Long> ids);
	
	public abstract List findByExample(Order instance);

	public abstract List findByProperty(String propertyName, Object value);
	
	
	
	public abstract List findAll();

}