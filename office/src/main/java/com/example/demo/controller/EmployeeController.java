package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.transaction.Transactional;

@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeService service;
	
	/**
	 * Method to Add employee into DB
	 * @param employee
	 * @return employee
	 */
	@PostMapping("/employee")
	public Employee addEmployee( Employee employee)
	{
		return service.saveEmployee(employee);
	}
	
	/**
	 * Method to update employee in DB
	 * @param employee
	 * @return employee
	 */
	@PutMapping("/employee")
	public Employee saveOrUpdateEmployee(Employee employee)
	{
		return service.saveOrUpdateEmployee(employee);
	}
	
	/**
	 * Method to delete employee from DB using employee Id
	 * @param id
	 * @return constant String
	 */
	@DeleteMapping("employee/{id}")
	@Transactional
	public String deleteEmployee(@PathVariable int id)
	{
		return service.deleteEmployee(id);
	}
	
	/**
	 * Method to fetch all employee
	 * @return list of employee
	 */
	@GetMapping("/employee")
	public Iterable<Employee> getAllEmployee()
	{
		return service.getAllEmployee();
	}
	
	/**
	 * Method to fetch employee based on employee Id
	 * @param id
	 * @return employee
	 */
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id)
	{
		return service.getEmployeeById(id);
	}
	
	/**
	 * Method to fetch employees based on manager Id
	 * @param manager_id
	 * @return 
	 */
	@GetMapping("/manager/{managerId}/employee")
	public List<Employee> getEmployeeByManagerId(@PathVariable("managerId") int managerId)
	{
		return service.getEmployeeByManagerId(managerId);
	}
	
	/**
	 * Method to fetch employees based on department Id
	 * @param department_id
	 * @return
	 */
	@GetMapping("/department/{departmentId}/employee")
	public List<Employee> getEmployeeByDepartmentId(@PathVariable int departmentId)
	{
		return service.getEmployeeByDepartmentId(departmentId);
	}

}
