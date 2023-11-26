package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yigit.entity.Movie;
import org.yigit.enums.MovieState;
import org.yigit.enums.MovieType;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Optional<Movie> findByName(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> findAllByPriceBetween(BigDecimal priceStart, BigDecimal priceEnd);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findAllByDurationIn(List<Integer> durations);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findAllByReleaseDateGreaterThan(LocalDate releaseDate);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> findAllByStateAndType(MovieState state, MovieType type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("select m from Movie m where m.price between ?1 and ?2")
    List<Movie> getAllByPriceBetween(BigDecimal priceStart, BigDecimal priceEnd);

    //Write a JPQL query that returns all movie names
    @Query("SELECT m.name from Movie m")
    List<Movie> getAllMovieNames();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(nativeQuery = true,
            value = "select * from movie m where m.name=?1")
    Movie fetchByName(String name);

    //Write a native query that return the list of movies in a specific range of prices
    @Query(nativeQuery = true,
            value = "select * from movie m where m.price between ?1 and ?2")
    List<Movie> fetchAllByPriceRange(BigDecimal priceStart, BigDecimal priceEnd);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(nativeQuery = true,
            value = "SELECT * from movie m where m.duration in ?1")
    List<Movie> fetchAllByDurationInRange(List<Integer> duration);

    //Write a native query to list the top 5 most expensive movies
    @Query(nativeQuery = true,
            value = "select * from movie m " +
                    "order by m.price desc " +
                    "LIMIT 5")
    List<Movie> fetchTop5ExpensiveMovies();

}