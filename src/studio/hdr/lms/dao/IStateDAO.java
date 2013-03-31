package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.State;

public interface IStateDAO {

	// property constants
	public static final String STATE_NAME = "stateName";

	public abstract void save(State transientInstance);

	public abstract void delete(State persistentInstance);

	public abstract State findById(java.lang.Integer id);

	public abstract State findByStateName(String stateName);

	public abstract List findAll();

}