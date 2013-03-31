package studio.hdr.lms.model;

import java.util.Date;

/**
 * Compensation entity. @author MyEclipse Persistence Tools
 */

public class Compensation implements java.io.Serializable {

	// Fields

	private Long compensationId;
	private Book book;
	private User user;
	private State state;
	private Long compensationAmount;
	private Date compensationDate;

	// Constructors

	/** default constructor */
	public Compensation() {
	}

	/** minimal constructor */
	public Compensation(Book book, User user, State state) {
		this.book = book;
		this.user = user;
		this.state = state;
	}

	/** full constructor */
	public Compensation(Book book, User user, State state,
			Long compensationAmount, Date compensationDate) {
		this.book = book;
		this.user = user;
		this.state = state;
		this.compensationAmount = compensationAmount;
		this.compensationDate = compensationDate;
	}

	// Property accessors

	public Long getCompensationId() {
		return this.compensationId;
	}

	public void setCompensationId(Long compensationId) {
		this.compensationId = compensationId;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Long getCompensationAmount() {
		return this.compensationAmount;
	}

	public void setCompensationAmount(Long compensationAmount) {
		this.compensationAmount = compensationAmount;
	}

	public Date getCompensationDate() {
		return this.compensationDate;
	}

	public void setCompensationDate(Date compensationDate) {
		this.compensationDate = compensationDate;
	}

}