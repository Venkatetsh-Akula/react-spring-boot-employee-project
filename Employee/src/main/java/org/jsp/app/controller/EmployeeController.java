package org.jsp.app.controller;

import java.util.List;

import org.jsp.app.entity.Employee;
import org.jsp.app.serviceinterface.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value="/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceInterface empservice;
	
//	@GetMapping
//	public ResponseEntity<?> allEmployees(){
//		return empservice.findAllEmployees();
//	}
	
	@GetMapping
	public List<Employee> allEmployees(){
		return empservice.findAllEmployees();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findEmployeeById(@PathVariable int id){
		return empservice.findEmployeeById(id);
	}
//	@PostMapping
//	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
//		return empservice.saveEmployee(employee);
//	}
	
	@PostMapping
	public void saveEmployee(@RequestBody Employee employee){
		System.out.println("Methoe invoked "+employee);
		empservice.saveEmployee(employee);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable int id){
		return empservice.deleteEmployeeByIdService(id);
	}
//	@PutMapping("/id")
//	public ResponseEntity<?> updateEmployee(@PathVariable int id,@RequestBody Employee employee){
//		return empservice.updateEmployee(id,employee);
//	}
	
	@PutMapping("/{id}")
	public void updateEmployee(@PathVariable int id,@RequestBody Employee employee){
		empservice.updateEmployee(id,employee);
	}
} 
