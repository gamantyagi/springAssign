package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	/**
	 * Method to Add department into DB
	 * @param department
	 * @return
	 */
	@PostMapping("/department")
	public Department addDepartment(Department department)
	{
		return service.addDepartment(department);
	}
	
	/**
	 * Method to update department in DB
	 * @param department
	 * @return
	 */
	@PutMapping("/department")
	public Department saveOrUpdateDepartment(Department department)
	{
		return service.saveOrUpdateDepartment(department);
	}
	
	/**
	 * Method to delete department from DB using department Id
	 * @param id
	 * @return
	 */
	@DeleteMapping("department/{id}")
	public String deleteDepartment(@PathVariable int id)
	{
		return service.deleteDepartment(id);
	}
	
	/**
	 * Method to fetch all department
	 * @return
	 */
	@GetMapping("/department")
	public Iterable<Department> getAllDepartment()
	{
		return service.getAllDepartment();
	}
	
	/**
	 * Method to fetch department based ondepartment Id
	 * @param id
	 * @return
	 */
	@GetMapping("/department/{id}")
	public Department getDepartmentById(@PathVariable int id)
	{
		return service.getDepartmentById(id);
	}
	
	/**
	 * Method to fetch department based on Location Id
	 * @param location_id
	 * @return
	 */
	@GetMapping("/location/{locationId}/department")
	public List<Department> getDepartmentByLocationId(@PathVariable int locationId)
	{
		return service.getDepartmentByLocationId(locationId);
	}
	
	
}
