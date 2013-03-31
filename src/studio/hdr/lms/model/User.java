package studio.hdr.lms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Long userId;
	private Department department;
	private Major major;
	private Clbumm clbumm;
	private Sex sex;
	private String userName;
	private String userPassword;
	private String userMail;
	private String userMobilphone;
	private Integer userGrade;
	private Date userBirth;
	private String userNum;
	private Long userCount;
	private String userQuestion;
	private String userAnswer;
	private Set compensations = new HashSet(0);
	private Set books = new HashSet(0);
	private Set records = new HashSet(0);
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Sex sex, String userName, String userPassword, String userMail) {
		this.sex = sex;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userMail = userMail;
	}

	/** full constructor */
	public User(Department department, Major major, Clbumm clbumm, Sex sex,
			String userName, String userPassword, String userMail,
			String userMobilphone, Integer userGrade, Date userBirth,
			String userNum, Long userCount, String userQuestion,
			String userAnswer, Set compensations, Set books, Set records,
			Set orders) {
		this.department = department;
		this.major = major;
		this.clbumm = clbumm;
		this.sex = sex;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userMail = userMail;
		this.userMobilphone = userMobilphone;
		this.userGrade = userGrade;
		this.userBirth = userBirth;
		this.userNum = userNum;
		this.userCount = userCount;
		this.userQuestion = userQuestion;
		this.userAnswer = userAnswer;
		this.compensations = compensations;
		this.books = books;
		this.records = records;
		this.orders = orders;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Clbumm getClbumm() {
		return this.clbumm;
	}

	public void setClbumm(Clbumm clbumm) {
		this.clbumm = clbumm;
	}

	public Sex getSex() {
		return this.sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserMail() {
		return this.userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserMobilphone() {
		return this.userMobilphone;
	}

	public void setUserMobilphone(String userMobilphone) {
		this.userMobilphone = userMobilphone;
	}

	public Integer getUserGrade() {
		return this.userGrade;
	}

	public void setUserGrade(Integer userGrade) {
		this.userGrade = userGrade;
	}

	public Date getUserBirth() {
		return this.userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserNum() {
		return this.userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public Long getUserCount() {
		return this.userCount;
	}

	public void setUserCount(Long userCount) {
		this.userCount = userCount;
	}

	public String getUserQuestion() {
		return this.userQuestion;
	}

	public void setUserQuestion(String userQuestion) {
		this.userQuestion = userQuestion;
	}

	public String getUserAnswer() {
		return this.userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public Set getCompensations() {
		return this.compensations;
	}

	public void setCompensations(Set compensations) {
		this.compensations = compensations;
	}

	public Set getBooks() {
		return this.books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

	public Set getRecords() {
		return this.records;
	}

	public void setRecords(Set records) {
		this.records = records;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}