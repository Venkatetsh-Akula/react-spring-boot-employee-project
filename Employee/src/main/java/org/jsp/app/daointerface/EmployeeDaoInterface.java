package org.jsp.app.daointerface;

import java.util.List;
import java.util.Optional;

import org.jsp.app.entity.Employee;

public interface EmployeeDaoInterface {

	List<Employee> findEmployeeDao();

	Optional<Employee> findEmployeeByIdDao(int id);

	Employee saveEmployeeDao(Employee employee);

	void deleteEmployeeDao(int id);

	Employee updateEmployeeDao(Employee employee);

}
