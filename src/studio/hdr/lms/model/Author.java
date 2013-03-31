package studio.hdr.lms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Author entity. @author MyEclipse Persistence Tools
 */

public class Author implements java.io.Serializable {

	// Fields

	private Long authorId;
	private Country country;
	private String authorName;
	private Set bookInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Author() {
	}

	/** minimal constructor */
	public Author(String authorName) {
		this.authorName = authorName;
	}

	/** full constructor */
	public Author(Country country, String authorName, Set bookInfos) {
		this.country = country;
		this.authorName = authorName;
		this.bookInfos = bookInfos;
	}

	// Property accessors

	public Long getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Set getBookInfos() {
		return this.bookInfos;
	}

	public void setBookInfos(Set bookInfos) {
		this.bookInfos = bookInfos;
	}

}