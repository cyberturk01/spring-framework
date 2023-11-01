package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yigit.entity.Region;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {
    List<Region> findByCountry(String country);
    List<Region> findDistinctByCountry(String country);
    List<Region> findByCountryContains(String country);
    List<Region> findByCountryContainingOrderByCountry(String country);
    List<Region> findTop2ByCountry(String country);
}
