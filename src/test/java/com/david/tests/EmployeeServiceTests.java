package com.david.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.david.dao.EmployeeDao;
import com.david.models.Employee;
import com.david.service.EmployeeService;

public class EmployeeServiceTests {
	
	private EmployeeService eserv;
	
	private EmployeeDao mockdao;
	
	@Before
	public void setup() {
		
		mockdao = mock(EmployeeDao.class);
		eserv = new EmployeeService(mockdao);
		
	}
	
	
	@After
	public void teardown() {
		
		mockdao = null;
		eserv = null;
	}
	
	
	@Test
	public void testConfirmLogin_success() {
		//1 create a fake list of employees
		//dummy feed we feed to mockito
		Employee e1 = new Employee(20,"Bruce","Banner", "thehulk", "green");
		Employee e2 = new Employee(21,"Clint","Barton", "hawkeye", "arrows");

		List<Employee> emps = new ArrayList<Employee>();
		
		emps.add(e1);
		emps.add(e2);
		
		
		//capture the actual output of the method
		//capture the expected output of the methods
		
		when(mockdao.findAll()).thenReturn(emps);
		
		Employee actual = eserv.confirmLogin("thehulk", "green");
		
		Employee expected =e1;
		//assert that they are equal
		assertEquals(expected,actual);
		
	}
	@Test
	public void testConfirmLogin_fail() {
		
		//dummy feed we feed to mockito
		Employee e1 = new Employee(20,"Bruce","Banner", "thehulk", "green");
		Employee e2 = new Employee(21,"Clint","Barton", "hawkeye", "arrows");

		List<Employee> emps = new ArrayList<Employee>();
		
		emps.add(e1);
		emps.add(e2);
		
		
		//capture the actual output of the method
		//capture the expected output of the methods
		
		when(mockdao.findAll()).thenReturn(emps);
		
		Employee actual = eserv.confirmLogin("thehulk", "blue");
		
		Employee expected =new Employee();
		//assert that they are equal
		assertEquals(expected,actual);
		
		
	}


}
