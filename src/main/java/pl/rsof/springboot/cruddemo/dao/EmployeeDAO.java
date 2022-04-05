/*
 *  Company: RS
 *  Project: cruddemo
 *  Created: 31 mar 2022  22:34:04
 *  Author:  RS 		
 */
package pl.rsof.springboot.cruddemo.dao;

import java.util.List;

import pl.rsof.springboot.cruddemo.entity.Employee;

/**
 * <p></p><p>31 mar 2022</p>
 * @author RS
 *
 */
public interface EmployeeDAO {

	public List<Employee>findAll();
	
	public Employee findEmployeeById(int id);
	
	public void save(Employee employee);
	
	public void deleteEmployeeById(int id);
	
}
