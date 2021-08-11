package com.web.springboot.web.app.service.impl;

/*import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.web.springboot.web.app.model.entity.Employee;
import com.web.springboot.web.app.service.IEmployeeService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

	@Autowired
	private IEmployeeService iEmployeeService;

	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path= "D:\\";
		List<Employee> employees = iEmployeeService.findAll();

		File file = ResourceUtils.getFile("class:employees.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);

		Map<String, Object> parameters = new HashedMap();
		parameters.put("createBy", "Diego Enriquez");

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint,path + "\\employess.html");
		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint,path + "\\employess.pdf");
		}
		
		return "reporte generado en: " + path;
	}

}*/
