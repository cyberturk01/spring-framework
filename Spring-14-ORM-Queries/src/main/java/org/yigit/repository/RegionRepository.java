package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yigit.entity.Region;

public interface RegionRepository extends JpaRepository<Region,Long> {
}
