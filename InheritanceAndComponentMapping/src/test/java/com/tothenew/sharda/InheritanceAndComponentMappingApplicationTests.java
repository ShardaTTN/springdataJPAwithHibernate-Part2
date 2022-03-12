package com.tothenew.sharda;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.tothenew.sharda.Entities.Check;
import com.tothenew.sharda.Entities.CreditCard;
import com.tothenew.sharda.Entities.Employee;
import com.tothenew.sharda.Entities.Salary;
import com.tothenew.sharda.Repositories.EmployeeRepository;
import com.tothenew.sharda.Repositories.PaymentRepository;



@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestEntityManager
class InheritanceAndComponentMappingApplicationTests {
	
	@Autowired
	PaymentRepository repo;
	
	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void createPayment() {
		CreditCard cc = new CreditCard();
		cc.setId(123);
		cc.setAmount(10000);
		cc.setCardnumber("1234567890");
		repo.save(cc);
	}
	
	@Test
	public void createCheckPayment() {
		Check ch = new Check();
		ch.setId(124);
		ch.setAmount(10000);
		ch.setChecknumber("1234567890");
		repo.save(ch);
	}
	
	
	

	@Test
	public void testCreate() {
		Employee employee = new Employee();
		Salary salary = new Salary();

		employee.setAge(23);
		employee.setId(123);
		employee.setFirstname("Sneha");
		employee.setLastname("Kumari");

		salary.setBasicsalary(30000);
		salary.setBonussalary(5000);
		salary.setTaxamount(4300);
		salary.setSpecialallowancesalary(6000);
		employee.setSalary(salary);

		repository.save(employee);

	}

}
