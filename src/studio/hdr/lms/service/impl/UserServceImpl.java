package studio.hdr.lms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studio.hdr.lms.dao.IDepartmentDAO;
import studio.hdr.lms.dao.IMajorDAO;
import studio.hdr.lms.dao.IUserInfoViewDAO;
import studio.hdr.lms.dao.impl.ClbummDAO;
import studio.hdr.lms.dao.impl.DepartmentDAO;
import studio.hdr.lms.dao.impl.SexDAO;
import studio.hdr.lms.dao.impl.UserDAO;
import studio.hdr.lms.dto.ClbummDTO;
import studio.hdr.lms.dto.MajorDTO;
import studio.hdr.lms.dto.UserDTO;
import studio.hdr.lms.dto.UserInfoDTO;
import studio.hdr.lms.model.Clbumm;
import studio.hdr.lms.model.Department;
import studio.hdr.lms.model.Major;
import studio.hdr.lms.model.Sex;
import studio.hdr.lms.model.User;
import studio.hdr.lms.model.view.UserInfoView;
import studio.hdr.lms.service.IUserServce;
import studio.hdr.lms.util.DateHelper;

@Component
public class UserServceImpl implements IUserServce {

	private UserDAO userDao;
	private IDepartmentDAO departmentDao;
	private IMajorDAO majorDao;
	private ClbummDAO clbummDao;
	private SexDAO sexDao;
	private IUserInfoViewDAO userInfoDao;

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Department> getDepartments() {
		List<Department> departments = departmentDao.findAll();

		return departments;
	}

	public List<ClbummDTO> getClbummsByMajorId(int majorId) {
		// Major major = majorDao.findById(majorId);
		List<Clbumm> clbumms = clbummDao.findByMajorId(majorId);

		List<ClbummDTO> dtos = new ArrayList<ClbummDTO>(clbumms.size());
		for (Clbumm clbumm : clbumms) {
			ClbummDTO dto=new ClbummDTO();
			dto.setClbummId(clbumm.getClbummId());
			dto.setClbummNum(clbumm.getClbummNum());
			dtos.add(dto);
		}

		return dtos;
		// return major.getClbumms();
	}

	public List<MajorDTO> getMajorsByDepartmentId(int departmentId) {
		List<Major> majors = majorDao.findByDepartmentId(departmentId);
		List<MajorDTO> dtos = new ArrayList<MajorDTO>(majors.size());
		for (Major major : majors) {
			MajorDTO dto = new MajorDTO();
			dto.setMajorId(major.getMajorId());
			dto.setMajorName(major.getMajorName());
			dtos.add(dto);
		}
		return dtos;
	}

	public String getPasswordByName(String username) {
		return userDao.getPasswordByUserName(username);
	}

	public long getUserIdByUserName(String userName) {
		return userDao.getUserIdByUserName(userName);
	}

	@Autowired
	public void setClbummDao(ClbummDAO clbummDao) {
		this.clbummDao = clbummDao;
	}

	@Autowired
	public void setDepartmentDao(DepartmentDAO departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Autowired
	public void setMajorDao(IMajorDAO majorDao) {
		this.majorDao = majorDao;
	}

	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public User transform(UserDTO userDto) {
		User user = new User();

		// 设置简单非外键属性
		user.setUserName(userDto.getUsername());
		user.setUserPassword(userDto.getPassword());
		user.setUserMail(userDto.getMail());
		user.setUserQuestion(userDto.getQuestion());
		user.setUserAnswer(userDto.getAnswer());
		user.setUserMobilphone(userDto.getCellphone());
		user.setUserGrade(Integer.parseInt(userDto.getGrade()));

		// 设置生日
		Date date = new Date();
		date.setYear(Integer.parseInt(userDto.getYear()));
		date.setMonth(Integer.parseInt(userDto.getMonth()));
		date.setDate(Integer.parseInt(userDto.getDay()));
		user.setUserBirth(date);

		// 设置外键属性
		Sex sex = sexDao.findBySexName(userDto.getSex());
		user.setSex(sex);

		Department department = departmentDao.findById(userDto.getDepartment());
		user.setDepartment(department);

		Major major = majorDao.findById(userDto.getMajor());
		user.setMajor(major);
		if (major.getMajorName().equals("教师") == false) {
			Clbumm clbumm = clbummDao.findById(userDto.getClbumm());
			user.setClbumm(clbumm);
			StringBuffer strbuf = new StringBuffer();
			strbuf.append(userDto.getGrade());
			strbuf.append(department.getDepartmentId().toString());
			strbuf.append(major.getMajorNum());
			strbuf.append(clbumm.getClbummNum());
			strbuf.append(userDto.getNum());
			user.setUserNum(strbuf.toString());
		}
		return user;
	}

	@Autowired
	public void setSexDao(SexDAO sexDao) {
		this.sexDao = sexDao;
	}

	public boolean saveUser(User user) {
		userDao.save(user);

		return true;
	}

	public UserInfoDTO getUserInfoByUserId(long userId) {
		 UserInfoView userInfo=this.userInfoDao.findById(userId);
		 UserInfoDTO dto=new UserInfoDTO();
		 
		 dto.setUserName(userInfo.getName());
		 dto.setCellphone(userInfo.getCellphone());
		 dto.setClbumm(userInfo.getClbumm());
		 dto.setDepartment(userInfo.getDepartment());
		 dto.setGrade(userInfo.getGrade());
		 dto.setNum(userInfo.getNum());
		 dto.setMajor(userInfo.getMajor());
		 dto.setCount(userInfo.getCount());
		 dto.setBirth(DateHelper.formatDate(userInfo.getBirth()));
		 dto.setMail(userInfo.getMail());
		 
		 return dto;
	}

	@Autowired
	public void setUserInfoViewDao(IUserInfoViewDAO userInfoDao) {
		this.userInfoDao = userInfoDao;
	}


	public boolean changePasswordByUserId(String password, long userId) {
		User user=this.userDao.findById(userId);
		user.setUserPassword(password);
		this.userDao.update(user);
		return true;
	}


	public boolean isUserExistsByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userDao.isUserExistsByUserName(username);
	}

}
