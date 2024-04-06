package com.sarthak.employee.management.system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "empIdGenerator")
	@SequenceGenerator(name = "empIdGenerator",sequenceName = "empIdSequence",initialValue = 1,allocationSize = 1)
	@Column(name = "emp_id")
	private Integer employeeID;
	
	@Column(name ="emp_fname" )
	private String employeeFName;
	
	@Column(name="emp_lname")
	private String employeeLName;
	
	@Column(name="emp_mail")
	private String employeeEmail;
	
	public Employee() {
		
	}

	public Employee(String employeeFName, String employeeLName, String employeeEmail) {
		super();
		this.employeeFName = employeeFName;
		this.employeeLName = employeeLName;
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeFName() {
		return employeeFName;
	}
	
	public Integer getEmployeeID() {
		return employeeID;
	}
	
	public void setEmployeeFName(String employeeFName) {
		this.employeeFName = employeeFName;
	}

	public String getEmployeeLName() {
		return employeeLName;
	}

	public void setEmployeeLName(String employeeLName) {
		this.employeeLName = employeeLName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeFName=" + employeeFName + ", employeeLName="
				+ employeeLName + ", employeeEmail=" + employeeEmail + "]";
	}
	
}
