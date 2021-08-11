package com.web.springboot.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.springboot.web.app.model.entity.Employee;
import com.web.springboot.web.app.service.IEmployeeService;

@RestController
//@SessionAttributes("employee")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService employeeService;
	

	@GetMapping(value = "/employees")
	public List<Employee> getEmployees() {
		List<Employee> lisEmployees = employeeService.findAll();
		return lisEmployees;
	}

	@GetMapping(value = "/employee/{id}")
	public Employee getEmployee(@PathVariable(value = "id") Integer id) {

		return employeeService.findOne(id);
	}

	@PostMapping(value = "/employee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		
	}

	@DeleteMapping(value = "/employee/{id}")
	public void deleteEmployee(@PathVariable(value = "id") Integer id) {
		if (id > 0) {
			employeeService.delete(id);
		}
	}
	

}
