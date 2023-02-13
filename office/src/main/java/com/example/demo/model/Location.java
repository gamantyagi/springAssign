package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Location {
	
	/*
	 * @Attributes:
	 * integer location_id
	 * String name
	 */
	
	@Id
	@GeneratedValue
	private int location_id;
	
	@NotNull
	private String name;
	
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Location [location_id=" + location_id + ", name=" + name + "]";
	}
	
	

}
