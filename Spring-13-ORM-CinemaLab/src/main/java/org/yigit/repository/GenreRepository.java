package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yigit.entity.Genre;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres
    @Query("SELECT g from Genre g")
    List<Genre> fetchAll();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name

    @Query(nativeQuery = true,
            value = "SELECT * from genre  where name ilike concat('%',?1,'%')")
    List<Genre> findAllByNameContaining(String name);

}
