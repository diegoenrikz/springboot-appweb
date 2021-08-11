package com.web.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

	@RequestMapping("/")
    public String welcome() {
        return "index";
    }
	
	@RequestMapping("/listar")
    public String listra() {
        return "listar";
    }
}

