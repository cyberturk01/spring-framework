package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yigit.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
