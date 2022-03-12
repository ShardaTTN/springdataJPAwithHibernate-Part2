package com.tothenew.sharda.Repositories;


import org.springframework.data.repository.CrudRepository;
import com.tothenew.sharda.Entities.Payment;
 

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}