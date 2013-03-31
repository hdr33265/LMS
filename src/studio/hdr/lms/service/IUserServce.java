package studio.hdr.lms.service;

import java.util.List;

import studio.hdr.lms.dto.ClbummDTO;
import studio.hdr.lms.dto.MajorDTO;
import studio.hdr.lms.dto.UserDTO;
import studio.hdr.lms.dto.UserInfoDTO;
import studio.hdr.lms.model.Department;
import studio.hdr.lms.model.User;

public interface IUserServce {
	public List<User> getUserList();
	public String getPasswordByName(String username);
	public List<Department> getDepartments();
	public List<MajorDTO> getMajorsByDepartmentId(int departmentId);
	public List<ClbummDTO> getClbummsByMajorId(int majorId);
	public User transform(UserDTO userDto);
	public boolean saveUser(User user);
	public boolean changePasswordByUserId(String password,long userId);
	
	public boolean isUserExistsByUsername(String username);
	
	public long getUserIdByUserName(String userName);
	public UserInfoDTO getUserInfoByUserId(long userId);
	
}
