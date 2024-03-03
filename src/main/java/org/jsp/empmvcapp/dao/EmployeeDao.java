package org.jsp.empmvcapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.empmvcapp.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	@Autowired
	private EntityManager manager;
	
	public Employee saveEmp(Employee e) {
		manager.persist(e);
		EntityTransaction t=manager.getTransaction();
		t.begin();
		t.commit();
		return e;
	}
	
	public Employee updateEmp(Employee e) {
		Employee emp=manager.find(Employee.class, e.getId());
		if(emp!=null) {
			emp.setName(e.getName());
			emp.setPhone(e.getPhone());
			emp.setEmail(e.getEmail());
			emp.setGender(e.getGender());
			emp.setSalary(e.getSalary());
			EntityTransaction t=manager.getTransaction();
			t.begin();
			t.commit();
			return e;
		}
		return null;
	}
	
	public Employee findById(int id) {
		return manager.find(Employee.class, id);
	}
}
