package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Department {
	
	/*
	 * @Attributes:
	 * integer departmentId
	 * String Name
	 * Location location_id
	 */
	
	@Id
	@GeneratedValue
	private int departmentId;
	
	@NotNull
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	private Location location;


	public int getDepartmentId() {
		return departmentId;
	}



	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Location getLocation() {
		return location;
	}



	public void setLocation(Location location) {
		this.location = location;
	}



	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + ", location=" + location + "]";
	}



	
	
	

}
