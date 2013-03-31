package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.Sex;

public interface ISexDAO {

	// property constants
	public static final String SEX_NAME = "sexName";

	public abstract Sex findById(java.lang.Integer id);

	public abstract Sex findBySexName(String sexName);

	public abstract List findAll();

}