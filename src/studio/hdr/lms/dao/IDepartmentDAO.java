package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.Department;

public interface IDepartmentDAO {

	// property constants
	public static final String DEPARTMENT_NAME = "departmentName";

	public abstract void save(Department transientInstance);

	public abstract void delete(Department persistentInstance);

	public abstract Department findById(java.lang.Integer id);

	public abstract Department findByDepartmentName(String departmentName);

	public abstract List findAll();

}