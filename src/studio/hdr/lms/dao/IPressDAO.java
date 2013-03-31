package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.Press;

public interface IPressDAO {

	// property constants
	public static final String PRESS_NAME = "pressName";
	public static final String PRESS_ADDR = "pressAddr";

	public abstract void save(Press transientInstance);

	public abstract void delete(Press persistentInstance);

	public abstract Press findById(java.lang.Long id);

	public abstract List findByExample(Press instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPressName(Object pressName);

	public abstract List findByPressAddr(Object pressAddr);

	public abstract List findAll();

}