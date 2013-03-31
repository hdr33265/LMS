package studio.hdr.lms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Major entity. @author MyEclipse Persistence Tools
 */

public class Major implements java.io.Serializable {

	// Fields

	private Integer majorId;
	private Department department;
	private String majorName;
	private String majorNum;
	private Set clbumms = new HashSet(0);
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Major() {
	}

	/** minimal constructor */
	public Major(Department department, String majorName) {
		this.department = department;
		this.majorName = majorName;
	}

	/** full constructor */
	public Major(Department department, String majorName, String majorNum,
			Set clbumms, Set users) {
		this.department = department;
		this.majorName = majorName;
		this.majorNum = majorNum;
		this.clbumms = clbumms;
		this.users = users;
	}

	// Property accessors

	public Integer getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getMajorNum() {
		return this.majorNum;
	}

	public void setMajorNum(String majorNum) {
		this.majorNum = majorNum;
	}

	public Set getClbumms() {
		return this.clbumms;
	}

	public void setClbumms(Set clbumms) {
		this.clbumms = clbumms;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}