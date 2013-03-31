package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.Department;
import studio.hdr.lms.model.Major;

public interface IMajorDAO {

	// property constants
	public static final String MAJOR_NAME = "majorName";
	public static final String MAJOR_NUM = "majorNum";

	public abstract void save(Major transientInstance);

	public abstract void delete(Major persistentInstance);

	public abstract Major findById(java.lang.Integer id);

	public abstract List findByExample(Major instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract Major findByDepartmentAndMajorName(Department department,String majorName);

	public  List findByDepartmentId(int departmentId);
	public abstract List findByMajorNum(Object majorNum);

	public abstract List findAll();
	
}