package com.rest.service.impl;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.exception.ResourceNotFoundException;
import com.rest.model.Employee;
import com.rest.repository.EmployeeRepository;
import com.rest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}



	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}



	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));			
	}



	@Override
	public Employee UpdateEmployeeById(Employee employee, long id) {
		
		Employee exisitingEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		
		exisitingEmployee.setFirstName(employee.getFirstName());
		exisitingEmployee.setLastName(employee.getLastName());
		exisitingEmployee.setEmail(employee.getEmail());
		
		//Save
		employeeRepository.save(exisitingEmployee);
		return exisitingEmployee;
	}



	@Override
	public void deleteEmployeeById(long id) {
		//Check whether id is exist or not
		
		employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		
		employeeRepository.deleteById(id);
	}
	
	
	

}
