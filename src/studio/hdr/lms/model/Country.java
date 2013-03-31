package studio.hdr.lms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Country entity. @author MyEclipse Persistence Tools
 */

public class Country implements java.io.Serializable {

	// Fields

	private Long countryId;
	private String countryName;
	private Set authors = new HashSet(0);

	// Constructors

	/** default constructor */
	public Country() {
	}

	/** minimal constructor */
	public Country(String countryName) {
		this.countryName = countryName;
	}

	/** full constructor */
	public Country(String countryName, Set authors) {
		this.countryName = countryName;
		this.authors = authors;
	}

	// Property accessors

	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Set getAuthors() {
		return this.authors;
	}

	public void setAuthors(Set authors) {
		this.authors = authors;
	}

}