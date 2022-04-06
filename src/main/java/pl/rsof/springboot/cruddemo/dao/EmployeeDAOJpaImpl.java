/*
 *  Company: RS
 *  Project: cruddemo
 *  Created: 6 kwi 2022  21:51:37
 *  Author:  RS 		
 */
package pl.rsof.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.rsof.springboot.cruddemo.entity.Employee;

/**
 * <p>Standard JPA API implementation</p><p>6 kwi 2022</p>
 * @author RS
 *
 */
@Repository
//@Primary
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	
	private EntityManager entityManager;
	
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	@Override
	public List<Employee> findAll() {
		
		Query query = entityManager.createQuery("from Employee");
		
		List<Employee>employeees = query.getResultList();
		
		return employeees;
	}

	@Override
	public Employee findEmployeeById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Employee employee_db =  entityManager.merge(employee);
		
		employee.setId(employee_db.getId());
	}

	@Override
	public void deleteEmployeeById(int id) {
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
