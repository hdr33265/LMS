package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.Compensation;

public interface ICompensationDAO {

	// property constants
	public static final String COMPENSATION_AMOUNT = "compensationAmount";

	public abstract void save(Compensation transientInstance);

	public abstract void delete(Compensation persistentInstance);

	public abstract Compensation findById(java.lang.Long id);

	public abstract List findByExample(Compensation instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCompensationAmount(Object compensationAmount);

	public abstract List findAll();

}