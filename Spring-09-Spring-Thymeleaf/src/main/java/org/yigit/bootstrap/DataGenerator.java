package org.yigit.bootstrap;

import com.github.javafaker.Faker;
import org.yigit.model.Student;

import java.util.Arrays;
import java.util.List;

public class DataGenerator {
    static Faker f = new Faker();

    public static List<Student> createStudent() {
        return Arrays.asList(
                new Student(f.name().firstName(), f.name().lastName(), f.number().numberBetween(20, 90), f.address().state()),
                new Student(f.name().firstName(), f.name().lastName(), f.number().numberBetween(20, 90), f.address().state()),
                new Student(f.name().firstName(), f.name().lastName(), f.number().numberBetween(20, 90), f.address().state()),
                new Student(f.name().firstName(), f.name().lastName(), f.number().numberBetween(20, 90), f.address().state()),
                new Student(f.name().firstName(), f.name().lastName(), f.number().numberBetween(20, 90), f.address().state()),
                new Student(f.name().firstName(), f.name().lastName(), f.number().numberBetween(20, 90), f.address().state()),
                new Student(f.name().firstName(), f.name().lastName(), f.number().numberBetween(20, 90), f.address().state())
        );
    }

    public static String getByName(String name){
        return createStudent().stream()
                .filter(a->a.getFirstName().equals(name))
                .findFirst()
                .orElseThrow(()->new RuntimeException("No Student found"))
                .getFirstName();
    }
}
