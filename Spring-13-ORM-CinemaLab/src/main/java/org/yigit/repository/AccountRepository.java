package org.yigit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yigit.entity.Account;
import org.yigit.enums.UserRole;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findAccountByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findAccountByAgeLessThanEqual(int age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(int age1,int age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressStartingWith(String word);

    //Write a derived query to sort the list of accounts with age
    List<Account> findByOrderByAge();

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT e from Account e ")
    List<Account> findAllAccounts();

    //Write a JPQL query to list all admin accounts
    @Query("SELECT e from Account e where e.role = ?1")
    List<Account> findAllAdminAccounts(UserRole role);

    //Write a JPQL query to sort all accounts with age
    @Query("SELECT e from Account e order by e.age")
    List<Account> findAccountsSortByAge();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * from account_details e where e.age< :age", nativeQuery = true)
    List<Account> findAllByAgeLessThan(@Param("age") int age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * from account_details as e where strpos( e.name , tag_name) > 0 ", nativeQuery = true)
    List<Account> findAccountByAddressContaining(@Param("name") String name);

    //Write a native query to read all accounts with an age lower than a specific value

}