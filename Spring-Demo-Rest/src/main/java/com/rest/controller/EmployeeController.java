package com.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Employee;
import com.rest.service.EmployeeService;


@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;


	//build create employee REST API
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
		
	}
	
	//build get all employees REST API
	@GetMapping("/get")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();}

	
	//build get employee by Id REST API
	@GetMapping("/getById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long empId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(empId),HttpStatus.OK);
	}
	
	
	//build update employee by Id REST API 
	@PutMapping("/updateById/{id}")
	public ResponseEntity<Employee> UpdateById(@PathVariable("id") long id, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.UpdateEmployeeById(employee,id),HttpStatus.OK);
	}
	
	//build delete employee by Id REST API
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> DeleteById(@PathVariable("id") long id){
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<String>("Employee Id was successfully deleted!", HttpStatus.OK);
	}
	
	
}	

