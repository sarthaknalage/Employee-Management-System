package com.employee.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
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

import com.employee.Enitity.Classes.Employee;
import com.employee.Repository.EmployeeRepo;

@RestController
@RequestMapping("/emp")
@CrossOrigin("*")
public class EmployeeController {

   @Autowired
   private EmployeeRepo employeeRepo;
   
   // get All employees
   
   // http://localhost:8080/emp/employees
   @GetMapping("/employees")
   public List<Employee> getAllEmployees(){
	   return this.employeeRepo.findAll();
   }
   
   // create new employee
   
   // http://localhost:8080/emp/save
   @PostMapping("/save")
   public ResponseEntity<Iterable<Employee>> addNewEmployee(@RequestBody Employee emp){
	   Employee employee = this.employeeRepo.save(emp);
	   return new ResponseEntity<Iterable<Employee>>(HttpStatus.OK);
   }
   
   // get employee data by id
   // http://localhost:8080/emp/get/id
   @GetMapping("/get/{id}")
   public ResponseEntity<Optional<Employee>> getElementById(@PathVariable("id") Long id){
	   Optional<Employee> employee = employeeRepo.findById(id);
	   return ResponseEntity.ok(employee);
   }
   
   // update employee
   
   // http://localhost:8080/emp/id
   
   @PutMapping("/update/{id}")
   public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id ,@RequestBody Employee emp){
	   Employee employee = employeeRepo.findById(id).orElseThrow();
	   
	   employee.setFirstName(emp.getFirstName());
	   employee.setLastName(emp.getLastName());
	   employee.setEmail(emp.getEmail());
	   
	   Employee update = employeeRepo.save(employee);
	   return ResponseEntity.ok(update);
   }   
   
	// delete employee by id
	// here we can use map for shown message on console successfully deleted or not?
	 
    // http://localhost:8080/emp/delete/id
   
	@DeleteMapping("/delete/{id}")   
	public ResponseEntity<Map<String, Long>> deleteEmployee(@PathVariable("id") Long id){
		Employee employee = employeeRepo.findById(id).orElseThrow();
		employeeRepo.delete(employee);
		
		Map<String, Long> result = new HashMap<>();
		result.put("Employee deleted Successfully : ID -",+id);
		return ResponseEntity.ok(result);
	  
   }
}  
   
   
   
   
   
   
   
   
   
   

