package org.jsp.app.service;

import java.util.List;
import java.util.Optional;

import org.jsp.app.daointerface.EmployeeDaoInterface;
import org.jsp.app.entity.Employee;
import org.jsp.app.excption.InvalidEmployeeData;
import org.jsp.app.excption.UserNotFoundException;
import org.jsp.app.responsestructure.ResponseStructure;
import org.jsp.app.serviceinterface.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements EmployeeServiceInterface{
	@Autowired
	private EmployeeDaoInterface empdao;

//	@Override
//	public ResponseEntity<?> findAllEmployees() {
//		List<Employee> emp=empdao.findEmployeeDao();
//		if(!emp.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
//					.message("All Employees in company").body(emp).build());
//		}
//		else {
//			throw UserNotFoundException.builder().message("No User found").build();
//		}
//	}
	
	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> emp=empdao.findEmployeeDao();
		if(!emp.isEmpty()) {
			return emp;
		}
		else {
			throw UserNotFoundException.builder().message("No User found").build();
		}
	}

	@Override
	public ResponseEntity<?> findEmployeeById(int id) {
		Optional<Employee> emp=empdao.findEmployeeByIdDao(id);
		if(emp.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
					.message("User Found Based on Given Id").body(emp.get()));
		}
		else {
			throw UserNotFoundException.builder().message("No Employee Found Based on Given Id").build();
		}
	}

//	@Override
//	public ResponseEntity<?> saveEmployee(Employee employee) {
//		if(employee!=null) {
//			Employee emp=empdao.saveEmployeeDao(employee);
//			return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
//					.message("Employee saved in data base").body(emp).build());
//		}
//		else {
//			throw InvalidEmployeeData.builder().message("Given Employee Is null").build();
//		}
//	}
	
	@Override
	public void saveEmployee(Employee employee) {
		if(employee!=null) {
			Employee emp=empdao.saveEmployeeDao(employee);
		}
		else {
			//throw InvalidEmployeeData.builder().message("Given Employee Is null").build();
		}
	}

	@Override
	public ResponseEntity<?> deleteEmployeeByIdService(int id) {
		Optional<Employee> emp=empdao.findEmployeeByIdDao(id);
		if(emp.isPresent()) {
			empdao.deleteEmployeeDao(id);
			return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
					.message("Employee Deleted Successfully").body(emp.get()).build());
		}
		else {
			throw UserNotFoundException.builder().message("No Employee Found Based On Given Id").build();
		}
	}

//	@Override
//	public ResponseEntity<?> updateEmployee(int id, Employee employee) {
//		Optional<Employee> emp=empdao.findEmployeeByIdDao(id);
//		if(emp.isPresent()) {
//			Employee updateemp=empdao.updateEmployeeDao(employee);
//			return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
//					.message("Employee Updated Succussfully").body(updateemp).build());
//		}
//		else {
//			throw UserNotFoundException.builder().message("No Employee Found Based given Id").build();
//		}
//	}
	
	@Override
	public void updateEmployee(int id, Employee employee) {
		Optional<Employee> emp=empdao.findEmployeeByIdDao(id);
		if(emp.isPresent()) {
			Employee updateemp=empdao.updateEmployeeDao(employee);
		}
		else {
			throw UserNotFoundException.builder().message("No Employee Found Based given Id").build();
		}
	}
}
