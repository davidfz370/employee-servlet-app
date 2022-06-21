package com.david.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.david.models.Employee;
import com.david.util.HibernateUtil;

public class EmployeeDao {
	
	//CRUD methods
	
	//Create (think that in the service layer have Register()
	public int insert(Employee e) {
		
		//grab session obj
		
		Session ses  = HibernateUtil.getSession();
		
		org.hibernate.Transaction tx = ses.beginTransaction();
		
		//capture pk
		int pk = (int) ses.save(e);
		
		return pk;
		
	}
	
	//Read
	
	public List<Employee> findAll(){
		
		
	}
	
	public boolean delete(int id) {
		return false;
		
	}
	
	public boolean update(Employee e) {
		
		
	}

}
