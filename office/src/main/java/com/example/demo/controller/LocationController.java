package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Location;
import com.example.demo.service.LocationService;

@RestController
public class LocationController {

	@Autowired
	LocationService service;
	
	/**
	 * Method to Add location into DB
	 * @param location
	 * @return
	 */
	@PostMapping("/location")
	public Location addLocation(Location location)
	{
		return service.addLocation(location);
	}
	
	/**
	 * Method to update location in DB
	 * @param location
	 * @return
	 */
	@PutMapping("/location")
	public Location saveOrUpdateLocation(Location location)
	{
		return service.saveOrUpdateLocation(location);
	}
	
	/**
	 * Method to delete location from DB using location Id
	 * @param id
	 * @return
	 */
	@DeleteMapping("location/{id}")
	public String deleteLocation(@PathVariable int id)
	{
		return service.deleteLocation(id);
	}
	
	/**
	 * Method to fetch all location
	 * @return
	 */
	@GetMapping("/location")
	public Iterable<Location> getAllLocation()
	{
		return service.getAllLocation();
	}
	
	/**
	 * Method to fetch dlocation based on location Id
	 * @param id
	 * @return
	 */
	@GetMapping("/location/{id}")
	public Location getLocationById(@PathVariable int id)
	{
		return service.getLocationById(id);
	}
	
}
