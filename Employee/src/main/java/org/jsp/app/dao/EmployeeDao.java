package org.jsp.app.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.app.daointerface.EmployeeDaoInterface;
import org.jsp.app.entity.Employee;
import org.jsp.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao implements EmployeeDaoInterface {
	
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public List<Employee> findEmployeeDao() {
		return emprepo.findAll();
	}

	@Override
	public Optional<Employee> findEmployeeByIdDao(int id) {
		return emprepo.findById(id);
	}

	@Override
	public Employee saveEmployeeDao(Employee employee) {
		return emprepo.save(employee);
	}

	@Override
	public void deleteEmployeeDao(int id) {
		emprepo.deleteById(id);
	}

	@Override
	public Employee updateEmployeeDao(Employee employee) {
		return emprepo.save(employee);
	}

}
