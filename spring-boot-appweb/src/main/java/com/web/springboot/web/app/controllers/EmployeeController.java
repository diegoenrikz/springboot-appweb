package com.web.springboot.web.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.web.springboot.web.app.model.entity.Employee;
import com.web.springboot.web.app.service.IEmployeeService;

@Controller
@SessionAttributes("employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping(value = "/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Empleados");
		model.addAttribute("employees", employeeService.findAll());
		return "listar";
	}

	@GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		Employee employee = new Employee();

		model.put("titulo", "Formulario Crear Nuevo Empleado");
		model.put("employee", employee);
		return "form";
	}

	@GetMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Integer id, Map<String, Object> model) {

		Employee employee = new Employee();
		if (id > 0) {
			employee = employeeService.findOne(id);
		} else {
			return "redirect:/listar";
		}

		model.put("titulo", "Formulario para Editar el Empleado");
		model.put("employee", employee);
		return "form";
	}

	@PostMapping(value = "/form")
	public String guardar(@Valid Employee employee, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Empleado");
			return "form";
		}
		employeeService.save(employee);
		status.setComplete();
		return "redirect:listar";
	}

	@GetMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
		if (id > 0) {
			employeeService.delete(id);
		}

		return "redirect:/listar";
	}

}
