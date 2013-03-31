package studio.hdr.lms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * BookInfo entity. @author MyEclipse Persistence Tools
 */

public class BookInfo implements java.io.Serializable {

	// Fields

	private Long bookInfoId;
	private Lang lang;
	private Author author;
	private BookClass bookClass;
	private Press press;
	private String bookInfoName;
	private String bookInfoDescription;
	private Double bookInfoPrice;
	private Set books = new HashSet(0);

	// Constructors

	/** default constructor */
	public BookInfo() {
	}

	/** minimal constructor */
	public BookInfo(String bookInfoName) {
		this.bookInfoName = bookInfoName;
	}

	/** full constructor */
	public BookInfo(Lang lang, Author author, BookClass bookClass, Press press,
			String bookInfoName, String bookInfoDescription,
			Double bookInfoPrice, Set books) {
		this.lang = lang;
		this.author = author;
		this.bookClass = bookClass;
		this.press = press;
		this.bookInfoName = bookInfoName;
		this.bookInfoDescription = bookInfoDescription;
		this.bookInfoPrice = bookInfoPrice;
		this.books = books;
	}

	// Property accessors

	public Long getBookInfoId() {
		return this.bookInfoId;
	}

	public void setBookInfoId(Long bookInfoId) {
		this.bookInfoId = bookInfoId;
	}

	public Lang getLang() {
		return this.lang;
	}

	public void setLang(Lang lang) {
		this.lang = lang;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public BookClass getBookClass() {
		return this.bookClass;
	}

	public void setBookClass(BookClass bookClass) {
		this.bookClass = bookClass;
	}

	public Press getPress() {
		return this.press;
	}

	public void setPress(Press press) {
		this.press = press;
	}

	public String getBookInfoName() {
		return this.bookInfoName;
	}

	public void setBookInfoName(String bookInfoName) {
		this.bookInfoName = bookInfoName;
	}

	public String getBookInfoDescription() {
		return this.bookInfoDescription;
	}

	public void setBookInfoDescription(String bookInfoDescription) {
		this.bookInfoDescription = bookInfoDescription;
	}

	public Double getBookInfoPrice() {
		return this.bookInfoPrice;
	}

	public void setBookInfoPrice(Double bookInfoPrice) {
		this.bookInfoPrice = bookInfoPrice;
	}

	public Set getBooks() {
		return this.books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

}