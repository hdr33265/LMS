package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.Record;

public interface IRecordDAO {

	public abstract void save(Record transientInstance);

	public abstract void delete(Record persistentInstance);

	public abstract Record findById(java.lang.Long id);

	public abstract List findByExample(Record instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

}