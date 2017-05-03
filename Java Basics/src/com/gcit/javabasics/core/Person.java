package com.gcit.javabasics.core;

import java.io.Serializable;

public class Person implements Serializable{ //Serializable is a Marker Interface

	private static final long serialVersionUID = -3157251433472573124L;
	
	private Integer personID;
	private String personName;
	
	public Person(Integer personID, String personName){
		this.personID = personID;
		this.personName = personName;
	}
	/**
	 * @return the personID
	 */
	public Integer getPersonID() {
		return personID;
	}
	/**
	 * @param personID the personID to set
	 */
	public void setPersonID(Integer personID) {
		this.personID = personID;
	}
	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personID == null) ? 0 : personID.hashCode());
		result = prime * result + ((personName == null) ? 0 : personName.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (personID == null) {
			if (other.personID != null)
				return false;
		} else if (!personID.equals(other.personID))
			return false;
		if (personName == null) {
			if (other.personName != null)
				return false;
		} else if (!personName.equals(other.personName))
			return false;
		return true;
	}
}
