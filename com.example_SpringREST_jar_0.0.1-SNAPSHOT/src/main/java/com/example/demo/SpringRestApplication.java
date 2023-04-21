package com.example.demo;

import com.example.demo.repository.EmployeesRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.model.Employees;

@SpringBootApplication
public class SpringRestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}
        
        @Autowired
        EmployeesRepositoryInterface empRepository;
        
        @Override
        public void run(String... args) throws Exception {
            this.empRepository.save(new Employees(1,"w",1851));
            this.empRepository.save(new Employees(2,"sound and the fury",1932));
            this.empRepository.save(new Employees(3,"inferno",1322));
        }

}
