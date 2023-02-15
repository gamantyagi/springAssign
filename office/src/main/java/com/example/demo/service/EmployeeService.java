package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;


@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo repo;
	
	/**
	 * Method to save employee into DB
	 * @param employee
	 * @return employee
	 */
	public Employee saveEmployee( Employee employee)
	{
		repo.save(employee);
		return employee;
	}
	
	/**
	 * Method to update employee in DB
	 * @param employee
	 * @return employee
	 */
	public Employee saveOrUpdateEmployee(Employee employee)
	{
		repo.save(employee);
		return employee;
	}
	
	public Employee getManager(Employee employee)
	{
		Employee manager = employee.getManager();
		return manager;
	}
	
	public void setManager(Employee employee, Employee manager)
	{
		employee.setManager(manager);
		repo.save(employee);
		
	}
	
	/**
	 * Method to delete employee from DB using employee Id
	 * @param id
	 * @return constant String
	 */
	public String deleteEmployee( int id)
	{
		Employee employee = repo.findById(id).orElseThrow();
		employee.setDepartment(null);
		employee.setManager(employee.getManager().getManager());
		
		repo.delete(employee);
		return "deleted";
	}
	
	/**
	 * Method to fetch all employee
	 * @return list of employee
	 */
	public Iterable<Employee> getAllEmployee()
	{
		return repo.findAll();
	}
	
	/**
	 * Method to fetch employee based on employee Id
	 * @param id
	 * @return employee
	 */
	public Employee getEmployeeById( int id)
	{
		Employee employee =  repo.findById(id).orElseThrow();
		return employee;
	}
	
	/**
	 * Method to fetch employees based on manager Id
	 * @param manager_id
	 * @return 
	 */
	public List<Employee> getEmployeeByManagerId( int managerId)
	{
		List<Employee> employees =  repo.findByManager(managerId);
		return  employees;
	}
	
	/**
	 * Method to fetch employees based on department Id
	 * @param department_id
	 * @return
	 */
	public List<Employee> getEmployeeByDepartmentId( int departmentId)
	{
		List<Employee> employees =  repo.findByDepartment(departmentId);
		return  employees;
	}
}
