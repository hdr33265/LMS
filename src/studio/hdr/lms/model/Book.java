package studio.hdr.lms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Long bookId;
	private User user;
	private State state;
	private BookInfo bookInfo;
	private Date bookDate;
	private Long bookBorrowCount;
	private Set records = new HashSet(0);
	private Set orders = new HashSet(0);
	private Set compensations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	/** full constructor */
	public Book(User user, State state, BookInfo bookInfo, Date bookDate,
			Long bookBorrowCount, Set records, Set orders, Set compensations) {
		this.user = user;
		this.state = state;
		this.bookInfo = bookInfo;
		this.bookDate = bookDate;
		this.bookBorrowCount = bookBorrowCount;
		this.records = records;
		this.orders = orders;
		this.compensations = compensations;
	}

	// Property accessors

	public Long getBookId() {
		return this.bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
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

	public BookInfo getBookInfo() {
		return this.bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public Date getBookDate() {
		return this.bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public Long getBookBorrowCount() {
		return this.bookBorrowCount;
	}

	public void setBookBorrowCount(Long bookBorrowCount) {
		this.bookBorrowCount = bookBorrowCount;
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

	public Set getCompensations() {
		return this.compensations;
	}

	public void setCompensations(Set compensations) {
		this.compensations = compensations;
	}

}