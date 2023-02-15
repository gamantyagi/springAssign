package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Employee {
	
	/* @Attributes:
	 * integer emp_id
	 * String name
	 * String email
	 * integer age
	 * integer salary
	 * Employee manager_id
	 * String address
	 * Department dept_id
	 */
	
	
	@Id
	@GeneratedValue
	private int employeeId;
	
	@NotNull
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String age;
	
	
	private int salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="manager_id")
	private Employee manager;
	
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="department_id")
	private Department department;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", email=" + email + ", age=" + age
				+ ", salary=" + salary + ", manager=" + manager + ", address=" + address + ", department=" + department
				+ "]";
	}
	
	
	

}
