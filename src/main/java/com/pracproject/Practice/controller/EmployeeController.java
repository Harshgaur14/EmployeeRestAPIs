package com.pracproject.Practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pracproject.Practice.EmployeeNotFoundException;
import com.pracproject.Practice.entity.Employee;
import com.pracproject.Practice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll(){
		List<Employee> employees=employeeService.getAllemployee();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<Employee> addUser(@RequestBody Employee employee){
		Employee newemployee=employeeService.save(employee);
		return new ResponseEntity<>(newemployee,HttpStatus.CREATED);
	}
	@GetMapping("/getEmployee")
	public ResponseEntity<?> getEmployee(@RequestParam int id)
	{
		Optional<Employee> employee=employeeService.getById(id);
		return new ResponseEntity<>(employee,HttpStatus.FOUND);
	}
	
	@PutMapping("/addUser/{id}")
	public ResponseEntity<Optional<Employee>> updateEmployee(@PathVariable int id,@RequestBody Employee updateEmployee){
		
		try{
		Optional<Employee> employee=employeeService.updateUser(id, updateEmployee);
		return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
		}
		catch(EmployeeNotFoundException ex) {
			throw ex;
		}catch(Exception ex) {
			throw new RuntimeException("An unexpected error occured "+ex.getMessage());
		}
	}
	
	
	
	
}
