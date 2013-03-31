package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.Lang;

public interface ILangDAO {

	// property constants
	public static final String LANG_NAME = "langName";

	public abstract void save(Lang transientInstance);

	public abstract void delete(Lang persistentInstance);

	public abstract Lang findById(java.lang.Long id);

	public abstract List findByExample(Lang instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByLangName(Object langName);

	public abstract List findAll();

}