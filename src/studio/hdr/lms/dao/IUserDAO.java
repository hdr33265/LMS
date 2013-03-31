package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.User;

public interface IUserDAO {

	// property constants
	public static final String USER_NAME = "userName";
	public static final String USER_PASSWORD = "userPassword";
	public static final String USER_MAIL = "userMail";
	public static final String USER_MOBILPHONE = "userMobilphone";
	public static final String USER_GRADE = "userGrade";
	public static final String USER_NUM = "userNum";
	public static final String USER_COUNT = "userCount";
	public static final String USER_QUESTION = "userQuestion";
	public static final String USER_ANSWER = "userAnswer";

	public abstract void save(User transientInstance);

	public abstract void delete(User persistentInstance);

	public abstract User findById(java.lang.Long id);

	public abstract Long getUserIdByUserName(String userName);

	public abstract List findByExample(User instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserName(Object userName);

	public abstract List findByUserPassword(Object userPassword);

	public abstract List findByUserMail(Object userMail);

	public abstract List findByUserGrade(Object userGrade);

	public boolean isUserExistsByUserName(String userName);
	
	public abstract List findAll();

	public boolean update(User instance);
	
	public String getPasswordByUserName(String userName);

}