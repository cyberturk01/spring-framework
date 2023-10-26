package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yigit.entity.Department;

@Repository
public interface DepartmentsRepository extends JpaRepository<Department, Long> {
}
