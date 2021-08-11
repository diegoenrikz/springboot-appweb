package com.web.springboot.web.app.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.springboot.web.app.service.IEmployeeService;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;

@Controller
public class ReportController {

	@Autowired
	private IEmployeeService iEmployeeService;

	@GetMapping("/reporte")
	public void generateHtml(HttpServletResponse response) throws Exception,FileNotFoundException, JRException {

		response.setContentType("text/html");
		
		JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(
				iEmployeeService.findAll());
		
		JasperReport compileReport = JasperCompileManager
				.compileReport(new FileInputStream("D://Web//workspace-spring-tool//spring-boot-appweb//src//main//resources//employee.jrxml"));

		HashMap<String, Object> map = new HashMap<>();
		
		JasperPrint report = JasperFillManager.fillReport(compileReport, map,jrBeanCollectionDataSource);
		
		HtmlExporter htmlExporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
		
		htmlExporter.setExporterInput(new SimpleExporterInput(report));
		htmlExporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
		htmlExporter.exportReport();
		
	}
	
}
