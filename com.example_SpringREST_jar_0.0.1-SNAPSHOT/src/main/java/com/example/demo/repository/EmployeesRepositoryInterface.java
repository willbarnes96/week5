package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employees;

@Repository
public interface EmployeesRepositoryInterface extends CrudRepository<Employees,Integer>{

}
