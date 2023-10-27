package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yigit.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
