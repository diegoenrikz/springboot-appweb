package com.web.springboot.web.app.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.web.springboot.web.app.model.entity.Employee;

public interface IEmployeeDao extends CrudRepository<Employee, Integer>{
	

}
