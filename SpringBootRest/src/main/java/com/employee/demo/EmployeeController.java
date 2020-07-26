package com.employee.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeJPA employeeJPA;

	public EmployeeJPA getEmployeeJPA() {
		return employeeJPA;
	}

	public void setEmployeeJPA(EmployeeJPA employeeJPA) {
		this.employeeJPA = employeeJPA;
	}
	
	@PostMapping("/employee")
	public Employee saveEmp(@RequestBody Employee employee) {
		employeeJPA.save(employee);
		return employee;
	}
	
	@GetMapping("/employee/{empid}")
	public Optional<Employee> getEmp(@PathVariable("empid") int empid) {
		return employeeJPA.findById(empid);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmp() {
		return employeeJPA.findAll();
	}
	
	@DeleteMapping("/employee/{empid}")
	public boolean delEmp(@PathVariable("empid") int empid) {
		employeeJPA.deleteById(empid);
		return true;
	}
	
}
