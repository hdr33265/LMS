package studio.hdr.lms.model.view;

/**
 * SimpleBookDetailView entity. @author MyEclipse Persistence Tools
 */

public class SimpleBookDetailView implements java.io.Serializable {

	// Fields

	private Long id;
	private Long borrower;
	private Long borrowCount;
	private Long bookInfo;
	private String state;

	// Constructors

	/** default constructor */
	public SimpleBookDetailView() {
	}

	/** minimal constructor */
	public SimpleBookDetailView(String state) {
		this.state = state;
	}

	/** full constructor */
	public SimpleBookDetailView(Long borrower, Long borrowCount, String state) {
		this.borrower = borrower;
		this.borrowCount = borrowCount;
		this.state = state;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBorrower() {
		return this.borrower;
	}

	public void setBorrower(Long borrower) {
		this.borrower = borrower;
	}

	public Long getBorrowCount() {
		return this.borrowCount;
	}

	public void setBorrowCount(Long borrowCount) {
		this.borrowCount = borrowCount;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(Long bookInfo) {
		this.bookInfo = bookInfo;
	}

}