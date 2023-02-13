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
	private int emp_id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Min(value=18, message="Age must be greater than or equal to 18 ")
	@Max(value=60)
	private int age;
	
	
	private int salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="manager_id")
	private Employee manager;
	
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dept_id")
	private Department department;
	
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
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
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", email=" + email + ", age=" + age + ", salary="
				+ salary + ", manager=" + manager + ", address=" + address + ", department=" + department + "]";
	}

}
