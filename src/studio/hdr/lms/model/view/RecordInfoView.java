package studio.hdr.lms.model.view;

import java.util.Date;

/**
 * RecordInfoView entity. @author MyEclipse Persistence Tools
 */

public class RecordInfoView implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userId;
	private Long bookId;
	private String bookName;
	private String author;
	private String bookClass;
	private String press;
	private Double price;
	private Date date;

	// Constructors

	/** default constructor */
	public RecordInfoView() {
	}

	/** minimal constructor */
	public RecordInfoView(Long userId, Long bookId, String bookName,
			String author, String bookClass, String press) {
		this.userId = userId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.bookClass = bookClass;
		this.press = press;
	}

	/** full constructor */
	public RecordInfoView(Long userId, Long bookId, String bookName,
			String author, String bookClass, String press, Double price,
			Date date) {
		this.userId = userId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.bookClass = bookClass;
		this.press = press;
		this.price = price;
		this.date = date;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBookId() {
		return this.bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookClass() {
		return this.bookClass;
	}

	public void setBookClass(String bookClass) {
		this.bookClass = bookClass;
	}

	public String getPress() {
		return this.press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}