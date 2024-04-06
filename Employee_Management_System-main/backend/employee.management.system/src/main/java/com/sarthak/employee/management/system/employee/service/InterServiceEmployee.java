package com.sarthak.employee.management.system.employee.service;

import java.util.List;

import com.sarthak.employee.management.system.model.Employee;

public interface InterServiceEmployee {
//	abstract method for read the data from database need to provide id
	public Employee readEmployeeById(Integer id);
	
//	abstract method for inserting the employee in db
	public Employee saveEmployee(Employee emp);
	
//	abstract method for updating the existing employee information
	public Employee updateEmployee(Integer id,Employee emp);

//	abstract method for remove the existing employee from db
	public Boolean removeEmployeeById(Integer id);
	
//	get list of employees
	public List<Employee> getListOfEmployee();
}
