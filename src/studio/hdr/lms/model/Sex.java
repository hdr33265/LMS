package studio.hdr.lms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Sex entity. @author MyEclipse Persistence Tools
 */

public class Sex implements java.io.Serializable {

	// Fields

	private Integer sexId;
	private String sexName;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sex() {
	}

	/** minimal constructor */
	public Sex(String sexName) {
		this.sexName = sexName;
	}

	/** full constructor */
	public Sex(String sexName, Set users) {
		this.sexName = sexName;
		this.users = users;
	}

	// Property accessors

	public Integer getSexId() {
		return this.sexId;
	}

	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}

	public String getSexName() {
		return this.sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}