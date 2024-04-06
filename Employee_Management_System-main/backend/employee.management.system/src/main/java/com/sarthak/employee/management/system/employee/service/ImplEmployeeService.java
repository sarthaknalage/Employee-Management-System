package com.sarthak.employee.management.system.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.employee.management.system.employee.persistent.IEmployeeRepository;
import com.sarthak.employee.management.system.model.Employee;

@Service
public class ImplEmployeeService implements InterServiceEmployee {
	@Autowired
	IEmployeeRepository empRepo;

	@Override
	public Employee readEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return this.empRepo.findById(id).get();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return this.empRepo.saveAndFlush(emp);
	}

	@Override
	public Employee updateEmployee(Integer id, Employee emp) {
		// TODO Auto-generated method stub
		if(this.empRepo.existsById(id)) {
			Integer isUpdated=this.empRepo.updatedRecord(id, emp.getEmployeeFName(),emp.getEmployeeLName(),emp.getEmployeeEmail(),id);
			if(isUpdated>0) {
				return this.readEmployeeById(id);
			}
		}
		return null;
	}

	@Override
	public Boolean removeEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		 this.empRepo.deleteById(id);
		 return this.empRepo.findById(id).isEmpty();
	}

	@Override
	public List<Employee> getListOfEmployee() {
		List<Employee> empList=this.empRepo.findAll();
		return empList;
	}
	
	

}
