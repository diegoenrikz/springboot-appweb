package com.web.springboot.web.app.service;

import java.util.List;

import com.web.springboot.web.app.model.entity.Employee;

public interface IEmployeeService {
	
	public List<Employee> findAll();
	
	public void save(Employee employee);
	
	public Employee findOne(Integer id);
	
	public void delete(Integer id);

}
