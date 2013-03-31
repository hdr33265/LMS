package studio.hdr.lms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * BookClass entity. @author MyEclipse Persistence Tools
 */

public class BookClass implements java.io.Serializable {

	// Fields

	private Long classId;
	private String className;
	private Set bookInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public BookClass() {
	}

	/** minimal constructor */
	public BookClass(String className) {
		this.className = className;
	}

	/** full constructor */
	public BookClass(String className, Set bookInfos) {
		this.className = className;
		this.bookInfos = bookInfos;
	}

	// Property accessors

	public Long getClassId() {
		return this.classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set getBookInfos() {
		return this.bookInfos;
	}

	public void setBookInfos(Set bookInfos) {
		this.bookInfos = bookInfos;
	}

}