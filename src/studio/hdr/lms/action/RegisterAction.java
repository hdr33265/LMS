package studio.hdr.lms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import studio.hdr.lms.dto.ClbummDTO;
import studio.hdr.lms.dto.MajorDTO;
import studio.hdr.lms.dto.UserDTO;
import studio.hdr.lms.model.Department;
import studio.hdr.lms.model.User;
import studio.hdr.lms.service.IUserServce;
import studio.hdr.lms.util.DateHelper;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("registerAction")
@Scope("prototype")
public class RegisterAction extends ActionSupport implements
		ModelDriven<UserDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDTO userDto = new UserDTO();
	private IUserServce userServce;
	//初始化JSP所需要的一些属性
	private List<Department> departments;
	private List<String> grades;
	private List<String> birthYears;
	private List<String> months;
	//Ajar请求的输出参数
	private List<MajorDTO> majors;
	private List<ClbummDTO> clbumms;
	private boolean isUserExists;
//	private boolean isAdminExists;
	private List<String> days;
	
	
	//ajax请求的输入参数
	private int departmentId;
	private int majorId;
	private String uname;
	private int birthYear;
	private int birthMonth;
	

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	
	public String validateUserIsExists() {
		//System.out.println();	
		isUserExists = userServce.isUserExistsByUsername(uname);
		return "isUserExists";
	}

	@Override
	public String execute() throws Exception {
		grades = DateHelper.latestYears;
		departments = userServce.getDepartments();
		birthYears = DateHelper.birthYears;
		months = DateHelper.months;
		return SUCCESS;
	}

	public String getBirthDays(){
		this.days=DateHelper.getDays(birthYear, birthMonth);
		return "days";
	}
	
	public String getMajorsByDepartmentId() {
//		System.out.println("学院号:"+departmentId);
		this.majors= userServce.getMajorsByDepartmentId(departmentId);

		return "majors";
	}

	public String getClbummsByMajorId() {
		System.out.println("专业号:"+majorId);
		this.clbumms = userServce.getClbummsByMajorId(majorId);
		return "clbumms";
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public String register(){
		User user=userServce.transform(userDto);
		userServce.saveUser(user);
		return "registerSuccess";
	}
	
	public String showInfo() {
		System.out.println(userDto.getUsername());
		System.out.println(userDto.getPassword());
		System.out.println(userDto.getCellphone());
		System.out.println(userDto.getMail());
		System.out.println(userDto.getQuestion());
		System.out.println(userDto.getAnswer());
		System.out.println(userDto.getGrade());
		System.out.println(userDto.getDepartment());
		System.out.println(userDto.getMajor());
		System.out.println(userDto.getClbumm());
		System.out.println(userDto.getNum());
		System.out.println(userDto.getYear());
		System.out.println(userDto.getMonth());
		System.out.println(userDto.getDay());
		System.out.println(userDto.getSex());
		return "login";
	}

	public UserDTO getModel() {
		// TODO Auto-generated method stub
		return userDto;
	}

	public List<String> getGrades() {
		return grades;
	}

	public void setGrades(List<String> grades) {
		this.grades = grades;
	}

	public List<Department> getDepartments() {
		return departments;
	}


	public IUserServce getUserServce() {
		return userServce;
	}

	@Autowired
	public void setUserServce(IUserServce userServce) {
		this.userServce = userServce;
	}

	
	public void setMajors(List<MajorDTO> majors){
		this.majors=majors;
	}
	
	public List<MajorDTO> getMajors() {
		return majors;
	}



	public List<ClbummDTO> getClbumms() {
		return clbumms;
	}

	public boolean getIsUserExists() {
		return isUserExists;
	}
	


	public List<String> getBirthYears() {
		return birthYears;
	}

	public void setBirthYears(List<String> birthYears) {
		this.birthYears = birthYears;
	}

	public List<String> getMonths() {
		return months;
	}

	public void setMonths(List<String> months) {
		this.months = months;
	}

	public List<String> getDays() {
		return days;
	}

	public void setDays(List<String> days) {
		this.days = days;
	}

}
