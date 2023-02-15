package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Department;
import com.example.demo.repo.DepartmentRepo;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepo repo;
	
	/**
	 * Method to Add department into DB
	 * @param department
	 * @return
	 */
	public Department addDepartment(Department department)
	{
		repo.save(department);
		return department;
	}
	
	/**
	 * Method to update department in DB
	 * @param department
	 * @return
	 */
	public Department saveOrUpdateDepartment(Department department)
	{
		repo.save(department);
		return department;
	}
	
	/**
	 * Method to delete department from DB using department Id
	 * @param id
	 * @return
	 */
	public String deleteDepartment( int id)
	{
		Department department = repo.findById(id).orElseThrow();
		department.setLocation(null);
		repo.delete(department);
		return "deleted";
	}
	
	/**
	 * Method to fetch all department
	 * @return
	 */
	public Iterable<Department> getAllDepartment()
	{
		return repo.findAll();
	}
	
	/**
	 * Method to fetch department based ondepartment Id
	 * @param id
	 * @return
	 */
	public Department getDepartmentById( int id)
	{
		Department department =  repo.findById(id).orElseThrow();
		return department;
	}
	
	/**
	 * Method to fetch department based on Location Id
	 * @param location_id
	 * @return
	 */
	public List<Department> getDepartmentByLocationId( int locationId)
	{
		List<Department> department =  repo.findByLocation(locationId);
		return  department;
	}
}
