package com.example;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Transactional
	public void save(Employee emp ) {
		this.sessionfactory.getCurrentSession().persist(emp);
		
	}

}
