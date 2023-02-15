package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Location;
import com.example.demo.repo.LocationRepo;

@Service
public class LocationService {
	@Autowired
	LocationRepo repo;
	
	/**
	 * Method to Add location into DB
	 * @param location
	 * @return
	 */
	public Location addLocation(Location location)
	{
		repo.save(location);
		return location;
	}
	
	/**
	 * Method to update location in DB
	 * @param location
	 * @return
	 */
	public Location saveOrUpdateLocation(Location location)
	{
		repo.save(location);
		return location;
	}
	
	/**
	 * Method to delete location from DB using location Id
	 * @param id
	 * @return
	 */
	public String deleteLocation(int id)
	{
		Location location = repo.findById(id).orElseThrow();
		repo.delete(location);
		return "deleted";
	}
	
	/**
	 * Method to fetch all location
	 * @return
	 */
	public Iterable<Location> getAllLocation()
	{
		return repo.findAll();
	}
	
	/**
	 * Method to fetch dlocation based on location Id
	 * @param id
	 * @return
	 */
	public Location getLocationById(int id)
	{
		Location location =  repo.findById(id).orElseThrow();
		return location;
	}
}
