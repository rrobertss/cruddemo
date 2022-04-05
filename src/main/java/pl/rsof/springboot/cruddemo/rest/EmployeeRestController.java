/*
 *  Company: RS
 *  Project: cruddemo
 *  Created: 4 kwi 2022  21:22:35
 *  Author:  RS 		
 */
package pl.rsof.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.rsof.springboot.cruddemo.dao.EmployeeDAO;
import pl.rsof.springboot.cruddemo.entity.Employee;
import pl.rsof.springboot.cruddemo.service.EmployeeService;

/**
 * <p></p><p>4 kwi 2022</p>
 * @author RS
 *
 */
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	
	
	// "/employees" endpoint
	@GetMapping("/employees")
	public List<Employee>findAll(){
		return employeeService.findAll();
	}
	
	
	// mapowanie GET/employees/{id}
	@GetMapping("/employees/{id}")
	public Employee findEmployeeById(@PathVariable int id) {
		
		Employee employee = employeeService.findEmployeeById(id);
		if (employee == null) {
			throw new RuntimeException("Employee not fount - "+id);
		}
		
		return employee;
	}
	
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		// set id to 0 - force save a new item, instead of update
		employee.setId(0);
		employeeService.save(employee);
		
		return employee;
	}
	
	
}
