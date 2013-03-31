package studio.hdr.lms.model;

import java.util.Date;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Long adminId;
	private String adminName;
	private String adminPassword;
	private String adminCellphone;
	private String adminMail;
	private String adminNum;
	private Date adminBirth;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(String adminName, String adminPassword) {
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	/** full constructor */
	public Admin(String adminName, String adminPassword, String adminCellphone,
			String adminMail, String adminNum, Date adminBirth) {
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminCellphone = adminCellphone;
		this.adminMail = adminMail;
		this.adminNum = adminNum;
		this.adminBirth = adminBirth;
	}

	// Property accessors

	public Long getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminCellphone() {
		return this.adminCellphone;
	}

	public void setAdminCellphone(String adminCellphone) {
		this.adminCellphone = adminCellphone;
	}

	public String getAdminMail() {
		return this.adminMail;
	}

	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}

	public String getAdminNum() {
		return this.adminNum;
	}

	public void setAdminNum(String adminNum) {
		this.adminNum = adminNum;
	}

	public Date getAdminBirth() {
		return this.adminBirth;
	}

	public void setAdminBirth(Date adminBirth) {
		this.adminBirth = adminBirth;
	}

}