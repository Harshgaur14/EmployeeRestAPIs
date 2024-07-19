package com.pracproject.Practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pracproject.Practice.EmployeeNotFoundException;
import com.pracproject.Practice.entity.Employee;
import com.pracproject.Practice.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	public List<Employee> getAllemployee(){
	return	employeeRepo.findAll();
	}
	
	public Employee save(Employee employee)
	{
		 return employeeRepo.save(employee);
	}
	
	public Optional<Employee> getById(int id)
	{
		return employeeRepo.findById(id);
	}
	@Transactional
	public Optional<Employee> updateUser(int id,Employee employee)
	{
		Optional<Employee> existingEmployee=employeeRepo.findById(id);
		if(existingEmployee.isPresent()) {
			Employee updateemployee=existingEmployee.get();
				updateemployee.setfName(employee.getfName());
				updateemployee.setPhoneno(employee.getPhoneno());
				employeeRepo.save(updateemployee);
				return existingEmployee;		
		}else
		{
			throw new EmployeeNotFoundException("employee with id "+id+" not found");
		}
	
	}
	
}
