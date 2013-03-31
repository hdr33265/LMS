package studio.hdr.lms.model;

/**
 * SuperAdmin entity. @author MyEclipse Persistence Tools
 */

public class SuperAdmin implements java.io.Serializable {

	// Fields

	private Long superAdminId;
	private String superAdminName;
	private String superAdminPassword;
	private String superAdminQuestion;
	private String superAdminAnswer;

	// Constructors

	/** default constructor */
	public SuperAdmin() {
	}

	/** minimal constructor */
	public SuperAdmin(String superAdminName, String superAdminPassword) {
		this.superAdminName = superAdminName;
		this.superAdminPassword = superAdminPassword;
	}

	/** full constructor */
	public SuperAdmin(String superAdminName, String superAdminPassword,
			String superAdminQuestion, String superAdminAnswer) {
		this.superAdminName = superAdminName;
		this.superAdminPassword = superAdminPassword;
		this.superAdminQuestion = superAdminQuestion;
		this.superAdminAnswer = superAdminAnswer;
	}

	// Property accessors

	public Long getSuperAdminId() {
		return this.superAdminId;
	}

	public void setSuperAdminId(Long superAdminId) {
		this.superAdminId = superAdminId;
	}

	public String getSuperAdminName() {
		return this.superAdminName;
	}

	public void setSuperAdminName(String superAdminName) {
		this.superAdminName = superAdminName;
	}

	public String getSuperAdminPassword() {
		return this.superAdminPassword;
	}

	public void setSuperAdminPassword(String superAdminPassword) {
		this.superAdminPassword = superAdminPassword;
	}

	public String getSuperAdminQuestion() {
		return this.superAdminQuestion;
	}

	public void setSuperAdminQuestion(String superAdminQuestion) {
		this.superAdminQuestion = superAdminQuestion;
	}

	public String getSuperAdminAnswer() {
		return this.superAdminAnswer;
	}

	public void setSuperAdminAnswer(String superAdminAnswer) {
		this.superAdminAnswer = superAdminAnswer;
	}

}