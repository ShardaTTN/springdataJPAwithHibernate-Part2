package com.tothenew.sharda.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.tothenew.sharda.Model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	@Query("from Employee")
	List<Employee> findAllEmployees();
	
	@Query("select e.firstName, e.lastName from Employee e")
	List<Object[]> findAllEmployeesPartialData();
	
	
	@Query("select e.firstName, e.lastName from Employee e where e.salary > (select avg(e.salary) from e)")
	List<Object[]> findAllEmployeesWithAverageSalary();
	
	@Query("select avg(salary) from Employee")
    int findAverageSalary();
	
	@Modifying
	@Query("UPDATE Employee SET salary= :salary where salary < :avgsalary")
	void updateSalary(@Param("salary") int salary , @Param("avgsalary") int avgsalary);
	
	@Modifying
	@Query("delete from Employee e where e.salary= :salary")
	void deleteEmployeesBySalary(@Param("salary") int salary);
	
	
	@Query(value = "select e.empid, e.empfirstname, e.empage from employeetable e where e.emplastname like '%singh'", nativeQuery = true)
	List<Object[]> findAllEmployeesBylastName();
	
	@Modifying
	@Query(value = "delete from employeetable e where e.empage > 45", nativeQuery = true)
	void deleteEmployeesByAge(@Param("age") int age);
}