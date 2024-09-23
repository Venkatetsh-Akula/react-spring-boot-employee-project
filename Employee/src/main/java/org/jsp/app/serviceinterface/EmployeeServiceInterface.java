package org.jsp.app.serviceinterface;
import java.util.List;

import org.jsp.app.entity.Employee;
import org.jsp.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


public interface EmployeeServiceInterface{

	//public ResponseEntity<?> findAllEmployees();
	public List<Employee> findAllEmployees();

	public ResponseEntity<?> findEmployeeById(int id);

//	public ResponseEntity<?> saveEmployee(Employee employee);
	public void saveEmployee(Employee employee);

	public ResponseEntity<?> deleteEmployeeByIdService(int id);

//	public ResponseEntity<?> updateEmployee(int id, Employee employee);
		
	public void updateEmployee(int id, Employee employee);
}
