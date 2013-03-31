package studio.hdr.lms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Clbumm entity. @author MyEclipse Persistence Tools
 */

public class Clbumm implements java.io.Serializable {

	// Fields

	private Integer clbummId;
	private Integer clbummMajor;
	private String clbummNum;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Clbumm() {
	}

	/** minimal constructor */
	public Clbumm(Integer clbummMajor, String clbummNum) {
		this.clbummMajor = clbummMajor;
		this.clbummNum = clbummNum;
	}

	/** full constructor */
	public Clbumm(Integer clbummMajor, String clbummNum, Set users) {
		this.clbummMajor = clbummMajor;
		this.clbummNum = clbummNum;
		this.users = users;
	}

	// Property accessors

	public Integer getClbummId() {
		return this.clbummId;
	}

	public void setClbummId(Integer clbummId) {
		this.clbummId = clbummId;
	}

	public Integer getClbummMajor() {
		return this.clbummMajor;
	}

	public void setClbummMajor(Integer clbummMajor) {
		this.clbummMajor = clbummMajor;
	}

	public String getClbummNum() {
		return this.clbummNum;
	}

	public void setClbummNum(String clbummNum) {
		this.clbummNum = clbummNum;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}