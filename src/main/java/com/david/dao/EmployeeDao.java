package com.david.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.david.models.Employee;
import com.david.util.HibernateUtil;

//servlet 

public class EmployeeDao {
	
	//CRUD methods
	
	//Create (think that in the service layer have Register()
	public int insert(Employee e) {
		
		//grab session obj
		
		Session ses  = HibernateUtil.getSession();
		
		
		Transaction tx = ses.beginTransaction();
		
		//capture pk
		int pk = (int) ses.save(e);
		
		tx.commit();
		
		return pk;
		
	}
	
	//Read
	
	public List<Employee> findAll(){
		//grab the session
		
		Session ses = HibernateUtil.getSession();
		
		//make an HQL (Query Language)
		List<Employee> emps = ses.createQuery("from Employee", Employee.class).list();
		
		return emps;
		
	}
	
	public boolean delete(int id) {
		return false;
		
	}
	
	public boolean update(Employee e) {
		
		return false;
	}

}
