package com.employee.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJPA extends JpaRepository<Employee, Integer>{

}
