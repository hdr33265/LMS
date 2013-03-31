package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.Admin;

public interface IAdminDAO {

	// property constants
	public static final String ADMIN_NAME = "adminName";
	public static final String ADMIN_PASSWORD = "adminPassword";
	public static final String ADMIN_CELLPHONE = "adminCellphone";
	public static final String ADMIN_MAIL = "adminMail";
	public static final String ADMIN_NUM = "adminNum";

	public boolean isUserExistsByAdminName(String adminName);

	public abstract void save(Admin transientInstance);

	public abstract void delete(Admin persistentInstance);

	public abstract Admin findById(java.lang.Long id);

	public abstract List findByExample(Admin instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByAdminName(Object adminName);

	public abstract List findByAdminNum(Object adminNum);

	public abstract List findAll();

	public String getPasswordByAdminName(String adminName);
	public abstract Long getAdminIdByAdminName(String adminName);

}