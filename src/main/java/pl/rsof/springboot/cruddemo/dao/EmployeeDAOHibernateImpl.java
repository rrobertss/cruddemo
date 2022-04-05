/*
 *  Company: RS
 *  Project: cruddemo
 *  Created: 31 mar 2022  22:36:03
 *  Author:  RS 		
 */
package pl.rsof.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.rsof.springboot.cruddemo.entity.Employee;

/**
 * <p></p><p>31 mar 2022</p>
 * @author RS
 *
 */
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	
	private EntityManager entityManager;
	
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	 
	public List<Employee> findAll() {
		
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		// native hibernate API
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		List<Employee>employees = query.getResultList();
		
		return employees;
	}


	@Override
	public Employee findEmployeeById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, id);
		
		return employee;
	}


	@Override
	public void save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		// if id=0 then insert else update
		session.saveOrUpdate(employee);
	}


	@Override
	public void deleteEmployeeById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Query<?> query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
