package studio.hdr.lms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * State entity. @author MyEclipse Persistence Tools
 */

public class State implements java.io.Serializable {

	// Fields

	private Integer stateId;
	private String stateName;
	private Set books = new HashSet(0);
	private Set compensations = new HashSet(0);

	// Constructors

	/** default constructor */
	public State() {
	}

	/** minimal constructor */
	public State(String stateName) {
		this.stateName = stateName;
	}

	/** full constructor */
	public State(String stateName, Set books, Set compensations) {
		this.stateName = stateName;
		this.books = books;
		this.compensations = compensations;
	}

	// Property accessors

	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Set getBooks() {
		return this.books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

	public Set getCompensations() {
		return this.compensations;
	}

	public void setCompensations(Set compensations) {
		this.compensations = compensations;
	}

}