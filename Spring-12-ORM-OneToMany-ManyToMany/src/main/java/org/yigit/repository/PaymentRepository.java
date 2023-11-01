package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yigit.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // method --sql -- derive query findById(int id) -> Select * from Payment where id = 'id'

    //sql - @Query

    //JPQL  - @Query
}
