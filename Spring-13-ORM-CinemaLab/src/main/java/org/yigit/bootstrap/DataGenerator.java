package org.yigit.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yigit.enums.UserRole;
import org.yigit.repository.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;


    public DataGenerator(AccountRepository accountRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, MovieCinemaRepository movieCinemaRepository, MovieRepository movieRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("**************Account Start Here **********");
        System.out.println("findByCountryOrState: " + accountRepository.findAccountByCountryOrState("United States", "Kentucky"));
        System.out.println("findAllByAgeLessThanOrEquals: " + accountRepository.findAccountByAgeLessThanEqual(47));
        System.out.println("findByRole: " + accountRepository.findByRole(UserRole.USER));
        System.out.println("findByAgeBetween: " + accountRepository.findByAgeBetween(34,42));
        System.out.println("findByAddressStartingWith: " + accountRepository.findByAddressStartingWith("2903"));
        accountRepository.findByOrderByAgeAsc().forEach(System.out::println);
        accountRepository.findAllAccounts().forEach(System.out::println);
        System.out.println(accountRepository.findAllAdminAccounts());
        System.out.println(accountRepository.findAccountsSortByAge());
        System.out.println(accountRepository.findAllByAgeLessThan(36));
        System.out.println(accountRepository.findAccountByNameOrAddressContaining("Josie","262", "United","Kentu","LOUIS"));
        System.out.println(accountRepository.findAccountByAgeLessThan(36));
        System.out.println("**************Account End Here **********");

        System.out.println("**************Cinema Start Here **********");
        System.out.println(cinemaRepository.findByName("Hall 1 - EMPIRE"));
        System.out.println(cinemaRepository.findTop3OrderByNameContaining("EMPIRE"));
        System.out.println(cinemaRepository.findAllByLocation_Country("United States"));
        System.out.println(cinemaRepository.findAllCinemaByNameOrSponsoredName("Hall 4 - EMPIRE", "Quick Silver"));
        System.out.println(cinemaRepository.findCinemaNameWithId(1L));
        System.out.println(cinemaRepository.findAllCinemaByNameContainsPattern("ALL 2"));
//        System.out.println(cinemaRepository.findCinemaByLocationCountry("United States"));
        System.out.println("lll: "+cinemaRepository.findAllCinemaByName());
        System.out.println("lll: "+cinemaRepository.findAllCinemaDistinctBySponsoredName());

        System.out.println("**************Cinema End Here **********");
        System.out.println(genreRepository.findAllByNameContaining("Comedy"));
        System.out.println(genreRepository.fetchAll());

        System.out.println("**************Movie Cinema End Here **********");
        System.out.println("movieCinema: "+movieCinemaRepository.findById(1L));
        System.out.println("movieCinema: "+movieCinemaRepository.countAllByCinemaId(1L));
        System.out.println("movieCinema: "+movieCinemaRepository.countAllByMovieId(1L));
        System.out.println("movieCinema: "+movieCinemaRepository.findAllByDateTimeGreaterThan(LocalDateTime.of(2020, Month.DECEMBER,5,6,30,40,50000)));
        System.out.println("movieCinema: "+movieCinemaRepository.findTop3ByOrderByMoviePriceDesc());
        System.out.println("movieCinema: "+movieCinemaRepository.findAllByMovieNameContaining("A Beautiful Mind"));
        System.out.println("movieCinema: "+movieCinemaRepository.findAllByCinema_Location_Name("AMC Empire 25"));
        System.out.println("movieCinema: "+movieCinemaRepository.getAllCinemaGreaterSpecificDate(LocalDateTime.of(2020, Month.DECEMBER,5,6,30,40,50000)));
        System.out.println("movieCinema: "+movieCinemaRepository.countAllCinemaById(1L));
//        System.out.println("movieCinema: "+movieCinemaRepository.getAllByLocationName("AMC 34th Street 14"));

        System.out.println("**************Movie Start HERe **********");
        System.out.println("movie: "+movieRepository.fetchTop5ExpensiveMovies());
        System.out.println("movie: "+movieRepository.fetchByName("Avengers: Endgame"));

        System.out.println("**************User Start HERe **********");
        System.out.println("user: "+userRepository.findAllByUsernameContaining("bernard"));
        System.out.println("user: "+userRepository.findAllByUsernameIgnoreCaseContaining("Bernard"));
        System.out.println("user: "+userRepository.findAllByAccount_AgeGreaterThan(35));
        System.out.println("All users: "+userRepository.getAllUsers());
        System.out.println("All users: "+userRepository.fetchAllUsers());
        System.out.println("All users: "+userRepository.fetchAllByInRange(34,42));
        System.out.println("All users: "+userRepository.fetchByEmail("josie_story@email.com"));
        System.out.println("All users: "+userRepository.getAllByEmail("josie_story@email.com"));
        System.out.println("All users: "+userRepository.findByEmail("josie_story@email.com"));



    }
}
