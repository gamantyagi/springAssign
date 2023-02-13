package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

	//@Query("from Employee where manager.emp_id=?1")
	List<Employee> findByManager_Emp_Id(int manager_id);

	@Query("from Employee where department.dept_id=?1")
	List<Employee> findByDepartment(int department_id);

}
