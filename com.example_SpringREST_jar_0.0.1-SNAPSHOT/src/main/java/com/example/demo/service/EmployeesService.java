package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employees;
import com.example.demo.repository.EmployeesRepositoryInterface;

@Service
public class EmployeesService {
  @Autowired
  EmployeesRepositoryInterface itr;
  
  //Single Employee get
  public Optional<Employees> get(int employeeId){
	  return itr.findById(employeeId);
  }
  //Get all employees
  public List<Employees> getAll(){
	  return (List<Employees>) itr.findAll();
  }
  //Update/create employee
  public Employees update(Employees employee) {
	  return itr.save(employee);
  }
  //Delete employee
  public void delete(Employees employee) {
	  itr.delete(employee);
  }
  //Delete all employees
  public void deleteAll() {
	  itr.deleteAll();
  }
}
