package org.yigit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yigit.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    User findByEmail(String email);

    //Write a derived query to read a user with a username?
    User findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<User> findAllByUsernameContaining(String name);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findAllByUsernameIgnoreCaseContaining(String name);
    //Write a derived query to list all users with an age greater than a specified age?
    List<User> findAllByAccount_AgeGreaterThan(Integer age);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("select u from User u where u.email= ?1")
    User getByEmail(String email);

    //Write a JPQL query that returns a user read by username?
    @Query("select u from User u where u.username= ?1")
    User getByUsername(String username);

    //Write a JPQL query that returns all users?
    @Query("select u from User u")
    List<User> getAllUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(nativeQuery = true,
            value = "select * from user_account ua where ua.email= ?1")
    List<User> getAllByEmail(String email);

    //Write a native query that returns all users?
    @Query(nativeQuery = true,
            value = "select * from user_account")
    List<User> fetchAllUsers();

    //Write a native query that returns all users in the range of ages?
    @Query(nativeQuery = true,
            value = "select * from user_account as m " +
                    "join account_details as ad ON m.account_details_id = ad.id " +
                    "where ad.age between ?1 and ?2 ")
    List<User> fetchAllByInRange(Integer a, Integer b);

    //Write a native query to read a user by email?

    @Query(nativeQuery = true,
            value = "select * from user_account as ua where ua.email= ?1 ")
    User fetchByEmail(String email);

}
