package org.yigit.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yigit.enums.UserRole;
import org.yigit.repository.AccountRepository;

@Component
public class DataGenerator implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public DataGenerator(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
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
    }
}
