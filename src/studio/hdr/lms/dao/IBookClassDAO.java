package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.BookClass;

public interface IBookClassDAO {

	// property constants
	public static final String CLASS_NAME = "className";

	public abstract void save(BookClass transientInstance);

	public abstract void delete(BookClass persistentInstance);

	public abstract BookClass findById(java.lang.Long id);

	public abstract List findByExample(BookClass instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByClassName(Object className);

	public abstract List findAll();

}