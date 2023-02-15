package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

	@Query("from Employee where manager.employeeId=?1")
	List<Employee> findByManager(int managerId);

	@Query("from Employee where department.departmentId=?1")
	List<Employee> findByDepartment(int departmentId);

}
