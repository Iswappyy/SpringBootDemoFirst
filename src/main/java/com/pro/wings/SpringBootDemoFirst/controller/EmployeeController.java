package com.pro.wings.SpringBootDemoFirst.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.wings.SpringBootDemoFirst.dao.EmployeeDao;
import com.pro.wings.SpringBootDemoFirst.entity.Employee;


@RestController
public class EmployeeController {
	@Autowired
	EmployeeDao empDao;
	

@PostMapping("/employee")
public Employee saveEmployee(@RequestBody Employee emp) {
	return empDao.save(emp);
	
}
@GetMapping("/all")	
public List<Employee> getAll(){
	return (List<Employee>) empDao.findAll();
	
}
@GetMapping("/all/{id}")
public Optional<Employee> getEmployeeById(@PathVariable("id") int id)
{
	
	return empDao.findById(id);
	
}
@PutMapping("/update/{id}")
public Employee updateEmployee(@PathVariable("id") int id,@RequestBody Employee emp) {
	 
	Employee emp1 = empDao.getById(id);
	emp1.setName(emp.getName());
	
	Employee updateEmp2 = empDao.save(emp1);
	
	return updateEmp2;
			
	
}
@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteNote(@PathVariable("id") int id){
	Employee emp = empDao.getById(id);
	empDao.delete(emp);
	return ResponseEntity.ok().build();
}

}
