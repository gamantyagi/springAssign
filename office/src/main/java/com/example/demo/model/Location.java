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
	private int locationId;
	
	@NotNull
	private String name;

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", name=" + name + "]";
	}
	
	
	

}
