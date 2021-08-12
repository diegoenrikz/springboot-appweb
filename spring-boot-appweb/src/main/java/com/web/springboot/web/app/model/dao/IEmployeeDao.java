package com.web.springboot.web.app.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.springboot.web.app.model.entity.Employee;

public interface IEmployeeDao extends CrudRepository<Employee, Integer> {
	
	@Query("SELECT new com.web.springboot.web.app.model.entity.Employee"
			+ "(e.id,e.nombre, e.apellido, b.nombre, b.apellido,b.cargo ,b.salario) " + "FROM Employee e " 
			+ "INNER JOIN Employee b "
			+ "ON e.id = b.jefe")
	List<Employee> findEmployeebyJefe();

}
