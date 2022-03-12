package com.tothenew.sharda.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.tothenew.sharda.Entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
}