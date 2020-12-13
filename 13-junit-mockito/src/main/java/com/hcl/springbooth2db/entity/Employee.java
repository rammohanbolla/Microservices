package com.hcl.springbooth2db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
 
    @Column(name = "first_name", length = 16, nullable = false)
    private String firstName;
    
    @Column(name = "last_name", length = 16, nullable = false)
    private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
}
