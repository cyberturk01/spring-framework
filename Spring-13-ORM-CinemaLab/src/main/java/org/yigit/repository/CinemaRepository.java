package org.yigit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yigit.entity.Cinema;
import org.yigit.entity.Location;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3OrderByNameContaining(String name);

    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findAllByLocation_Country(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findAllCinemaByNameOrSponsoredName(String name, String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("SELECT e.name from Cinema e where e.id=?1")
    String findCinemaNameWithId(Long id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "SELECT * FROM cinema c join location l " +
            "on c.location_id = l.id  where l.country= ?1",nativeQuery = true)
    List<Cinema> findCinemaByLocationCountry(String country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query( value = "SELECT * from cinema as c " +
            "where c.name ilike concat('%',:pattern,'%') " +
            "or c.sponsored_name like concat('%',:pattern,'%') ",nativeQuery = true)
    List<Cinema> findAllCinemaByNameContainsPattern(String pattern);

    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * from cinema as c ORDER BY c.name", nativeQuery = true)
    List<Cinema> findAllCinemaByName();
    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT distinct sponsored_name from cinema", nativeQuery = true)
    List<String> findAllCinemaDistinctBySponsoredName();


}
