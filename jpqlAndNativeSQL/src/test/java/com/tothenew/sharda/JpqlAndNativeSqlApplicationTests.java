package com.tothenew.sharda;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.tothenew.sharda.Model.Employee;
import com.tothenew.sharda.Repository.EmployeeRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestEntityManager
class JpqlAndNativeSqlApplicationTests {

	@Autowired
	EmployeeRepository repository;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void TestInsertEmployee() {
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Employee emp3 = new Employee();
		Employee emp4 = new Employee();
		Employee emp5 = new Employee();
		
		emp1.setFirstName("Sneha");
		emp1.setLastName("Kumari");
		emp1.setSalary(5000);
		emp1.setAge(24);
		
		emp2.setFirstName("Saloni");
		emp2.setLastName("Singh");
		emp2.setSalary(45000);
		emp2.setAge(23);
		
		emp3.setFirstName("Nidhi");
		emp3.setLastName("Kumari");
		emp3.setSalary(4000);
		emp3.setAge(22);
		
		emp4.setFirstName("Sapna");
		emp4.setLastName("Singh");
		emp4.setSalary(35000);
		emp4.setAge(21);
		
		emp5.setFirstName("Lolu");
		emp5.setLastName("Kumar");
		emp5.setSalary(15000);
		emp5.setAge(50);
		
		repository.save(emp1);
		repository.save(emp2);
		repository.save(emp3);
		repository.save(emp4);
		repository.save(emp5);
	}
	
	@Test
	public void testFindAllEmployees() {
		System.out.println(repository.findAllEmployees());
	}
	
	@Test
	public void testFindAllEmployeesPartialData() {
		List<Object[]> part = repository.findAllEmployeesPartialData();
		for (Object[] obj : part) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
	}
	
	
	@Test
	public void testFindAllEmployeesWithAverageSalary() {
		List<Object[]> part = repository.findAllEmployeesWithAverageSalary();
		for (Object[] obj : part) {
			System.out.print(obj[0]+" ");
			System.out.println(obj[1]+" ");
		}
		System.out.println();
	}
	
	@Test
	@Transactional
	@Rollback(value = false)
	public void testUpdateSalary(){
		int salary= 40000;
		int avgSalary = repository.findAverageSalary();
		repository.updateSalary(salary, avgSalary);
	}
	
	@Test
	@Rollback(false)
	@Transactional
	public void testDeleteEmployeesBySalary() {
		repository.deleteEmployeesBySalary(4000);
	}
	
	@Test
	public void testFindAllEmployeesBylastName() {
		List<Object[]> part = repository.findAllEmployeesBylastName();
		for (Object[] obj : part) {
			System.out.print(obj[0] + " ");
			System.out.print(obj[1] + " ");
			System.out.print(obj[2] + " ");
		}
		System.out.println();
	}
	
	@Test
	@Rollback(false)
	@Transactional
	public void testDeleteEmployeesByAge() {
		repository.deleteEmployeesByAge(30);;
	}
}
