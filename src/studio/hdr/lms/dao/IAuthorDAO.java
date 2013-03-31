package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.Author;

public interface IAuthorDAO {

	// property constants
	public static final String AUTHOR_NAME = "authorName";

	public abstract void save(Author transientInstance);

	public abstract void delete(Author persistentInstance);

	public abstract Author findById(java.lang.Long id);

	public abstract List findByExample(Author instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByAuthorName(Object authorName);

	public abstract List findAll();

}