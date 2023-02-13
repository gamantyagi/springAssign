package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeRepo repo;
	
	/**
	 * Method to Add employee into DB
	 * @param employee
	 * @return employee
	 */
	@PostMapping("/employee")
	public Employee addEmployee( Employee employee)
	{
		repo.save(employee);
		return employee;
	}
	
	/**
	 * Method to update employee in DB
	 * @param employee
	 * @return employee
	 */
	@PutMapping("/employee")
	public Employee saveOrUpdateEmployee(Employee employee)
	{
		repo.save(employee);
		return employee;
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
		Employee employee = repo.findById(id).orElseThrow();
		employee.setManager(null);
		employee.setDepartment(null);
		repo.delete(employee);
		return "deleted";
	}
	
	/**
	 * Method to fetch all employee
	 * @return list of employee
	 */
	@GetMapping("/employee")
	public Iterable<Employee> getAllEmployee()
	{
		return repo.findAll();
	}
	
	/**
	 * Method to fetch employee based on employee Id
	 * @param id
	 * @return employee
	 */
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id)
	{
		Employee employee =  repo.findById(id).orElseThrow();
		return employee;
	}
	
	/**
	 * Method to fetch employees based on manager Id
	 * @param manager_id
	 * @return 
	 */
	@GetMapping("/manager/{manager_id}/employee")
	public List<Employee> getEmployeeByManagerId(@PathVariable("manager_id") int manager_id)
	{
		List<Employee> employees =  repo.findByManager_Emp_Id(manager_id);
		return  employees;
	}
	
	/**
	 * Method to fetch employees based on department Id
	 * @param department_id
	 * @return
	 */
	@GetMapping("/department/{department_id}/employee")
	public List<Employee> getEmployeeByDepartmentId(@PathVariable int department_id)
	{
		List<Employee> employees =  repo.findByDepartment(department_id);
		return  employees;
	}

}
