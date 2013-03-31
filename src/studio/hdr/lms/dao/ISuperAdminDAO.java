package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.SuperAdmin;

public interface ISuperAdminDAO {

	// property constants
	public static final String SUPER_ADMIN_NAME = "superAdminName";
	public static final String SUPER_ADMIN_PASSWORD = "superAdminPassword";
	public static final String SUPER_ADMIN_QUESTION = "superAdminQuestion";
	public static final String SUPER_ADMIN_ANSWER = "superAdminAnswer";

	public abstract void save(SuperAdmin transientInstance);

	public abstract void delete(SuperAdmin persistentInstance);

	public abstract SuperAdmin findById(java.lang.Long id);

	public abstract List findByExample(SuperAdmin instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findBySuperAdminName(Object superAdminName);

	public abstract List findBySuperAdminPassword(Object superAdminPassword);

	public abstract List findBySuperAdminQuestion(Object superAdminQuestion);

	public abstract List findBySuperAdminAnswer(Object superAdminAnswer);

	public abstract List findAll();

}