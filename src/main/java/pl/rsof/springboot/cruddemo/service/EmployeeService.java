/*
 *  Company: RS
 *  Project: cruddemo
 *  Created: 5 kwi 2022  21:26:36
 *  Author:  RS 		
 */
package pl.rsof.springboot.cruddemo.service;

import java.util.List;

import pl.rsof.springboot.cruddemo.entity.Employee;

/**
 * <p></p><p>5 kwi 2022</p>
 * @author RS
 *
 */
public interface EmployeeService {

	public List<Employee>findAll();
	
	public Employee findEmployeeById(int id);
	
	public void save(Employee employee);
	
	public void deleteEmployeeById(int id);
	
}
