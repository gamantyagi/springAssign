package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Department;

public interface DepartmentRepo extends CrudRepository<Department, Integer> {

	@Query("from Department where location.locationId=?1")
	List<Department> findByLocation(int locationId);

}
