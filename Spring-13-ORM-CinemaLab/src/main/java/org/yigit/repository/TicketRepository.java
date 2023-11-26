package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yigit.entity.Movie;
import org.yigit.entity.MovieCinema;
import org.yigit.entity.Ticket;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countAllByUserAccountId(Long id);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserAccount_Email(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinema_Movie_Name(String name);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t from Ticket t where t.userAccount.id= ?1")
    List<Ticket> getAllByUserAccount(Long id);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("select t from Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> getAllBetweenDates(LocalDateTime d1, LocalDateTime d2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(nativeQuery = true,
            value = "select count(t.id) from ticket t "+
                    "where t.user_account_id= ?1")
    Integer countAllTicketsByUserAccountId(Long id);
    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(nativeQuery = true,
            value = "SELECT count(t.id) from ticket t " +
                    "where t.user_account_id = ?1 " +
                    "And t.date_time between ?2 and ?3")
    Integer countTicketByUserIdInDateRange(Long userId,  LocalDateTime dateTime1, LocalDateTime dateTime2);

    //Write a native query to distinct all tickets by movie name
    @Query(nativeQuery = true,
            value = "SELECT DISTINCT(m.name) FROM ticket t " +
                    "JOIN movie_cinema mc ON t.movie_cinema_id = mc.id " +
                    "JOIN movie m ON mc.movie_id = m.id")
    List<String> findAllByDistinctMovieName();
    //Write a native query to find all tickets by user email
    @Query(nativeQuery = true,
            value = "SELECT * FROM ticket t " +
                    "JOIN user_account ua ON t.user_account_id = ua.id " +
                    "WHERE ua.email = ?1")
    List<Ticket> findAllByUserEmail(String email);

    //Write a native query that returns all tickets
    @Query(nativeQuery = true,
            value = "SELECT * FROM ticket")
    List<Ticket> retrieveAll();

    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name

    @Query(nativeQuery = true,
            value = "SELECT * FROM ticket t " +
                    "JOIN user_account ua ON t.user_account_id = ua.id " +
                    "JOIN account_details ad ON ua.account_details_id = ad.id " +
                    "JOIN movie_cinema mc ON t.movie_cinema_id = mc.id " +
                    "JOIN movie m ON mc.movie_id = m.id " +
                    "WHERE ua.username ILIKE concat('%',?1,'%') " +
                    "OR ad.name ILIKE concat('%',?1,'%') " +
                    "OR m.name ILIKE concat('%',?1,'%')")
    List<Ticket> retrieveAllBySearchCriteria(String keyword);

}
