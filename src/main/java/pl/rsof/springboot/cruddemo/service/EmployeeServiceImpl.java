/*
  *  Company: RS
 *  Project: cruddemo
 *  Created: 5 kwi 2022  21:27:42
 *  Author:  RS 		
 */
package pl.rsof.springboot.cruddemo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.rsof.springboot.cruddemo.dao.EmployeeDAO;
import pl.rsof.springboot.cruddemo.entity.Employee;

/**
 * <p></p><p>5 kwi 2022</p>
 * @author RS
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	private EmployeeDAO employeeDAO;
	
	// aby serwis wiedział, który bean wstrzyknąć należy użyć Qualifier w serwisie lub Primary w DAO
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findEmployeeById(int id) {
		
		return employeeDAO.findEmployeeById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int id) {
		employeeDAO.deleteEmployeeById(id);
	}

}
