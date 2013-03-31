package studio.hdr.lms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Press entity. @author MyEclipse Persistence Tools
 */

public class Press implements java.io.Serializable {

	// Fields

	private Long pressId;
	private String pressName;
	private String pressAddr;
	private Set bookInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Press() {
	}

	/** minimal constructor */
	public Press(String pressName) {
		this.pressName = pressName;
	}

	/** full constructor */
	public Press(String pressName, String pressAddr, Set bookInfos) {
		this.pressName = pressName;
		this.pressAddr = pressAddr;
		this.bookInfos = bookInfos;
	}

	// Property accessors

	public Long getPressId() {
		return this.pressId;
	}

	public void setPressId(Long pressId) {
		this.pressId = pressId;
	}

	public String getPressName() {
		return this.pressName;
	}

	public void setPressName(String pressName) {
		this.pressName = pressName;
	}

	public String getPressAddr() {
		return this.pressAddr;
	}

	public void setPressAddr(String pressAddr) {
		this.pressAddr = pressAddr;
	}

	public Set getBookInfos() {
		return this.bookInfos;
	}

	public void setBookInfos(Set bookInfos) {
		this.bookInfos = bookInfos;
	}

}