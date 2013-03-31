package studio.hdr.lms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Lang entity. @author MyEclipse Persistence Tools
 */

public class Lang implements java.io.Serializable {

	// Fields

	private Long langId;
	private String langName;
	private Set bookInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Lang() {
	}

	/** minimal constructor */
	public Lang(String langName) {
		this.langName = langName;
	}

	/** full constructor */
	public Lang(String langName, Set bookInfos) {
		this.langName = langName;
		this.bookInfos = bookInfos;
	}

	// Property accessors

	public Long getLangId() {
		return this.langId;
	}

	public void setLangId(Long langId) {
		this.langId = langId;
	}

	public String getLangName() {
		return this.langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}

	public Set getBookInfos() {
		return this.bookInfos;
	}

	public void setBookInfos(Set bookInfos) {
		this.bookInfos = bookInfos;
	}

}