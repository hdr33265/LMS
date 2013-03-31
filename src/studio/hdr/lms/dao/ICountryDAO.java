package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.Country;

public interface ICountryDAO {

	// property constants
	public static final String COUNTRY_NAME = "countryName";

	public abstract void save(Country transientInstance);

	public abstract void delete(Country persistentInstance);

	public abstract Country findById(java.lang.Long id);

	public abstract List findByExample(Country instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCountryName(Object countryName);

	public abstract List findAll();

	public abstract Country merge(Country detachedInstance);

	public abstract void attachDirty(Country instance);

	public abstract void attachClean(Country instance);

}