package com.pro.wings.SpringBootDemoFirst.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.wings.SpringBootDemoFirst.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	
	
	

}
