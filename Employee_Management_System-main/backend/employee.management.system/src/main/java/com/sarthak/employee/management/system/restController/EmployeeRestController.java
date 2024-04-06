package com.sarthak.employee.management.system.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.employee.management.system.employee.service.InterServiceEmployee;
import com.sarthak.employee.management.system.model.Employee;

@RestController
@RequestMapping(value = "/emp")
@CrossOrigin(origins = "http://localhost:4200") // this annotation allows access to this rest end points in order to consumes it
public class EmployeeRestController {
	@Autowired
	InterServiceEmployee empService;
	
//	Getting all the list of Employees 
	@GetMapping(value = "/employees",produces = "application/json")
	public ResponseEntity<List<Employee>> returnEmployeeList(){
		List<Employee> empList=this.empService.getListOfEmployee();
		return ResponseEntity.status(HttpStatus.OK).body(empList);
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
		Employee employee= empService.readEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	@PostMapping(value = "/save",consumes = "application/json", produces="application/json")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		System.out.println(emp);
		Employee savedEmployee= empService.saveEmployee(emp);
		return ResponseEntity.status(HttpStatus.OK).body(savedEmployee);
	}
	@PutMapping(value = "/update/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee emp){
		Employee updatedEmployee= this.empService.updateEmployee(id, emp);
		return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable Integer id){
		Boolean isDeleted=this.empService.removeEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(isDeleted);
	}
	
}
