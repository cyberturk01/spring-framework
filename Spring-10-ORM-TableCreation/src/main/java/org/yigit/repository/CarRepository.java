package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yigit.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
