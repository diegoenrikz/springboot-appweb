package com.web.springboot.web.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.springboot.web.app.model.dao.IEmployeeDao;
import com.web.springboot.web.app.model.entity.Employee;
import com.web.springboot.web.app.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return (List<Employee>) employeeDao.findAll();
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDao.save(employee);

	}

	@Override
	@Transactional(readOnly = true)
	public Employee findOne(Integer id) {
		return employeeDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		employeeDao.deleteById(id);

	}

	@Override
	public List<Employee> findEmployeebyJefe() {
		return employeeDao.findEmployeebyJefe();
		
	}

}
