package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Employees;
import com.example.demo.service.EmployeesService;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@ResponseBody
@CrossOrigin("*")
//@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api")
public class EmployeesController {
	@Autowired
	EmployeesService its;
	
	//Get All employees
	@GetMapping(value= {"/employees"})
	public List<Employees> getAll(){
		List<Employees> employees = its.getAll();
		System.out.println("employees retrieved "+employees.size());
		return employees;
	}
	//Get an employee
	@GetMapping("/employees/{id}")
	public Employees get(@PathVariable("id") Integer id) {
		Optional<Employees> i = its.get(id);
		return i.get();
	}
	//Insert an employee
	@PostMapping("/employees")
	public Employees add(@RequestBody Employees employee) {
		return its.update(employee);
	}
	//Update an employee
	@PutMapping("/employees")
	public Employees edit(@RequestBody Employees employee) {
		return its.update(employee);
	}
	//Delete an employee
	@DeleteMapping("/employees")
	public String delete(@RequestParam(value="id") Integer id) {
		Optional<Employees> i = its.get(id);
		its.delete(i.get());
		return "Employee id "+id+" deleted successfully";
	}

}
