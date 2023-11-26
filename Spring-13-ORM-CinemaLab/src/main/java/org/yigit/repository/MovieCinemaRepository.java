package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yigit.entity.Cinema;
import org.yigit.entity.Movie;
import org.yigit.entity.MovieCinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository

public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> findById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countAllByCinemaId(Long id);
    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countAllByMovieId(Long id);
    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByDateTimeGreaterThan(LocalDateTime date);
    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findTop3ByOrderByMoviePriceDesc();

    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findAllByMovieNameContaining(String name);

    //Write a derived query to list all movie cinemas in a specific location
    List<MovieCinema> findAllByCinema_Location_Name(String name);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("SELECT m from MovieCinema m where m.dateTime > ?1")
    List<MovieCinema> getAllCinemaGreaterSpecificDate(LocalDateTime dateTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(nativeQuery = true,
            value = "SELECT count(id) from movie_cinema where cinema_id=?1")
    Integer countAllCinemaById(Long cinemaId);

    //Write a native query that returns all movie cinemas by location name
    @Query(nativeQuery = true,
            value = "select * from movie_cinema mc " +
                    "join cinema c on mc.cinema_id = c.id " +
                    "join location l on c.location_id = l.id " +
                    "where l.name = ?1 ")
    List<MovieCinema> getAllByLocationName(String name);


}
