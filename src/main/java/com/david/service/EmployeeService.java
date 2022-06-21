package com.david.service;

import java.util.List;
import java.util.Optional;

import com.david.dao.EmployeeDao;
import com.david.models.Employee;

public class EmployeeService {

	private EmployeeDao edao;
	
	/*
	 * 
	 * Dependency injection via Constructor Injection 
	 * 
	 * Constructor Injection is a way of ensuring that the employees
	 * that the EmployeeService object ALWAYS has an EmployeeDao object
	 * 
	 */
	
	public EmployeeService(EmployeeDao edao) {
		
		
		this.edao = edao;
	
	
	}
	/*
	 * 
	 * our servlet will pass the username and the password to this
	 * method invocation
	 */
	
	public Employee confirmLogin(String username, String password){
		
		//stream through all the employees that are returned
		Optional<Employee> possibleEmp = edao.findAll().stream()
				.filter(e->(e.getUsername().equals(username)&& e.getPassword().equals(password)))
				.findFirst();
		
		//if employee is present then return it, otherwise return empty object (id=0)
		
		
		return(possibleEmp.isPresent()? possibleEmp.get() : new Employee());
		//ideally you should optimize this and set up a custom exception to be returned
		
	}
	
	public List<Employee>getAll(){
		
		return edao.findAll();
	}
	
	
}
