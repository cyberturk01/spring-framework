package org.yigit.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yigit.entity.Location;
import org.yigit.enums.UserRole;
import org.yigit.repository.AccountRepository;
import org.yigit.repository.CinemaRepository;

@Component
public class DataGenerator implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;


    public DataGenerator(AccountRepository accountRepository, CinemaRepository cinemaRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("**************Account Start Here **********");
        System.out.println("findByCountryOrState: " + accountRepository.findAccountByCountryOrState("United States", "Kentucky"));
        System.out.println("findAllByAgeLessThanOrEquals: " + accountRepository.findAccountByAgeLessThanEqual(47));
        System.out.println("findByRole: " + accountRepository.findByRole(UserRole.USER));
        System.out.println("findByAgeBetween: " + accountRepository.findByAgeBetween(34,42));
        System.out.println("findByAddressStartingWith: " + accountRepository.findByAddressStartingWith("2903"));
        accountRepository.findByOrderByAge().forEach(System.out::println);
        accountRepository.findAllAccounts().forEach(System.out::println);
        System.out.println(accountRepository.findAllAdminAccounts(UserRole.ADMIN));
        System.out.println(accountRepository.findAccountsSortByAge());
        System.out.println(accountRepository.findAllByAgeLessThan(36));
        System.out.println(accountRepository.findAccountByNameOrAddressContaining("Josie","262", "United","Kentu","LOUIS"));
        System.out.println(accountRepository.findAccountByAgeLessThan(36));
        System.out.println("**************Account End Here **********");

        System.out.println("**************Cinema Start Here **********");
        System.out.println(cinemaRepository.findByName("Hall 1 - EMPIRE"));
        System.out.println(cinemaRepository.findTop3OrderByNameContaining("EMPIRE"));
        System.out.println(cinemaRepository.findAllByLocationCountry("United States"));
        System.out.println(cinemaRepository.findAllCinemaByNameOrSponsoredName("Hall 4 - EMPIRE", "Quick Silver"));
        System.out.println(cinemaRepository.findCinemaNameWithId(3L));

        System.out.println("**************Cinema End Here **********");
    }
}
