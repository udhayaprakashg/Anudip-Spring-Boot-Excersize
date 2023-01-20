package com.rest.service;

import java.util.List;

import com.rest.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(long id);
	Employee UpdateEmployeeById(Employee employee,long id);
	void deleteEmployeeById(long id);

}
